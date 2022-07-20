package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void edit(Integer id, Product product);

    void delete(Product product);

    List<Product> search(String nameSearch);
}
