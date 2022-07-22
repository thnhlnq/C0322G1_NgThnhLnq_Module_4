package com.example.validate_form_login.service.impl;

import com.example.validate_form_login.model.User;
import com.example.validate_form_login.repository.IUserRepository;
import com.example.validate_form_login.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
