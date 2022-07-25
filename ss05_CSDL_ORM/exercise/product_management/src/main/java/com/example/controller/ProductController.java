package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("products", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Add Song Success!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Edit Product Success!");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam int id, Product product, RedirectAttributes redirectAttributes) {
        productService.findById(id);
        productService.delete(product);
        redirectAttributes.addFlashAttribute("success", "Delete Product Success!");
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam String nameSearch, Model model) {
        List<Product> search = productService.search(nameSearch);
        model.addAttribute("products", search);
        return "index";
    }
}
