package com.example.repository.customer;

import com.example.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
