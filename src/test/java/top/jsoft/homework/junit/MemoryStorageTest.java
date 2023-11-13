package top.jsoft.homework.junit;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MemoryStorageTest {
    private IStorage storage;

    @Before
    public void setUp() {
        storage = new MemoryStorage();
        storage.clear();
    }

    @Test
    public void testMemoryStorage() {
        List<String> data = List.of("1", "2", "3", "4", "5");
        storage.save(data);
        assertEquals(5, storage.getData().size());
        String[] dataArray = new String[data.size()];
        data.toArray(dataArray);

        String[] getDataArray = new String[storage.getData().size()];
        storage.getData().toArray(getDataArray);

        assertArrayEquals(dataArray, getDataArray);
    }
}