package borrow_book.application.service;

import borrow_book.application.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Page<Book> findAll(Pageable pageable);
}
