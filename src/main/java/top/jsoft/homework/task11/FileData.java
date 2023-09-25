package top.jsoft.homework.task11;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
public class FileData {
    private final String name;
    private final long size;
    private final String path;
}
