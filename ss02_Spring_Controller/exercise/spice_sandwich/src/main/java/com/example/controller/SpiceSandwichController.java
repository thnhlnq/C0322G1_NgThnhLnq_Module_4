package com.example.controller;

import com.example.service.ISpiceSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceSandwichController {

    @Autowired
    ISpiceSandwichService spiceSandwichService;

    @GetMapping("/condiment")
    public String showFormSpiceSandwich() {
        return "condiment";
    }

    @PostMapping("/condiment")
    public String save(@RequestParam(defaultValue = "") String[] condiment, Model model) {
        String sandwich = spiceSandwichService.save(condiment);
        model.addAttribute("sandwich", sandwich);
        return "condiment";
    }
}
