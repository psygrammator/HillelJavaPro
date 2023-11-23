package top.jsoft.service;

import top.jsoft.dao.OrderDAO;
import top.jsoft.model.Order;
import top.jsoft.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class OrderService {
    private final OrderDAO orderDAO = OrderDAO.getInstance();

    public Order getOrder(int id)
    {
        return orderDAO.getOrder(id);
    }

    public List<Order> getOrders()
    {
        return orderDAO.getOrders();
    }

    public void addOrder(Order order)
    {
        orderDAO.addOrder(order);
    }

    public List<Product> getProductsByOrderId(int id)
    {
        Order order = orderDAO.getOrders().get(id);
        if(order == null) {
            System.out.println("Error get order id: " + id);
            return null;
        }
        return order.getProducts();
    }

    public List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<>();
        orderDAO.getOrders().forEach(p -> products.addAll(p.getProducts()));
        return products;
    }

    public Product getProductByName(String name)
    {
        List<Product> products = new ArrayList<>();
        orderDAO.getOrders().forEach(p -> products.addAll(p.getProducts()));
        return products.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}
