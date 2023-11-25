package top.jsoft.springmvc.service;

import org.springframework.stereotype.Service;
import top.jsoft.springmvc.dao.OrderDAO;
import top.jsoft.springmvc.model.Order;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Service
public class OrderService {
    private final OrderDAO orderDAO = new OrderDAO();

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

    public void deleteOrder(int id)
    {
        orderDAO.deleteOrder(id);
    }
}
