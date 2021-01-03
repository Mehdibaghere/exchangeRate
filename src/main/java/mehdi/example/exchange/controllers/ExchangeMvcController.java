package mehdi.example.exchange.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import mehdi.example.exchange.srvices.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeMvcController {

    private final SalaryService salaryService;

    public ExchangeMvcController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping("calculate-nett")
    public String calculateNettSalaryInPLN(
            @RequestParam(name = "grossDaily") double grossDaily,
            @RequestParam(name = "currency") String currency,
            Model model
    ) throws JsonProcessingException {

        double nettSalary = salaryService.calculateNetSalary(grossDaily, currency);

        model.addAttribute("grossDaily", grossDaily);
        model.addAttribute("currency", currency);
        model.addAttribute("nettSalary", nettSalary);

        return "net-salary-view";
    }
}
