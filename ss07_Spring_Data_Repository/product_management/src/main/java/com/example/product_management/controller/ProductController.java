package com.example.product_management.controller;

import com.example.product_management.dto.ProductDto;
import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public String showPage(Model model, @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("products", productService.findAll(pageable));
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
            redirectAttributes.addFlashAttribute("success", "Add Product Success!");
            return "redirect:/";
        }
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") @Valid ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.edit(product);
            redirectAttributes.addFlashAttribute("success", "Edit Product Success!");
            return "redirect:/";
        }
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete Product Success!");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String nameFind, @PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Product> search = productService.findByName(nameFind, pageable);
        model.addAttribute("products", search);
        return "index";
    }
}
