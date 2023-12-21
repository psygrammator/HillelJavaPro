package top.jsoft.springcore.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import top.jsoft.springcore.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class ProductRepository {
    private final Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product)
    {
        products.put(product.getId(), product);
    }

    public void deleteProduct(int id)
    {
        products.remove(id);
    }

    public Product getProduct(int id)
    {
        return products.get(id);
    }

    public List<Product> getProducts()
    {
        return products.values().stream().toList();
    }
}
