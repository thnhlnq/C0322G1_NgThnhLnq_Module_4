package borrow_book.application.controller;

import borrow_book.application.model.Book;
import borrow_book.application.model.Borrower;
import borrow_book.application.service.IBookService;
import borrow_book.application.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    IBorrowerService borrowerService;

    @GetMapping("/")
    public String showPage(Model model, @PageableDefault(value = 2) Pageable pageable) {
        model.addAttribute("books", bookService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("books", new Book());
        model.addAttribute("borrowers", borrowerService.findAll());
        return "list";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        bookService.borrow(borrowerService.getBook().getId());
        redirectAttributes.addFlashAttribute("message", "Borrow Success");
        return "redirect:/";
    }

    @PostMapping("/pay")
    public String payBoot(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        bookService.pay(borrowerService.getBook().getId());
        redirectAttributes.addFlashAttribute("message", "Pay Success");
        return "redirect:/";
    }
}
