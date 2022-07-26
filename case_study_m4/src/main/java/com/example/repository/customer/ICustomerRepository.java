package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value = "select * from customer", nativeQuery = true)
//    Page<Customer> findAll(Pageable pageable);

//    @Modifying
//    @Query(value = "insert into customer (name, date_of_birth, gender, id_card, phone, email, address, customer_type_id) values (:name, :date_of_birth, :gender, :id_card, :phone, :email, :address, :customer_type_id)", nativeQuery = true)
//    void save(@Param("name") String name, @Param("date_of_birth") String date_of_birth, @Param("gender") int gender, @Param("id_card") String id_card, @Param("phone") String phone, @Param("email") String email, @Param("address") String address, @Param("customer_type_id") CustomerType customer_type_id);

//    @Query(value = "select * from customer where id = :id", nativeQuery = true)
//    Optional<Customer> findById(@Param("id") int id);

//    @Modifying
//    @Query(value = "update customer set name = :name, date_of_birth = :dateOfBirth, gender = :gender, id_card = :idCard, phone = :phone, email = :email, address = :address, customer_type_id = :customerTypeId where id = :id", nativeQuery = true)
//    void edit(@Param("name") String name, @Param("dateOfBirth") String dateOfBirth, @Param("gender") int gender, @Param("idCard") String idCard, @Param("phone") String phone, @Param("email") String email, @Param("address") String address, @Param("customerTypeId") CustomerType customerTypeId, @Param("id") int id);

//    @Modifying
//    @Query(value = "delete from customer where id = :id", nativeQuery = true)
//    void remove(@Param("id") int id);

    @Query(value = "select * from customer where name like :nameFind", nativeQuery = true)
    Page<Customer> findByName(@Param("nameFind") String nameFind, Pageable pageable);
}
