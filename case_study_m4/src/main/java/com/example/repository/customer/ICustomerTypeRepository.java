package com.example.repository.customer;

import com.example.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

    @Query(value = "select * from customer_type", nativeQuery = true)
    List<CustomerType> findAll();
}
