package top.jsoft.homework.task11;

import top.jsoft.commons.util.PrintManager;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    private static final String PATH_FIRST = "D:\\JavaProjects\\HillelJavaPro\\src\\main\\java\\top\\jsoft\\homework\\task5\\model";
    private static final String PATH_SECOND = "D:\\JavaProjects\\HillelJavaPro\\src\\main\\java\\top\\jsoft\\homework\\task3";
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        PrintManager.info("Path - first");
        File filesFirst = new File(PATH_FIRST);
        Arrays.stream(Objects.requireNonNull(filesFirst.listFiles())).filter(File::isFile).forEach(f -> fileNavigator.add(new FileData(f.getName(), f.length(), f.getPath()), PATH_FIRST));
        fileNavigator.find(PATH_FIRST).forEach(f -> PrintManager.info("Name: " + f.getName() + " size: " + f.getSize() + " path: " + f.getPath()));

        PrintManager.info("Path - second");
        File filesSecond = new File(PATH_SECOND);
        Arrays.stream(Objects.requireNonNull(filesSecond.listFiles())).filter(File::isFile).forEach(f -> fileNavigator.add(new FileData(f.getName(), f.length(), f.getPath()), PATH_FIRST));
        fileNavigator.find(PATH_SECOND).forEach(f -> PrintManager.info("Name: " + f.getName() + " size: " + f.getSize() + " path: " + f.getPath()));

        PrintManager.info("Filter by size");
        fileNavigator.filterBySize(750).forEach(f -> PrintManager.info("Name: " + f.getName() + " size: " + f.getSize() + " path: " + f.getPath()));

        PrintManager.info("Sort by size");
        fileNavigator.sortBySize().forEach(f -> PrintManager.info("Name: " + f.getName() + " size: " + f.getSize() + " path: " + f.getPath()));
    }
}
