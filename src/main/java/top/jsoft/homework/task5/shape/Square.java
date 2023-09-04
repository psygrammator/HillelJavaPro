package top.jsoft.homework.task5.shape;


import top.jsoft.homework.task5.interfaces.Shape;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Square implements Shape {
    private final double lenght;
    public Square(double lenght) {
        this.lenght = lenght;
    }

    @Override
    public double getSquare() {
        return Math.pow(lenght, 2);
    }
}
