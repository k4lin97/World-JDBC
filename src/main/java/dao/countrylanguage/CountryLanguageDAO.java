package dao.countrylanguage;

import application.Country;
import application.CountryLanguage;
import dao.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryLanguageDAO extends DAO<CountryLanguage> implements CountryLanguageDAOi<CountryLanguage> {
    private static final String TABLE_NAME = "countrylanguage";
    private static final String TABLE_COLUMN_COUNTRY_CODE = "CountryCode";
    private static final String TABLE_COLUMN_LANGUAGE = "Language";
    private static final String TABLE_COLUMN_IS_OFFICIAL = "IsOfficial";
    private static final String TABLE_COLUMN_PERCENTAGE = "Percentage";

    private static final String WHERE_COUNTRY_CODE = " WHERE " + TABLE_COLUMN_COUNTRY_CODE + " = ?";

    private String query;

    public List<CountryLanguage> getAll() {
        query = SELECT_ALL + TABLE_NAME;
        return getAll(query);
    }

    @Override
    public List<CountryLanguage> getCountriesByCountryCode(String countryCode) {
        query = SELECT_ALL + TABLE_NAME + WHERE_COUNTRY_CODE;
        return getByTableColumn(query, countryCode);
    }

    @Override
    protected List<CountryLanguage> createListFromResultSet(ResultSet resultSet) throws SQLException {
        List<CountryLanguage> list = new ArrayList<>();
        String countryCode;
        String language;
        boolean isOfficial;
        double percentage;
        while (resultSet.next()) {
            countryCode = resultSet.getString(TABLE_COLUMN_COUNTRY_CODE);
            language = resultSet.getString(TABLE_COLUMN_LANGUAGE);
            isOfficial = resultSet.getBoolean(TABLE_COLUMN_IS_OFFICIAL);
            percentage = resultSet.getDouble(TABLE_COLUMN_PERCENTAGE);
            list.add(new CountryLanguage(countryCode, language, isOfficial, percentage));
        }
        return list;
    }
}
