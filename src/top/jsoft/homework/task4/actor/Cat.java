package top.jsoft.homework.task4.actor;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
@Setter
public class Cat extends Animal
{
    private int runDistance;
    private int swimDistance;

    public void run(int distance)
    {
        System.out.println("Cat ran " + distance + " m.");
    }

    public void swim()
    {
        System.out.println("Cat cant swim.");
    }
}
