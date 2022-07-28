package com.blog.service;

import com.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> findAll();

    Optional<Category> findById(Integer id);
}
