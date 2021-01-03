package mehdi.example.exchange.configuration;

public class Country {
    private double fixedCost;
    private double incomeTax;

    private String countryCode;

    private String currency;

    public Country(double fixedCost, double incomeTax, String countryCode, String currency) {
        this.fixedCost = fixedCost;
        this.incomeTax = incomeTax;
        this.countryCode = countryCode;
        this.currency = currency;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCurrency() {
        return currency;
    }
}
