package top.jsoft.homework.junit;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class DbStorage implements IStorage, AutoCloseable {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mariadb://localhost:3306/hillel_2023";

    private final Connection connection;
    private final DataDAO dataDAO;

    public DbStorage() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            dataDAO = new DataDAO(connection);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<String> getData() {
        return dataDAO.getData();
    }

    @Override
    public void save(List<String> data) {
        dataDAO.addData(data);
    }
    @Override
    public void clear() {
        dataDAO.clearData();
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
