import application.City;
import application.Country;
import application.CountryLanguage;
import dao.NumRange;
import dao.city.CityDAO;
import dao.country.CountryDAO;
import dao.countrylanguage.CountryLanguageDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        CountryDAO dao = new CountryDAO();
//        List<Country> list = dao.getCountriesByContinent("Europe");

//        CityDAO dao = new CityDAO();
//        List<City> list = dao.getByPopulation(NumRange.OVER, 5000000);

        CountryLanguageDAO dao = new CountryLanguageDAO();
        List<CountryLanguage> list = dao.getCountriesByCountryCode("ZWE");

//        for (City city: list) {
//            System.out.println(city);
//        }

        list.stream()
                .forEach(System.out::println);
    }
}
