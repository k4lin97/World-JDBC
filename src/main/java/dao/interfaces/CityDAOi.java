package dao.interfaces;

import dao.NumRange;

import java.util.List;

public interface CityDAOi<T> extends DAOi {
    List<T> getCitiesByCountryCode(String countryCodeToFind);
}
