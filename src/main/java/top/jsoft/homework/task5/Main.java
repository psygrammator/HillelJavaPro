package top.jsoft.homework.task5;

import top.jsoft.commons.util.Rnd;
import top.jsoft.homework.task5.interfaces.Shape;
import top.jsoft.homework.task5.shape.Circle;
import top.jsoft.homework.task5.shape.Square;
import top.jsoft.homework.task5.shape.Triangle;
import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.task5.model.*;

import java.util.Arrays;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Main {
    private static final double DEFAULT_SQUARE = 10;
    public static void main(String[] args) {
        /* TASK 1 */
        // Sum area shape
        final var circle = new Circle(DEFAULT_SQUARE);
        final var triangle = new Triangle(DEFAULT_SQUARE);
        final var square = new Square(DEFAULT_SQUARE);
        var shapeList = Arrays.asList(circle, triangle, square);

        double sum = 0;
        for(Shape shape : shapeList)
        {
            sum += shape.getSquare();
        }
        PrintManager.info("Sum area shape: " + sum);

        /* TASK 2 */
        // Particions
        final var person = new Person("Chakky");
        final var cat = new Cat("Laska");
        final var robot = new Robot("R2");
        // Obstacle
        final var runTrack = new RunningTrack(Rnd.get(200));
        final var wall = new Wall(Rnd.get(40));

        final var particionsList = Arrays.asList(person, cat, robot);
        final var obstacleList = Arrays.asList(runTrack, wall);

        obstacleList.forEach(obstacle -> obstacle.overcome(particionsList));
    }
}
