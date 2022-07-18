package com.example.controller;

import com.example.model.Medical;
import com.example.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalController {

    @Autowired
    MedicalService medicalService;

    @GetMapping("/")
    public ModelAndView showFormMedical() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Medical> medicals = medicalService.medicals();
        modelAndView.addObject("medical", medicals);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("medical", new Medical());
        modelAndView.addObject("births", medicalService.births());
        modelAndView.addObject("genders", medicalService.genders());
        modelAndView.addObject("nationalities", medicalService.nationalities());
        modelAndView.addObject("travels", medicalService.travels());
        modelAndView.addObject("startDay", medicalService.startDay());
        modelAndView.addObject("startMonth", medicalService.startMonth());
        modelAndView.addObject("startYear", medicalService.startYear());
        modelAndView.addObject("endDay", medicalService.endDay());
        modelAndView.addObject("endMonth", medicalService.endMonth());
        modelAndView.addObject("endYear", medicalService.endYear());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("medical") Medical medical, RedirectAttributes redirectAttributes) {
        medicalService.save(medical);
        redirectAttributes.addFlashAttribute("message", "Thêm Thành Công");
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam String idCard) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("medical", new Medical());
        modelAndView.addObject("births", medicalService.births());
        modelAndView.addObject("genders", medicalService.genders());
        modelAndView.addObject("nationalities", medicalService.nationalities());
        modelAndView.addObject("travels", medicalService.travels());
        modelAndView.addObject("startDay", medicalService.startDay());
        modelAndView.addObject("startMonth", medicalService.startMonth());
        modelAndView.addObject("startYear", medicalService.startYear());
        modelAndView.addObject("endDay", medicalService.endDay());
        modelAndView.addObject("endMonth", medicalService.endMonth());
        modelAndView.addObject("endYear", medicalService.endYear());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("medical") Medical medical, RedirectAttributes redirectAttributes) {
        medicalService.edit(medical.getIdCard(), medical);
        redirectAttributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/list";
    }
}
