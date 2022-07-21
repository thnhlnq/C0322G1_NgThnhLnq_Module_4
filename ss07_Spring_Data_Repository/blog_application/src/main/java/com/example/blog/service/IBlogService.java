package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Optional<Blog> findById(Integer id);

    void edit(Blog blog);

    void delete(Integer id);

    Page<Blog> findByName(String nameFind, Pageable pageable);
}
