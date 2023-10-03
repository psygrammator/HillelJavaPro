package top.jsoft.homework.streamapi;

import lombok.Data;
import lombok.ToString;
import top.jsoft.homework.streamapi.enums.ProductType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@ToString
public class Product {
    private final ProductType type;
    private final double price;
    private final boolean discount;
    private final LocalDateTime date;

    public Product(ProductType type, double price, boolean discount, LocalDateTime date) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public Product(ProductType type, double price, LocalDateTime date) {
        this(type, price, false, date);
    }
    public Product(ProductType type, double price, boolean discount) {
        this(type, price, discount, LocalDateTime.now());
    }
    public Product(ProductType type, double price) {
        this(type, price, false, LocalDateTime.now());
    }
}
