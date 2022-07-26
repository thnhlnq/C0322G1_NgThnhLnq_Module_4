package borrow_book.application.controller;

import borrow_book.application.service.IBookService;
import borrow_book.application.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    IBorrowerService borrowerService;

    @GetMapping("/")
    public String showPage(Model model, @PageableDefault(value = 2) Pageable pageable) {
        model.addAttribute("books", bookService.findAll(pageable));
        model.addAttribute("borrowers", borrowerService.findAll());
        return "list";
    }
}
