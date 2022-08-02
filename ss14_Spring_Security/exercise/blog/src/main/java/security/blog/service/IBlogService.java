package security.blog.service;

import security.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(Integer id);

    void edit(Blog blog);

    void delete(Integer id);
}
