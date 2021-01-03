package mehdi.example.exchange.configuration;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountriesConfiguration {

    private Map<String, Country> countries = new HashMap<>();

    public CountriesConfiguration() {
        countries.put("PLN", new Country(400, 0.19,  "PL", "PLN"));
        countries.put("EUR", new Country(240, 0.20,  "DE", "EUR"));
        countries.put("GBP", new Country(200, 0.25,  "GB", "GBP"));
    }

    public Country getCountry(String currency) {
        return countries.get(currency);
    }

    public int getWorkingDays(){
        return 22;
    }
}
