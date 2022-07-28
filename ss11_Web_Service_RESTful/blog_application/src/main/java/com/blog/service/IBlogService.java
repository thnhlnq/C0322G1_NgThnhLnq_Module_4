package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Optional<Blog> findById(Integer id);

    void edit(Blog blog);

    void delete(Integer id);

    Page<Blog> findByName(String nameFind, Pageable pageable);
}
