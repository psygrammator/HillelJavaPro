package top.jsoft.homework.loggerLog4j;

import org.apache.log4j.Logger;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Alex");
        coffeeOrderBoard.add("Ivan");
        coffeeOrderBoard.add("Masha");

        printSection("First");

        coffeeOrderBoard.draw();
        LOGGER.info(String.format("Delivered order without number: %s", coffeeOrderBoard.deliver()));

        printSection("Second");
        coffeeOrderBoard.draw();

        LOGGER.info(String.format("Delivered order with number 3: %s", coffeeOrderBoard.deliver(3)));

        printSection("Third");
        coffeeOrderBoard.draw();

        printSection("Fourth");
        int id = 5;
        Order deliver = coffeeOrderBoard.deliver(id);
        if(deliver == null)
            LOGGER.warn("Order with number " + id + " not exists!");
    }

    public static <V> void printSection(V msg)
    {
        LOGGER.info("====================[" + msg + "]====================");
    }
}
