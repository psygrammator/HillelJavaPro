package top.jsoft.homework.design.builder;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public interface Builder {
    void create();
    void setName(String name);
    void setMaxSpeed(int maxSpeed);
    void setColor(String color);
}
