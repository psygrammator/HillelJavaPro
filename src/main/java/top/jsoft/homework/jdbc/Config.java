package top.jsoft.homework.jdbc;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Config {
    public static final String LOGGER_FILE = "./logger/config/db.ini";
    public static String DATABASE_DRIVER;
    public static String DATABASE_URL;
    public static String DATABASE_LOGIN;
    public static String DATABASE_PASSWORD;

    public static void load()
    {
        ExProperties database = new ExProperties(LOGGER_FILE);
        DATABASE_DRIVER = database.getString("Driver", "org.mariadb.jdbc.Driver");
        DATABASE_URL = database.getString("URL", "jdbc:mariadb://localhost:3306/hillel_2023");
        DATABASE_LOGIN = database.getString("Login", "root");
        DATABASE_PASSWORD = database.getString("Password", "root");
    }


}
