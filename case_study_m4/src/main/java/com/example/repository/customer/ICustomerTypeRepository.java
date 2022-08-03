package com.example.repository.customer;

import com.example.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
