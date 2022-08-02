package security.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import security.blog.model.Blog;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}
