package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("products", productService.products());
        return "index";
    }

    @GetMapping("")
    public String create(Model model) {
        model.addAttribute("products", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Add Product Success!");
        return "redirect:/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirect) {
        productService.edit(product.getId(), product);
        redirect.addFlashAttribute("success", "Edit Product Success!");
        return "redirect:/index";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product.getId());
        redirect.addFlashAttribute("success", "Delete Product Success!");
        return "redirect:/index";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "view";
    }

    @PostMapping("search")
    public String search(@RequestParam String nameSearch, Model model) {
        List<Product> products = productService.search(nameSearch);
        model.addAttribute("products", products);
        return "index";
    }
}
