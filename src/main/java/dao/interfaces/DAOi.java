package dao.interfaces;

import application.City;
import dao.DatabaseConnector;
import dao.NumRange;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAOi<T> {
    List<T> getByPopulation(NumRange popEnum, int population);

    default List<T> getAll(String tableName) {
        String query = "SELECT * FROM " + tableName;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            createListFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Couldn't create a list: " + e.getMessage());
        } finally {
            DatabaseConnector.closeConnection();
        }
        return list;
    }

    default List<T> createListFromResultSet(ResultSet resultSet) throws SQLException {
        String name;
        String countryCode;
        String district;
        int population;
        while (resultSet.next()) {
            name = resultSet.getString(TABLE_COLUMN_NAME);
            countryCode = resultSet.getString(TABLE_COLUMN_COUNTRY_CODE);
            district = resultSet.getString(TABLE_COLUMN_DISTRICT);
            population = resultSet.getInt(TABLE_COLUMN_POPULATION);
            list.add(new City(name, countryCode, district, population));
        }
    }
}
