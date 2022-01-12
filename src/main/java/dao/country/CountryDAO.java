package dao.country;

import application.Country;
import dao.DAO;
import dao.NumRange;
import dao.interfaces.CountryDAOi;

import java.util.List;

public class CountryDAO extends DAO<Country> implements CountryDAOi {
    @Override
    public List<Country> getAll() {
        return null;
    }

    @Override
    public List getCountriesByContinent(String continentName) {
        return null;
    }

    @Override
    public List getByPopulation(NumRange popEnum, int population) {
        return null;
    }
}
