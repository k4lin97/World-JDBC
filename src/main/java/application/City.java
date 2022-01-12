package application;

public class City {
    private String name;
    private String countryCode;
    private String district;
    private int population;

    public City(String name, String countryCode, String district, int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(name);
        stringBuilder.append(", country code: ");
        stringBuilder.append(countryCode);
        stringBuilder.append(", district: ");
        stringBuilder.append(district);
        stringBuilder.append(", population: ");
        stringBuilder.append(population);
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }
}
