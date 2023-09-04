package top.jsoft.homework.task4.actor;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by psygrammator
 * group jsoft.top
 */

@Getter
@Setter
public class Dog extends Animal {

    private int distance;
    private int swimDistance;

    public void run(int distance)
    {
        System.out.println("Dog ran " + distance + " m.");
    }

    public void swim(int distance)
    {
        System.out.println("Dog swim " + distance + " m.");
    }
}
