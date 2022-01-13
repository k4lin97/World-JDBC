package dao.country;

import application.Country;
import dao.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends DAO<Country> implements CountryDAOi<Country> {
    private static final String TABLE_NAME = "country";
    private static final String TABLE_COLUMN_CODE = "Code";
    private static final String TABLE_COLUMN_NAME = "Name";
    private static final String TABLE_COLUMN_CONTINENT = "Continent";
    private static final String TABLE_COLUMN_SURFACE_AREA = "SurfaceArea";
    private static final String TABLE_COLUMN_INDEPENDENCE_YEAR = "IndepYear";
    private static final String TABLE_COLUMN_POPULATION = "Population";
    private static final String TABLE_COLUMN_LIFE_EXPECTANCY = "LifeExpectancy";
    private static final String TABLE_COLUMN_CAPITAL = "Capital";

    private static final String WHERE_CONTINENT = " WHERE " + TABLE_COLUMN_CONTINENT + " = ?";

    private String query;

    public List<Country> getAll() {
        query = SELECT_ALL + TABLE_NAME;
        return getAll(query);
    }

    @Override
    public List<Country> getCountriesByContinent(String continentName) {
        query = SELECT_ALL + TABLE_NAME + WHERE_CONTINENT;
        return getByTableColumn(query, continentName);
    }

    @Override
    protected List<Country> createListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Country> list = new ArrayList<>();
        String code;
        String name;
        String continent;
        double surfaceArea;
        int independenceYear;
        long population;
        double lifeExpectancy;
        int capital;
        while (resultSet.next()) {
            code = resultSet.getString(TABLE_COLUMN_CODE);
            name = resultSet.getString(TABLE_COLUMN_NAME);
            continent = resultSet.getString(TABLE_COLUMN_CONTINENT);
            surfaceArea = resultSet.getDouble(TABLE_COLUMN_SURFACE_AREA);
            independenceYear = resultSet.getInt(TABLE_COLUMN_INDEPENDENCE_YEAR);
            population = resultSet.getLong(TABLE_COLUMN_POPULATION);
            lifeExpectancy = resultSet.getDouble(TABLE_COLUMN_LIFE_EXPECTANCY);
            capital = resultSet.getInt(TABLE_COLUMN_CAPITAL);
            list.add(new Country(code, name, continent, surfaceArea, independenceYear, population,
                    lifeExpectancy, capital));
        }
        return list;
    }
}
