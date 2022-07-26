package borrow_book.application.service.impl;

import borrow_book.application.model.Borrower;
import borrow_book.application.repository.IBorrowerRepository;
import borrow_book.application.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService implements IBorrowerService {

    @Autowired
    IBorrowerRepository borrowerRepository;

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }
}
