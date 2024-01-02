package top.jsoft.springsecurity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.jsoft.springsecurity.model.Product;
import top.jsoft.springsecurity.repository.ProductRepository;

import java.util.List;

/**
 * @author psygrammator
 */
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product id="+id+" not found!"));
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

}