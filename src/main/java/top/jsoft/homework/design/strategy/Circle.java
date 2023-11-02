package top.jsoft.homework.design.strategy;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Circle implements ISquare {
    @Override
    public double getSquare(int val) {
        return Math.PI * Math.pow(val, 2);
    }
}
