package com.example.controller.employee;

import com.example.model.employee.Employee;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
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

@Controller
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService positionService;

    @Autowired
    IEducationDegreeService educationDegreeService;

    @Autowired
    IDivisionService divisionService;

    @GetMapping("/employee")
    public String showList(Model model, @PageableDefault(value = 6, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("employees", employeeService.findAll(pageable));
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("employeeCreate", new Employee());

        return "employee/list";
    }

    @GetMapping("employee/create")
    public String showCreate(Model model) {
        model.addAttribute("employees", new Employee());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/create";
    }

    @PostMapping("employee/create")
    public String create(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Add Employee Success!");
        return "redirect:/employee";
    }

    @GetMapping("employee/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("employeeEdit", employeeService.findById(id));
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/edit";
    }

    @PostMapping("employee/edit")
    public String edit(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.edit(employee);
        redirectAttributes.addFlashAttribute("success", "Edit Employee Success!");
        return "redirect:/employee";
    }

    @GetMapping("employee/delete")
    public String showDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete Employee Success!");
        return "redirect:/employee";
    }

    @GetMapping("employee/search")
    public String search(@RequestParam String nameFind, @PageableDefault(value = 6) Pageable pageable, Model model) {
        Page<Employee> search = employeeService.findByName(nameFind, pageable);
        model.addAttribute("employees", search);
        return "employee/list";
    }
}
