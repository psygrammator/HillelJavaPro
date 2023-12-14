package top.jsoft.homework.loggerLog4j;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class CoffeeOrderBoard {
    private static final Logger LOGGER = Logger.getLogger(CoffeeOrderBoard.class);
    private final Deque<Order> orders = new ArrayDeque<>();

    public void add(String name) {
        int id = orders.isEmpty() ? 1 : (orders.getLast().getId() + 1);
        orders.addLast(new Order(id, name));
        LOGGER.info(String.format("Order added with id: %s and name: %s", id, name));
    }

    public Order deliver() {
        return orders.pollFirst();
    }

    public Order deliver(int id) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getId() == id) {
                iterator.remove();
                LOGGER.info(String.format("Deliver order with id: %s", id));
                return order;
            }
        }
        return null;
    }

    public void draw() {
        LOGGER.info("ID | name");
        orders.forEach(c -> LOGGER.info(String.format("%s | %s", c.getId(), c.getName())));
    }
}