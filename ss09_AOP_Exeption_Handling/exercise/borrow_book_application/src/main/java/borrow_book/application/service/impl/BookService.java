package borrow_book.application.service.impl;

import borrow_book.application.model.Book;
import borrow_book.application.repository.IBookRepository;
import borrow_book.application.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
