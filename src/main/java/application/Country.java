package application;

public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private double surfaceArea;
    private int independenceYear;
    private long population;
    private double lifeExpectancy;
    private double gnp;
    private double gnpOld;
    private String localName;
    private String governmentFrom;
    private String headOfState;
    private int capital;
    private String code2;

    public Country(String code, String name, String continent, String region, double surfaceArea,
                   int independenceYear, long population, double lifeExpectancy, double gnp, double gnpOld, String localName,
                   String governmentFrom, String headOfState, int capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.independenceYear = independenceYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentFrom = governmentFrom;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
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

    public String getRegion() {
        return region;
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

    public double getGnp() {
        return gnp;
    }

    public double getGnpOld() {
        return gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public String getGovernmentFrom() {
        return governmentFrom;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public String getCode2() {
        return code2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(code);
        stringBuilder.append(" - ");
        stringBuilder.append(name);
        return stringBuilder.toString();
    }
}
