package com.example.repository;

import com.example.model.Product;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select s from Product as s", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        return ConnectionUtil.entityManager.find(Product.class, id);
    }

    @Override
    public void edit(Integer id, Product product) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(Product product) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.remove(findById(product.getId()));
        entityTransaction.commit();
    }

    @Override
    public List<Product> search(String nameSearch) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select s from Product s where s.name like :nameSearch ", Product.class);
        query.setParameter("nameSearch", "%" + nameSearch + "%");
        return query.getResultList();
    }
}
