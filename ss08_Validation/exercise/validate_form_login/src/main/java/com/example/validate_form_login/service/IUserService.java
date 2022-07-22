package com.example.validate_form_login.service;

import com.example.validate_form_login.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);
}
