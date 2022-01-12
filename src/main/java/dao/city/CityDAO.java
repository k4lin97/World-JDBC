package dao.city;

import application.City;
import dao.DAO;
import dao.DatabaseConnector;
import dao.NumRange;
import dao.interfaces.CityDAOi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends DAO<City> implements CityDAOi<City> {
    private static final String TABLE_NAME = "city";
    private static final String TABLE_COLUMN_NAME = "Name";
    private static final String TABLE_COLUMN_COUNTRY_CODE = "CountryCode";
    private static final String TABLE_COLUMN_DISTRICT = "District";
    private static final String TABLE_COLUMN_POPULATION = "Population";

    private static final String WHERE_COUNTRY_CODE = " WHERE CountryCode = ?";
    private static final String WHERE_POPULATION_OVER = " WHERE Population > ?";
    private static final String WHERE_POPULATION_EQUAL = " WHERE Population = ?";
    private static final String WHERE_POPULATION_UNDER = " WHERE Population < ?";

    private List<City> list = new ArrayList<>();
    private String query;

    @Override
    public List<City> getAll() {
        query = SELECT_ALL + TABLE_NAME;
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

    @Override
    public List<City> getCitiesByCountryCode(String countryCodeToFind) {
        query = SELECT_ALL + TABLE_NAME + WHERE_COUNTRY_CODE;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(query)) {
            statement.setString(1, countryCodeToFind);
            ResultSet resultSet = statement.executeQuery();
            createListFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Couldn't create a list: " + e.getMessage());
        } finally {
            DatabaseConnector.closeConnection();
        }
        return list;
    }

    @Override
    public List<City> getByPopulation(NumRange popEnum, int population) {
        switch (popEnum) {
            case OVER:
                query = SELECT_ALL + TABLE_NAME + WHERE_POPULATION_OVER;
                break;
            case EQUAL:
                query = SELECT_ALL + TABLE_NAME + WHERE_POPULATION_EQUAL;
                break;
            case UNDER:
                query = SELECT_ALL + TABLE_NAME + WHERE_POPULATION_UNDER;
                break;
            default:
                return list;
        }

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(query)) {
            statement.setInt(1, population);
            ResultSet resultSet = statement.executeQuery();
            createListFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Couldn't create a list: " + e.getMessage());
        } finally {
            DatabaseConnector.closeConnection();
        }
        return list;
    }

//    private void createListFromResultSet(ResultSet resultSet) throws SQLException {
//        String name;
//        String countryCode;
//        String district;
//        int population;
//        while (resultSet.next()) {
//            name = resultSet.getString(TABLE_COLUMN_NAME);
//            countryCode = resultSet.getString(TABLE_COLUMN_COUNTRY_CODE);
//            district = resultSet.getString(TABLE_COLUMN_DISTRICT);
//            population = resultSet.getInt(TABLE_COLUMN_POPULATION);
//            list.add(new City(name, countryCode, district, population));
//        }
//    }
}
