package top.jsoft.springsecurity.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import top.jsoft.springsecurity.model.Product;
import top.jsoft.springsecurity.service.ProductService;

import java.util.Collection;

/**
 * @author psygrammator
 */
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @GetMapping
    public Collection<Product> findAll() {
        LOGGER.info("productService findAll.");
        return productService.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        LOGGER.info("productService save.");
        return productService.save(product);
    }

    @GetMapping(path = "/{id}")
    public Product findById(@PathVariable Integer id) {
        LOGGER.info("productService findById id={}.", id);
        return productService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        LOGGER.info("productService deleteById id={}.", id);
        productService.deleteById(id);
    }
}