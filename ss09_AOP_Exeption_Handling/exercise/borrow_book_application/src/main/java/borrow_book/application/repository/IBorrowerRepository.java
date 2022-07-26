package borrow_book.application.repository;

import borrow_book.application.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowerRepository extends JpaRepository<Borrower, Integer> {

}
