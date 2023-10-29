package top.jsoft.homework.jdbc.db;

import org.mariadb.jdbc.MariaDbPoolDataSource;
import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.jdbc.Config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class DataBaseConnection {
    private static final MariaDbPoolDataSource DATABASE_POOL = new MariaDbPoolDataSource(Config.DATABASE_URL + "&user=" + Config.DATABASE_LOGIN + "&password=" + Config.DATABASE_PASSWORD + "&maxPoolSize=100");

    public static void init()
    {
        try
        {
            DATABASE_POOL.getConnection().close();
            PrintManager.info("DataBaseConnection: Initialized.");
        }
        catch (final Exception e)
        {
            PrintManager.error("DataBaseConnection: Problem on initialize. " + e);
        }
    }

    public Connection getConnection()
    {
        Connection con = null;
        while (con == null)
        {
            try
            {
                con = DATABASE_POOL.getConnection();
            }
            catch (final Exception e)
            {
                PrintManager.error("DataBaseConnection: Cound not get a connection. " + e);
            }
        }
        return con;
    }

    public void close()
    {
        try
        {
            DATABASE_POOL.close();
        }
        catch (final Exception e)
        {
            PrintManager.error("DataBaseConnection: There was a problem closing the data source. " + e);
        }
    }

    public void shutdown()
    {
        try {
            getConnection().close();
            PrintManager.info("DataBaseConnection: Database connection has been shut down.");
        } catch (Exception e) {
            PrintManager.error("DataBaseConnection: There was a problem closing the data source. " + e);
        }
    }
    public static DataBaseConnection getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder
    {
        public static final DataBaseConnection INSTANCE = new DataBaseConnection();
    }
}
