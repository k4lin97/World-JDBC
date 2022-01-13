package dao.countrylanguage;

import java.util.List;

public interface CountryLanguageDAOi<T> {
    List<T> getCountriesByCountryCode(String countryCode);
}
