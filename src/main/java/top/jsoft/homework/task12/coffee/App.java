package top.jsoft.homework.task12.coffee;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.task12.coffee.order.CoffeeOrderBoard;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    private static final String EOL = "============================";
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Aladin");
        coffeeOrderBoard.add("Koka");
        coffeeOrderBoard.add("Moka");
        coffeeOrderBoard.add("Vova");
        coffeeOrderBoard.add("Lola");
        coffeeOrderBoard.add("John");
        coffeeOrderBoard.add("Arakul");
        coffeeOrderBoard.add("Dodge");
        coffeeOrderBoard.add("Batman");

        coffeeOrderBoard.draw();

        PrintManager.info(EOL);

        PrintManager.info(coffeeOrderBoard.deliver());
        coffeeOrderBoard.draw();

        PrintManager.info(EOL);

        PrintManager.info(coffeeOrderBoard.deliver(5));
        coffeeOrderBoard.draw();

        PrintManager.info(EOL);
    }
}
