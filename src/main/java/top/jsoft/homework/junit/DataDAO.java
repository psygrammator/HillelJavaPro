package top.jsoft.homework.junit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class DataDAO {
    private final Connection connection;

    public DataDAO(Connection connection) {
        this.connection = connection;
    }

    public void addData(List<String> data) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO hillel_2023.data(data) VALUES (?)")) {
            for (String s : data) {
                preparedStatement.setString(1, s);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getData() {
        List<String> data = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT data FROM hillel_2023.data"))
        {
            while (resultSet.next()) {
                data.add(resultSet.getString("data"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void clearData() {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM hillel_2023.data")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}