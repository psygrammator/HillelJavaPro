package top.jsoft.springcore.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.jsoft.springcore.model.Product;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@SpringBootTest
public class ProductRepositoryTest {

    private final ProductRepository productRepository = new ProductRepository();

    @Test
    public void testAddProduct()
    {
        List<Product> products = List.of(new Product(1, "Phone", 5), new Product(2, "TV", 10));
        products.forEach(productRepository::addProduct);

        Assertions.assertEquals(2, productRepository.getProducts().size());
        Assertions.assertEquals(1, productRepository.getProduct(1).getId());
    }

    @Test
    public void testDeleteProduct()
    {
        List<Product> products = List.of(new Product(1, "Phone", 5), new Product(2, "TV", 10));
        products.forEach(productRepository::addProduct);

        Assertions.assertEquals(2, productRepository.getProducts().size());

        productRepository.deleteProduct(1);
        Assertions.assertEquals(1, productRepository.getProducts().size());
    }

    @Test
    public void testGetProduct()
    {
        List<Product> products = List.of(new Product(1, "Phone", 5), new Product(2, "TV", 10));
        products.forEach(productRepository::addProduct);

        Assertions.assertEquals(1, productRepository.getProduct(1).getId());
    }
}
