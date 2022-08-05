package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable, String nameFind);

    void save(Customer customer);

    Optional<Customer> findById(int id);

    void edit(Customer customer);

    void delete(int id);

    List<Customer> findAll();
}
