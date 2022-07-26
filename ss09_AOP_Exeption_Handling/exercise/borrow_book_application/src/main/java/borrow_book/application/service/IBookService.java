package borrow_book.application.service;

import borrow_book.application.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {

    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Optional<Book> findById(Integer id);

    void borrow(int id);

    void pay(int id);
}
