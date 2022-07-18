package com.example.controller;

import com.example.model.Mail;
import com.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("mails", mailService.listMail());
        return "list";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("mails", mailService.findById(id));
        model.addAttribute("language", mailService.languages());
        model.addAttribute("pageSize", mailService.pageSizes());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("mail") Mail mail, int id, Model model, RedirectAttributes redirectAttributes) {
        mailService.update(id, mail);
        model.addAttribute("mail", mail);
        redirectAttributes.addFlashAttribute("message", "Update Success !!");
        return "redirect:/";
    }
}
