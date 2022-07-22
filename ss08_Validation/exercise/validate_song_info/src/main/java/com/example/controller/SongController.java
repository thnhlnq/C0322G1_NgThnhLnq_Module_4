package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    ISongService songService;

    @GetMapping(value = {""})
    public String showSong(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("songs", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String create(Song song, RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("success", "Add Song Success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("songs", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("song") Song song, RedirectAttributes redirect) {
        songService.edit(song);
        redirect.addFlashAttribute("success", "Edit Song Success!");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        songService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete Song Success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String showView(@PathVariable int id, Model model) {
        model.addAttribute("songs", songService.findById(id));
        return "view";
    }
}
