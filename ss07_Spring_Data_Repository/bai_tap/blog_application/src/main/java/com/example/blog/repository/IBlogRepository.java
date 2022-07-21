package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog", nativeQuery = true)
    List<Blog> findAll();

    @Query(value = "select * from blog", nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);

    @Modifying
    @Query(value = "insert into blog (name, content) values (:name, :content)", nativeQuery = true)
    void create(@Param("name") String name, @Param("content") String content);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Optional<Blog> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update blog set name = :name, content = :content where id = :id", nativeQuery = true)
    void edit(@Param("name") String name, @Param("content") String content, @Param("id") Integer id);

    @Modifying
    @Query(value = "delete from blog where id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Query(value = "select * from blog where name like :nameFind", nativeQuery = true)
    List<Blog> findByNameContaining(@Param("nameFind") String nameFind);
}
