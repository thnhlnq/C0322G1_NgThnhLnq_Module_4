package security.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.blog.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String name);
}
