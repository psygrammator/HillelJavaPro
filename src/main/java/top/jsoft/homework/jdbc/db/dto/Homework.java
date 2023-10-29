package top.jsoft.homework.jdbc.db.dto;

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
public class Homework {
    private int id;
    private final String name;
    private final String description;

    public Homework(String name, String description) {
        this.name = name;
        this.description = description;
    }
}