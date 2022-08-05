package com.example.controller.customer;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/customer")
    public String showList(Model model, @RequestParam Optional<String> nameFind,
                           @PageableDefault(value = 6, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("nameFind", nameFind.orElse(""));
        model.addAttribute("customers", customerService.findAll(pageable, nameFind.orElse("")));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("customer/create")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("customer/create")
    public String create(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customers", new Customer());
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("success", "Add Customer Success!");
            return "redirect:/customer";
        }
    }

    @GetMapping("customer/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("customers", customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("customer/edit")
    public String edit(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.edit(customer);
        redirectAttributes.addFlashAttribute("success", "Edit Customer Success!");
        return "redirect:/customer";
    }

    @GetMapping("customer/delete")
    public String showDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete Customer Success!");
        return "redirect:/customer";
    }
}
