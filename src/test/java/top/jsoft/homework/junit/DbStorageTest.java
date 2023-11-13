package top.jsoft.homework.junit;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import top.jsoft.classwork.lesson21.factoryMethod.StorageType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DbStorageTest {
    private final DbStorage dataDaoMock =
            Mockito.mock(DbStorage.class);
    private IStorage storage;

    @Before
    public void setUp() {
        storage = dataDaoMock;
        storage.clear();
    }

    @Ignore
    @Test
    public void testDbStorage() {
        List<String> data = List.of("1", "2", "3", "4", "5");

        Mockito.when(storage.getData()).thenReturn(data);
        assertEquals(5, storage.getData().size());
        String[] dataArray = new String[data.size()];
        data.toArray(dataArray);

        String[] getDataArray = new String[storage.getData().size()];
        storage.getData().toArray(getDataArray);

        assertArrayEquals(dataArray, getDataArray);
    }
}