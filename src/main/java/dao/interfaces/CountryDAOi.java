package dao.interfaces;

import java.util.List;

public interface CountryDAOi<T> extends DAOi {
    List<T> getCountriesByContinent(String continentName);
}
