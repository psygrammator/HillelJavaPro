package top.jsoft.homework.task4.actor;


import lombok.Getter;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Animal {
    public static final int EMPTY_DISTANCE = 0;

    @Getter
    private static int animalsCount;

    public Animal()
    {
        animalsCount++;
    }

    public int getRunDistance()
    {
        return EMPTY_DISTANCE;
    }

    public int getSwimDistance()
    {
        return EMPTY_DISTANCE;
    }
}
