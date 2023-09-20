package top.jsoft.homework.task10.phonebook;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@ToString
public class PhoneDirectory {
    private List<Record> records = new ArrayList<>();
    public void add(Record record)
    {
        if(records.stream().filter(name -> name.getName().equalsIgnoreCase(record.getName())).toList().size() < 2)
            records.add(record);
    }

    public Record find(String name)
    {
        return records.stream()
                .filter(record -> record.getName().equals(name))
                .findFirst().orElse(null);
    }

    public List<Record> findAll(String name)
    {
        return records.stream()
                .filter(record -> record.getName().equals(name))
                .collect(Collectors.toList());
    }
}
