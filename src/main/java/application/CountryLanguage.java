package application;

public class CountryLanguage {
    private String countryCode;
    private String language;
    private boolean isOfficial;
    private double percentage;

    public CountryLanguage(String countryCode, String language, boolean isOfficial, double percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Code: ");
        stringBuilder.append(countryCode);
        stringBuilder.append(", language: ");
        stringBuilder.append(language);
        stringBuilder.append(", is official: ");
        stringBuilder.append(isOfficial);
        stringBuilder.append(", percentage: ");
        stringBuilder.append(percentage);

        return stringBuilder.toString();
    }
}
