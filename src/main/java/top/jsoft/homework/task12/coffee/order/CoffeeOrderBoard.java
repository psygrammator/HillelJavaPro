package top.jsoft.homework.task12.coffee.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.jsoft.commons.util.PrintManager;

import java.util.*;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
public class CoffeeOrderBoard {
    private final Deque<Order> orders = new ArrayDeque<>();

    public void add(String name)
    {
        int orderId = orders.isEmpty() ? 1 : orders.getLast().getId() + 1;
        orders.add(new Order(orderId, name));
    }

    public Order deliver()
    {
        return orders.poll();
    }
    public Order deliver(int id)
    {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext())
        {
            final Order order = iterator.next();
            if(order.getId() == id)
            {
                iterator.remove();
                return order;
            }
        }
        return null;
    }

    public void draw()
    {
        PrintManager.info("Num | Name");
        orders.forEach(o -> PrintManager.info(o.getId() + " | " + o.getName()));
    }
}
