package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Optional<Product> findById(Integer id);

    void edit(Product product);

    void delete(Integer id);

    Page<Product> findByName(String nameFind, Pageable pageable);
}
