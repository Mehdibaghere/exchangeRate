package mehdi.example.exchange.controllers;

import mehdi.example.exchange.srvices.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// REST API
public class ExchangeController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("calculate-nett")
    double calculateNettSalaryInPLN(@RequestParam double grossDaily, @RequestParam String currency) {

        System.out.println("Gross daily is: " + grossDaily);
        System.out.println("Currency: " + currency);

        double netSalary = salaryService.calculateNetSalary(grossDaily, currency);

        System.out.println("Net salary: " + netSalary);
        return netSalary;
    }
}
