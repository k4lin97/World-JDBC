package dao.country;

import java.util.List;

public interface CountryDAOi<T> {
    List<T> getCountriesByContinent(String continentName);
}
