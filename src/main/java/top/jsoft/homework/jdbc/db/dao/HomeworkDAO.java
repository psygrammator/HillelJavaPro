package top.jsoft.homework.jdbc.db.dao;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.jdbc.db.DataBaseConnection;
import top.jsoft.homework.jdbc.db.dto.Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class HomeworkDAO {
    public void addHomework(Homework homework) {
        try (Connection con = DataBaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO homework(name, description) VALUES (?,?)"))
        {
            preparedStatement.setString(1, homework.getName());
            preparedStatement.setString(2, homework.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            PrintManager.error("Error addHomework: Homework(" + homework + ") " + e);
        }
    }

    public List<Homework> getHomeworks() {
        List<Homework> homeworkList = new ArrayList<>();
        try (Connection con = DataBaseConnection.getInstance().getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM homework"))
        {
            while (resultSet.next()) {
                homeworkList.add(new Homework(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description")));
            }
        } catch (SQLException e) {
            PrintManager.error("Error getHomeworks: " + e);
        }
        return homeworkList;
    }

    public boolean checkExistsId(int id) {
        try (Connection con = DataBaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("SELECT exists(SELECT 1 FROM homework AS h WHERE h.id=?) AS exist"))
        {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBoolean("exist");
                }
            }
        } catch (SQLException e) {
            PrintManager.error("Error checkExistsId: Id(" + id + ") " + e);
        }
        return false;
    }

    public static HomeworkDAO getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder
    {
        public static final HomeworkDAO INSTANCE = new HomeworkDAO();
    }
}