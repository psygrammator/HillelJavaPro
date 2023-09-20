package top.jsoft.homework.task10.util;

import top.jsoft.commons.util.PrintManager;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Util {
    public static List<Integer> toList(int[] array)
    {
        return IntStream.of(array)
                .boxed()
                .collect(Collectors.toList());
    }
    public static List<Integer> findUnique(List<Integer> integerList)
    {
        return new ArrayList<>(integerList).stream()
                .distinct()
                .collect(Collectors.toList());
    }
    public static void calcOccurance(List<String> wordsList)
    {
        Map<String, Integer> mapWords = wordsList.stream()
                .collect(Collectors.toMap(words -> words, words -> 1, Integer::sum));

        mapWords.forEach((k, v) -> PrintManager.info(k + ": " + v));
    }
    public static void findOccurance(List<String> wordsList)
    {
        Map<String, Integer> mapWords = wordsList.stream()
                .collect(Collectors.toMap(words -> words, words -> 1, Integer::sum));

        PrintManager.info(mapWords.toString());
    }
}
