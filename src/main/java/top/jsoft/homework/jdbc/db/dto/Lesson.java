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
public class Lesson {
    private int id;
    private final String name;
    private String updateAt;
    private final int homework;

    public Lesson(String name, int homework) {
        this.name = name;
        this.homework = homework;
    }
}
