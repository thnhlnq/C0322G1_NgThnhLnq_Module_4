package com.blog.repository;

import com.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
