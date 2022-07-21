package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
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
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

    @GetMapping("/")
    public String showBlog(Model model, @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("blogs", blogService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blogs", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Add Blog Success!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("blogs", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.edit(blog);
        redirectAttributes.addFlashAttribute("success", "Edit Blog Success!");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete Product Success!");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String nameFind, @PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Blog> search = blogService.findByName(nameFind, pageable);
        model.addAttribute("blogs", search);
        return "list";
    }
}
