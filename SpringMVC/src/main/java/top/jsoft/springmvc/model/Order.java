package top.jsoft.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
@AllArgsConstructor
@ToString
public class Order {
    private int id;
    private String date;
    private double cost;
    private List<Product> products;
}
