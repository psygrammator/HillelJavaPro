package top.jsoft.homework.junit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class MemoryStorage implements IStorage {
    private final List<String> data = new ArrayList<>();
    @Override
    public List<String> getData() {
        return data;
    }

    @Override
    public void save(List<String> data) {
        this.data.addAll(data);
    }

    @Override
    public void clear() {
        data.clear();
    }
}
