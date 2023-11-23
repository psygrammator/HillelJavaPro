package top.jsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
@ToString
public class Order {
    private int id;
    private String date;
    private double cost;
    private List<Product> products;
}
