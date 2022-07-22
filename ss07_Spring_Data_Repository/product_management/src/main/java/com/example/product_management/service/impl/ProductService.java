package com.example.product_management.service.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.create(product.getName(), product.getPrice(), product.getDescription(), product.getProducer());
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product.getName(), product.getPrice(), product.getDescription(), product.getProducer(), product.getId());
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public Page<Product> findByName(String nameFind, Pageable pageable) {
        return productRepository.findByName("%" + nameFind + "%", pageable);
    }
}
