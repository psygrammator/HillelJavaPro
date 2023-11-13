package top.jsoft.homework.junit;


import org.junit.Before;
import org.junit.Test;
import top.jsoft.classwork.lesson21.factoryMethod.StorageType;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileStorageTest {
    private IStorage storage;

    @Before
    public void setUp() {
        storage = new FileStorage();
        storage.clear();
    }

    @Test
    public void testFileStorage() {
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