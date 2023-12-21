package top.jsoft.homework.jdbc.db.dao;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.jdbc.db.DataBaseConnection;
import top.jsoft.homework.jdbc.db.dto.Lesson;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class LessonDAO {
    public void addLesson(Lesson lesson){
        try(Connection con = DataBaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO lesson(name, updatedAt, homework_id) values (?,?,?)"))
        {
            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(3, lesson.getHomework());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            PrintManager.error("Error AddLesson: Lesson(" + lesson + ") " + e);
        }
    }

    public void deleteLesson(int id){
        try(Connection con = DataBaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM lesson WHERE id=?"))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            PrintManager.error("Error deleteLesson: Id(" + id + ") " + e);
        }
    }

    public List<Lesson> getLessons() {
        List<Lesson> lessonList = new ArrayList<>();
        try (Connection con = DataBaseConnection.getInstance().getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT l.id, l.name, l.updatedAt, l.homework_id, h.name AS homework FROM lesson AS l JOIN homework h ON h.id = l.homework_id"))
        {
            while (resultSet.next()) {
                lessonList.add(new Lesson(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("updatedAt"), resultSet.getInt("homework_id")));
            }
        } catch (SQLException e) {
            PrintManager.error("Error getLessons: " + e);
        }
        return lessonList;
    }
    public Lesson getLessonId(int id) {
        try (Connection con = DataBaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("SELECT l.id, l.name, l.updatedAt, l.homework_id, h.name AS homework FROM lesson AS l JOIN homework h ON h.id = l.homework_id WHERE l.id=?"))
        {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Lesson(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("updatedAt"),
                            resultSet.getInt("homework_id"));
                }
            }
        } catch (SQLException e) {
            PrintManager.error("Error getLessonId: Id(" + id + ") " + e);
        }
        return null;
    }

    public static LessonDAO getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder
    {
        public static final LessonDAO INSTANCE = new LessonDAO();
    }
}