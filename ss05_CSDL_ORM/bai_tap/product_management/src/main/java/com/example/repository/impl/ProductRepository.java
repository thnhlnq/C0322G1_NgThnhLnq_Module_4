package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer, Product> products = new HashMap<>();

    @Override
    public List<Product> products() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products().get(id);
    }

    @Override
    public void edit(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String nameSearch) {
        List<Product> list = new ArrayList();
        for (Product item : products.values()) {
            if (item.getName().contains(nameSearch) || item.getProducer().contains(nameSearch)) {
                list.add(item);
            }
        }
        return list;
    }
}
