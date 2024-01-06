package top.jsoft.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jsoft.springsecurity.model.User;

import java.util.Optional;

/**
 * @author psygrammator
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}