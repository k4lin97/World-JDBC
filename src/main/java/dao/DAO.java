package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {
    protected static final String SELECT_ALL = "SELECT * FROM ";

    protected List<T> getAll(String query) {
        List<T> list = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            list = createListFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Couldn't create a list: " + e.getMessage());
        } finally {
            DatabaseConnector.closeConnection();
        }
        return list;
    }

    protected List<T> getByTableColumn(String query, String columnName) {
        List<T> list = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(query)) {
            statement.setString(1, columnName);
            ResultSet resultSet = statement.executeQuery();
            list = createListFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Couldn't create a list: " + e.getMessage());
        } finally {
            DatabaseConnector.closeConnection();
        }
        return list;
    }

    protected abstract List<T> createListFromResultSet(ResultSet resultSet) throws SQLException;
}
