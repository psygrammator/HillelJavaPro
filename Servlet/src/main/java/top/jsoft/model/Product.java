package top.jsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private double cost;
}
