package dao.city;

import java.util.List;

public interface CityDAOi<T> {
    List<T> getCitiesByCountryCode(String countryCodeToFind);
}
