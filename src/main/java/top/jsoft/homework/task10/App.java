package top.jsoft.homework.task10;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.commons.util.Rnd;
import top.jsoft.homework.task10.phonebook.PhoneDirectory;
import top.jsoft.homework.task10.phonebook.Record;
import top.jsoft.homework.task10.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) {
        // 2
        PrintManager.info("toList: " + Util.toList(new int[]{1, 2, 3}));
        // 3
        List<Integer> threeList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            threeList.add(Rnd.get(1, 50));
        }
        PrintManager.info("findUnique: " + Util.findUnique(threeList));
        PrintManager.info("findUnique: sort -> " + Util.findUnique(threeList).stream().sorted().toList());
        //4
        List<String> wordsList = Arrays.asList("bird", "fox", "cat", "dog", "dog", "fox", "cat", "cat", "parrot", "panda", "cat", "leon");
        Util.calcOccurance(wordsList);
        //5
        Util.findOccurance(wordsList);

        //6
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add(new Record("Alla", "+380500509050"));
        phoneDirectory.add(new Record("Kate", "+380500509051"));
        phoneDirectory.add(new Record("Vera", "+380500509052"));
        phoneDirectory.add(new Record("Alla", "+380500509053"));

        PrintManager.info(phoneDirectory.find("Alla"));
        PrintManager.info(phoneDirectory.findAll("Alla"));
    }
}
