package top.jsoft.springmvc.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.jsoft.springmvc.model.Order;
import top.jsoft.springmvc.service.OrderService;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@RestController()
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/getOrder")
    public Order getOrder(@RequestParam int id)
    {
        return orderService.getOrder(id);
    }
    @GetMapping("/getOrder/{id}")
    public Order getOrderByPath(@PathVariable int id)
    {
        return orderService.getOrder(id);
    }
    @GetMapping("/getOrders")
    public List<Order> getOrders()
    {
        return orderService.getOrders();
    }

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order)
    {
        orderService.addOrder(order);
    }
    @PostMapping("/deleteOrder")
    public void deleteOrder(@RequestBody int id)
    {
        orderService.deleteOrder(id);
    }

}
