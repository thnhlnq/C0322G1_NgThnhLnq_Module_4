package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> products();

    void save(Product product);

    Product findById(int id);

    void edit(int id, Product product);

    void delete(int id);

    List<Product> search(String nameSearch);
}
