package top.jsoft.homework.design.builder;


import lombok.Getter;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
public class CarBuilder implements Builder {
    private Car car;
    @Override
    public void create() {
        car = new Car();
    }

    @Override
    public void setName(String name) {
        car.setName(name);
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        car.setMaxSpeed(maxSpeed);
    }

    @Override
    public void setColor(String color) {
        car.setColor(color);
    }

}
