package dao.city;

import application.City;
import dao.DAO;

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

    private static final String WHERE_COUNTRY_CODE = " WHERE " + TABLE_COLUMN_COUNTRY_CODE + " = ?";

    private String query;

    public List<City> getAll() {
        query = SELECT_ALL + TABLE_NAME;
        return getAll(query);
    }

    @Override
    public List<City> getCitiesByCountryCode(String countryCodeToFind) {
        query = SELECT_ALL + TABLE_NAME + WHERE_COUNTRY_CODE;
        return getByTableColumn(query, countryCodeToFind);
    }

    @Override
    protected List<City> createListFromResultSet(ResultSet resultSet) throws SQLException {
        List<City> list = new ArrayList<>();
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
        return list;
    }
}
