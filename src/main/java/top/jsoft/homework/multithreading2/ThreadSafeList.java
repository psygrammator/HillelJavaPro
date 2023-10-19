package top.jsoft.homework.multithreading2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
public class ThreadSafeList {
    private final List<Integer> safeList = new CopyOnWriteArrayList<>();

    public void add(Integer value)
    {
        safeList.add(value);
    }

    public void remove(Integer value)
    {
        safeList.remove(value);
    }

    public Integer get(Integer index)
    {
        return safeList.get(index);
    }

}
