package top.jsoft.homework.design.strategy;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Triangle implements ISquare {
    @Override
    public double getSquare(int val) {
        return Math.pow(val, 2) * Math.sqrt(3) / 4;
    }
}
