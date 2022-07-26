package borrow_book.application.service;

import borrow_book.application.model.Borrower;

import java.util.List;

public interface IBorrowerService {

    List<Borrower> findAll();
}
