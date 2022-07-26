package borrow_book.application.repository;

import borrow_book.application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}
