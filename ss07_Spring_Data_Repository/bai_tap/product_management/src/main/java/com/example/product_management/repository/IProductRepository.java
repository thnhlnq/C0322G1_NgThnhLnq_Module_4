package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product", nativeQuery = true)
    Page<Product> findAllPage(Pageable pageable);

    @Modifying
    @Query(value = "insert into product (name, price, description, producer) values (:name, :price, :description, :producer)", nativeQuery = true)
    void create(@Param("name") String name, @Param("price") double price, @Param("description") String description, @Param("producer") String producer);

    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Optional<Product> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update product set name = :name, price = :price, description = :description, producer = :producer where id = :id", nativeQuery = true)
    void edit(@Param("name") String name, @Param("price") double price, @Param("description") String description, @Param("producer") String producer, @Param("id") Integer id);

    @Modifying
    @Query(value = "delete from product where id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Modifying
    @Query(value = "select * from product where name like :nameFind", nativeQuery = true)
    List<Product> findByName(@Param("nameFind") String nameFind);
}
