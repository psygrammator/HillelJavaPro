package top.jsoft.homework.design.builder;

import top.jsoft.commons.util.PrintManager;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) {
        CarBuilder car = new CarBuilder();
        //1
        car.create();
        car.setName("Ford");
        car.setColor("Blue");
        car.setMaxSpeed(200);
        PrintManager.info(car.getCar());
        //2
        car.create();
        car.setName("Tesla");
        car.setColor("White");
        car.setMaxSpeed(300);
        PrintManager.info(car.getCar());
    }
}
