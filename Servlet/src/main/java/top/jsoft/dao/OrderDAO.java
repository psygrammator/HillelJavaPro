package top.jsoft.dao;

import lombok.Getter;
import top.jsoft.model.Order;
import top.jsoft.model.Product;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
public class OrderDAO {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy hh:mm:ss");
    public final Map<Integer, Order> orders = new HashMap<>(
            Map.of(1, new Order(1, simpleDateFormat.format(new Date(System.currentTimeMillis())), 10, List.of(new Product(1, "Phone", 5), new Product(2, "TV", 5))),
            2, new Order(2, simpleDateFormat.format(new Date(System.currentTimeMillis())), 20, List.of(new Product(1, "Tulpan", 10), new Product(2, "Roza", 10))),
            3, new Order(3, simpleDateFormat.format(new Date(System.currentTimeMillis())), 30, List.of(new Product(1, "AK", 15), new Product(2, "USP", 15))))
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


    public static OrderDAO getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder
    {
        public static final OrderDAO INSTANCE = new OrderDAO();
    }
}
