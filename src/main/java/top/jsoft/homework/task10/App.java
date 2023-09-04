package top.jsoft.homework.task10;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.util.SelfMath;

import java.util.Scanner;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        PrintManager.info("======================");
        PrintManager.info("String to md5");
        PrintManager.info("close program [exit] [quit]");
        PrintManager.info("======================");
        PrintManager.info("write word:");
        while (scanner.hasNext())
        {
            String word = scanner.nextLine();
            if(word.equalsIgnoreCase("exit") || word.equalsIgnoreCase("quit"))
                break;

            PrintManager.info("Word: " + word + " md5: " + SelfMath.md5Custom(word));
        }
    }
}
