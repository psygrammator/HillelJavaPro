package top.jsoft.homework.design.strategy;

import top.jsoft.commons.util.PrintManager;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) {
        GetSquare square = new GetSquare();

        //circle
        square.setISquare(new Circle());
        PrintManager.info(square.getSquare(3));
        //triangle
        square.setISquare(new Triangle());
        PrintManager.info(square.getSquare(3));
        //square
        square.setISquare(new SquareSquare());
        PrintManager.info(square.getSquare(3));
    }
}
