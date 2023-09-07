package top.jsoft.homework.task9.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
public class Container<T extends Fruit> implements Comparable<Double> {
    private List<T> items = new ArrayList<>();

    public void add(T fruit)
    {
        items.add(fruit);
    }

    public void addAll(T... fruits)
    {
        items.addAll(Arrays.asList(fruits));
    }

    public double getWeight()
    {
        return items.stream()
                .mapToDouble(Fruit::getWeight)
                .sum();
    }

    public boolean compare(Double o)
    {
        return compareTo(o) == 0;
    }

    @Override
    public int compareTo(Double o) {
        return Double.compare(getWeight(), o);
    }

    public void clear()
    {
        items.clear();
    }

    public void merge(Container<T> container)
    {
        if(this != container)
        {
            items.addAll(container.items);
            container.clear();
        }
    }
}
