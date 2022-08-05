package com.example.controller.facility;

import com.example.model.facility.Facility;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FacilityController {

    @Autowired
    IFacilityService facilityService;

    @Autowired
    IFacilityTypeService facilityTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/service")
    public String showList(Model model, @RequestParam Optional<String> nameFind, @PageableDefault(value = 6, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("nameFind", nameFind.orElse(""));
        model.addAttribute("facilities", facilityService.findAll(pageable, nameFind.orElse("")));
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        return "facility/list";
    }

    @GetMapping("service/create")
    public String showCreate(Model model) {
        model.addAttribute("facilities", new Facility());
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("service/create")
    public String create(Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("success", "Add Facility Success!");
        return "redirect:/service";
    }

    @GetMapping("service/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("facilities", facilityService.findById(id));
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        return "facility/edit";
    }

    @PostMapping("service/edit")
    public String edit(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.edit(facility);
        redirectAttributes.addFlashAttribute("success", "Edit Facility Success!");
        return "redirect:/service";
    }

    @GetMapping("service/delete")
    public String showDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete Facility Success!");
        return "redirect:/service";
    }
}
