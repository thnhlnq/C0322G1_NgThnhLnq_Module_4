package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showFormCalculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam float firstOperand, float secondOperand, String operator, Model model) {
        String result = calculatorService.checkOperand(firstOperand, secondOperand, operator);
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);
        return "calculator";
    }
}
