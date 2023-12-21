package top.jsoft.homework.junit;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public interface IStorage {
    List<String> getData();

    void save(List<String> data);

    void clear();
}
