package mehdi.example.exchange.srvices;

import com.fasterxml.jackson.core.JsonProcessingException;
import mehdi.example.exchange.configuration.CountriesConfiguration;
import mehdi.example.exchange.configuration.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private CountriesConfiguration countriesConfiguration;
    @Autowired
    private NBPService nbpService;

    public double calculateNetSalary(double dailyRate, String currency) throws JsonProcessingException {
        Country country = countriesConfiguration.getCountry(currency);
        double exchangeRate = "PLN".equals(currency) ? 1 : nbpService.getRateForCurrency(currency);
        return (dailyRate * countriesConfiguration.getWorkingDays() * exchangeRate - country.getFixedCost()) * (1  - country.getIncomeTax());
    }
}
