package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.create(blog.getName(), blog.getContent());
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.edit(blog.getName(), blog.getContent(), blog.getId());
    }

    @Override
    public void delete(Integer id) {
        blogRepository.delete(id);
    }

    @Override
    public Page<Blog> findByName(String nameFind) {
        return blogRepository.findByNameContaining("%" + nameFind + "%");
    }
}
