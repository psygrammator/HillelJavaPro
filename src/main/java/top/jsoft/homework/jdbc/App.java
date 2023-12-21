package top.jsoft.homework.jdbc;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.jdbc.db.DataBaseConnection;
import top.jsoft.homework.jdbc.db.dao.HomeworkDAO;
import top.jsoft.homework.jdbc.db.dao.LessonDAO;
import top.jsoft.homework.jdbc.db.dto.Homework;
import top.jsoft.homework.jdbc.db.dto.Lesson;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Config.load();
        Class.forName(Config.DATABASE_DRIVER).getDeclaredConstructor().newInstance();
        DataBaseConnection.init();

        if (!HomeworkDAO.getInstance().checkExistsId(1)) {
            HomeworkDAO.getInstance().addHomework(new Homework("Home 1", "desc"));
        }
        HomeworkDAO.getInstance().getHomeworks().forEach(PrintManager::info);

        LessonDAO.getInstance().addLesson(new Lesson("lesson 1",1));
        LessonDAO.getInstance().getLessons().forEach(PrintManager::info);

        Lesson lesson = LessonDAO.getInstance().getLessonId(1);
        PrintManager.info(lesson);
        LessonDAO.getInstance().deleteLesson(1);

        DataBaseConnection.getInstance().shutdown();

    }
}
