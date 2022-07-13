package currency_converter.controller;

import currency_converter.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @Autowired
    private IConvertService convertService;

    @GetMapping("/convert")
    public String showFormConvert() {
        return "converter";
    }

    @PostMapping("/convert")
    public String currencyConvert(@RequestParam float rate, float usd, Model model) {

        double vnd = convertService.currencyConvert(rate, usd);

        model.addAttribute("vnd", vnd);

        return "converter";
    }
}
