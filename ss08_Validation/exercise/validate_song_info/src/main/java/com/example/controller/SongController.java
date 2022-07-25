package com.example.controller;

import com.example.dto.SongDto;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {

    @Autowired
    ISongService songService;

    @GetMapping("/")
    public String showSong(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("success", "Add Song Success!");
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("songs", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("song") @Valid SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.edit(song);
            redirectAttributes.addFlashAttribute("success", "Edit Song Success!");
            return "redirect:/";
        }
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        songService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete Song Success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String showView(@PathVariable Integer id, Model model) {
        model.addAttribute("songs", songService.findById(id));
        return "view";
    }
}
