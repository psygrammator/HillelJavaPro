package top.jsoft.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jsoft.springsecurity.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author psygrammator
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Override
    void deleteById(Integer id);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Integer id);

    @Override
    <S extends Product> S save(S entity);
}