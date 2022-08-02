package security.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import security.blog.model.Category;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
