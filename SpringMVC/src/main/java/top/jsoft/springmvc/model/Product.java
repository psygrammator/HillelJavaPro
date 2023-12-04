package top.jsoft.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private double cost;
}
