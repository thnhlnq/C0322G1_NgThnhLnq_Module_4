package com.example.controller.contract;

import com.example.model.contract.Contract;
import com.example.model.employee.Employee;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractController {

    @Autowired
    IContractService contractService;

    @Autowired
    IAttachFacilityService attachFacilityService;

    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IFacilityService facilityService;

    @GetMapping("/contract")
    public String showList(Model model, @PageableDefault(value = 6, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("contracts", contractService.findAll(pageable));
        model.addAttribute("attachFacilities", attachFacilityService.findAll());
        model.addAttribute("contractDetails", contractDetailService.findAll());
        model.addAttribute("contractCreate", new Contract());
        return "contract/list";
    }

    @GetMapping("contract/create")
    public String showCreate(Model model, @PageableDefault(value = 6, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("contractCreate", new Contract());
        model.addAttribute("contracts", contractService.findAll(pageable));
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("facilities", facilityService.findAll());
        model.addAttribute("attachFacilities", attachFacilityService.findAll());
        model.addAttribute("contractDetails", contractDetailService.findAll());
        return "contract/list";
    }

    @PostMapping("contract/create")
    public String create(Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Add Contract Success!");
        return "redirect:/contract";
    }
}
