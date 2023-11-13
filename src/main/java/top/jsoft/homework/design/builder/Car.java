package top.jsoft.homework.design.builder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@NoArgsConstructor
@ToString
public class Car {
    private String name;
    private int maxSpeed;
    private String color;
}
