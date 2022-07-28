package com.example.controller;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart") // khai báo session name = cart
public class ProductController {

    @Autowired
    private IProductService productService;

    // khởi tạo giá trị mặc định cho session cart
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(Model model, @CookieValue(value = "productId", defaultValue = "-1") Long id) {
//        ModelAndView modelAndView = new ModelAndView("/shop");
//        modelAndView.addObject("products", productService.findAll());
        if (id != -1) {
            model.addAttribute("history", productService.findById(id).get());
        }
        return new ModelAndView ("shop", "products", productService.findAll());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute(name = "cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping_cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable Long id, @SessionAttribute(name = "cart") Cart cart, @RequestParam("action") String action) throws Exception {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping_cart";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("cart/delete")
    public String showDelete(@RequestParam Long id) {
        productService.delete(id);
        return "redirect:/cart";
    }

    @ExceptionHandler(Exception.class)
    public String showError() {
        return "error.404";
    }
}
