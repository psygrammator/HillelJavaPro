package top.jsoft.homework.task5.shape;


import top.jsoft.homework.task5.interfaces.Shape;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * Math.pow(radius, 2);
    }
}
