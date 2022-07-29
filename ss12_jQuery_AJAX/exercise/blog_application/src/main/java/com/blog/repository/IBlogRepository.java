package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where name like :nameFind", nativeQuery = true)
    List<Blog> findByName(@Param("nameFind") String nameFind);
}
