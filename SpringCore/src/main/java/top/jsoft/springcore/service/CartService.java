package top.jsoft.springcore.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import top.jsoft.springcore.dao.ProductRepository;
import top.jsoft.springcore.model.Product;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Service
@Scope("prototype")
public class CartService {

    private final ProductRepository productRepository = new ProductRepository();

    public void addProduct(Product product)
    {
        productRepository.addProduct(product);
    }

    public void deleteProduct(int id)
    {
        productRepository.deleteProduct(id);
    }

    public Product getProduct(int id)
    {
        return productRepository.getProduct(id);
    }

    public List<Product> getProducts()
    {
        return productRepository.getProducts();
    }

}
