package top.jsoft.springmvc.dao;

import top.jsoft.springmvc.model.Order;
import top.jsoft.springmvc.model.Product;
import top.jsoft.springmvc.util.DateFormatter;

import java.util.*;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class OrderDAO {
    private final Map<Integer, Order> orders = new HashMap<>(
            Map.of(1, new Order(1, DateFormatter.timeNow(), 10, List.of(new Product(1, "Phone", 10))))
    );

    public Order getOrder(int id)
    {
        return orders.get(id);
    }

    public List<Order> getOrders()
    {
        return orders.values().stream().toList();
    }

    public void addOrder(Order order)
    {
        orders.put(order.getId(), order);
    }

    public void deleteOrder(int id)
    {
        orders.remove(id);
    }

}
