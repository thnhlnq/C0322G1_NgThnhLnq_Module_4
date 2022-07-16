package com.example.controller;

import com.example.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {

    @GetMapping("/")
    public String showFormMedical(Model model) {
        model.addAttribute("medical", new Medical());
        return "index";
    }

    @PostMapping("/")
    public String medical(@ModelAttribute("medical") Medical medical, Model model) {
        model.addAttribute("name", medical.getName());
        model.addAttribute("birth", medical.getBirth());
        model.addAttribute("gender", medical.getGender());
        model.addAttribute("nationality", medical.getNationality());
        model.addAttribute("passport", medical.getPassport());
        model.addAttribute("travel", medical.getTravel());
        model.addAttribute("vehicle", medical.getVehicle());
        model.addAttribute("seat", medical.getSeat());
        model.addAttribute("startDate", medical.getStartDate());
        model.addAttribute("endDate", medical.getEndDate());
        model.addAttribute("address", medical.getAddress());
        model.addAttribute("phone", medical.getPhone());
        model.addAttribute("email", medical.getEmail());
        model.addAttribute("symptom", medical.getSymptom());
        model.addAttribute("exposure", medical.getExposure());
        return "";
    }
}
