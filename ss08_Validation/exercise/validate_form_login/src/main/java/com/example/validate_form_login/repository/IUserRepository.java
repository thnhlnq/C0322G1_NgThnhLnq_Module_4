package com.example.validate_form_login.repository;

import com.example.validate_form_login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAll();

    @Modifying
    @Query(value = "insert into user (firstName, lastName, phone, age, email) values (:firstName, :lastName, :phone, :age, :email)", nativeQuery = true)
    void save(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("phone") int phone, @Param("age") int age, @Param("email") String email);
}
