package mehdi.example.exchange.srvices;

import mehdi.example.exchange.configuration.CountriesConfiguration;
import mehdi.example.exchange.configuration.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private CountriesConfiguration countriesConfiguration;

    public double calculateNetSalary(double dailyRate, String currency) {
        Country country = countriesConfiguration.getCountry(currency);
        double exchangeRate = 4;  // this we need to query NBP
        return (dailyRate * countriesConfiguration.getWorkingDays() * exchangeRate - country.getFixedCost()) * (1  - country.getIncomeTax());
    }
}
