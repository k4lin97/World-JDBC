package gui;

import application.City;
import application.Country;
import application.CountryLanguage;
import dao.city.CityDAO;
import dao.country.CountryDAO;
import dao.countrylanguage.CountryLanguageDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;
import java.util.Vector;

class Display {
    private static JTable jTable;

    private static void displayTable() {
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "World-JDBC", JOptionPane.INFORMATION_MESSAGE);
    }

    static void displayCities() {
        CityDAO cityDAO = new CityDAO();
        List<City> cities = cityDAO.getAll();
        displayCityTable(cities);
    }

    static void displayCitiesByCountryCode(String countryCode) {
        CityDAO cityDAO = new CityDAO();
        List<City> cities = cityDAO.getCitiesByCountryCode(countryCode);
        displayCityTable(cities);
    }

    private static void displayCityTable(List<City> cities) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Name");
        columnNames.add("Country code");
        columnNames.add("District");
        columnNames.add("Population");

        if (cities.isEmpty()) {
            jTable = new JTable(null, columnNames);
            displayTable();
            return;
        } else {
            Vector<Vector> data = new Vector<>();
            for (City city : cities) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(city.getName()));
                row.add(String.valueOf(city.getCountryCode()));
                row.add(String.valueOf(city.getDistrict()));
                row.add(String.valueOf(city.getPopulation()));

                data.add(row);
            }
            jTable = new JTable(data, columnNames);
        }

        displayTable();
    }

    static void displayCountries() {
        CountryDAO countryDAO = new CountryDAO();
        List<Country> countries = countryDAO.getAll();
        displayCountryTable(countries);
    }

    static void displayCountriesByContinent(String continent) {
        CountryDAO countryDAO = new CountryDAO();
        List<Country> countries = countryDAO.getCountriesByContinent(continent);
        displayCountryTable(countries);
    }

    private static void displayCountryTable(List<Country> countries) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Code");
        columnNames.add("Name");
        columnNames.add("Continent");
        columnNames.add("Surface area");
        columnNames.add("Independence year");
        columnNames.add("Population");
        columnNames.add("Life Expectancy");
        columnNames.add("Capital");

        if (countries.isEmpty()) {
            jTable = new JTable(null, columnNames);
            displayTable();
            return;
        } else {
            Vector<Vector> data = new Vector<>();
            for (Country country : countries) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(country.getCode()));
                row.add(String.valueOf(country.getName()));
                row.add(String.valueOf(country.getContinent()));
                row.add(String.valueOf(country.getSurfaceArea()));
                row.add(String.valueOf(country.getIndependenceYear()));
                row.add(String.valueOf(country.getPopulation()));
                row.add(String.valueOf(country.getLifeExpectancy()));
                row.add(String.valueOf(country.getCapital()));

                data.add(row);
            }
            jTable = new JTable(data, columnNames);
        }

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "World-JDBC", JOptionPane.INFORMATION_MESSAGE);
    }

    static void displayLanguages() {
        CountryLanguageDAO countryLanguageDAO = new CountryLanguageDAO();
        List<CountryLanguage> countryLanguages = countryLanguageDAO.getAll();
        displayLanguageTable(countryLanguages);
    }

    static void displayLanguagesByCountryCode(String countryCode) {
        CountryLanguageDAO countryLanguageDAO = new CountryLanguageDAO();
        List<CountryLanguage> countryLanguages = countryLanguageDAO.getCountriesByCountryCode(countryCode);
        displayLanguageTable(countryLanguages);
    }

    private static void displayLanguageTable(List<CountryLanguage> countryLanguages) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Country Code");
        columnNames.add("Language");
        columnNames.add("Is official");
        columnNames.add("Percentage");

        if (countryLanguages.isEmpty()) {
            jTable = new JTable(null, columnNames);
            displayTable();
            return;
        } else {
            Vector<Vector> data = new Vector<>();
            for (CountryLanguage countryLanguage : countryLanguages) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(countryLanguage.getCountryCode()));
                row.add(String.valueOf(countryLanguage.getLanguage()));
                row.add(String.valueOf(countryLanguage.isOfficial()));
                row.add(String.valueOf(countryLanguage.getPercentage()));

                data.add(row);
            }
            jTable = new JTable(data, columnNames);
        }

        displayTable();
    }
}
