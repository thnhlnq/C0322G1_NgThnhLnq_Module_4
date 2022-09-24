package com.example.controller;

import com.example.model.TinTuc;
import com.example.service.IDanhMucService;
import com.example.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TinTucController {

    @Autowired
    ITinTucService tinTucService;

    @Autowired
    IDanhMucService danhMucService;

    @GetMapping("/tintuc")
    public String showList(Model model, @RequestParam Optional<String> nameFind,
                           @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("nameFind", nameFind.orElse(""));
        model.addAttribute("tinTucs", tinTucService.findAll(pageable, nameFind.orElse("")));
        model.addAttribute("danhMucs", danhMucService.findAll());
        return "/list";
    }

    @GetMapping("tintuc/create")
    public String showCreate(Model model) {
        model.addAttribute("tinTucs", new TinTuc());
        model.addAttribute("danhMucs", danhMucService.findAll());
        return "/create";
    }

    @PostMapping("tintuc/create")
    public String create(@ModelAttribute("tinTuc") TinTuc tinTuc, RedirectAttributes redirectAttributes) {
        tinTucService.save(tinTuc);
        redirectAttributes.addFlashAttribute("success", "Thêm Tin Tức Thành Công!");
        return "redirect:/tintuc";
    }

    @GetMapping("tintuc/delete")
    public String showDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        tinTucService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Xoá Tin Tức Thành Công!");
        return "redirect:/tintuc";
    }
}
