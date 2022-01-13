package application;

public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int independenceYear;
    private long population;
    private double lifeExpectancy;
    private int capital;

    public Country(String code, String name, String continent, double surfaceArea,
                   int independenceYear, long population, double lifeExpectancy, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.independenceYear = independenceYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public int getIndependenceYear() {
        return independenceYear;
    }

    public long getPopulation() {
        return population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public int getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Code: ");
        stringBuilder.append(code);
        stringBuilder.append(", name: ");
        stringBuilder.append(name);
        stringBuilder.append(", continent: ");
        stringBuilder.append(continent);
        stringBuilder.append(", surface area: ");
        stringBuilder.append(surfaceArea);
        stringBuilder.append(", independence year: ");
        stringBuilder.append(independenceYear);
        stringBuilder.append(", population: ");
        stringBuilder.append(population);
        stringBuilder.append(", life expectancy: ");
        stringBuilder.append(lifeExpectancy);
        stringBuilder.append(", capital: ");
        stringBuilder.append(capital);

        return stringBuilder.toString();
    }
}
