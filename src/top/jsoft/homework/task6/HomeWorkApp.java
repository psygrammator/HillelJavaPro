package top.jsoft.homework.task6;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.commons.util.Rnd;

import java.util.Arrays;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class HomeWorkApp {
    public static void main(String[] args) {
        // Task 1
        printThreeWords();
        // Task 2
        checkSumSign();
        // Task 3
        printColor();
        // Task 4
        compareNumbers();
        // Task 5
        compareNumbersSelf();
        // Task 6
        numSet(Rnd.get(-10, 10));
        // Task 7
        numSet2(Rnd.get(-10, 10));
        // Task 8
        printAndNum("Not bad", 5);
        // Task 9
        leapYears();
    }

    private static void printThreeWords()
    {
        System.out.println("Orange\nBanana\nApple");
    }

    private static void checkSumSign()
    {
        final int a = Rnd.get(-5, 5);
        final int b = Rnd.get(-5, 5);
        PrintManager.info(((a + b) >= 0) ? "The sum is positive." : "The sum is negative.");
    }

    private static void printColor()
    {
        final int value = Rnd.get(-100, 200);
        PrintManager.info((value <= 0 ? "Red" : value <= 100 ? "Yellow" : "Green"));
    }

    private static void compareNumbers()
    {
        final int a = Rnd.get(-5, 5);
        final int b = Rnd.get(-5, 5);
        PrintManager.info(((a >= b) ? "a>=b" : "a<b"));
    }

    private static void compareNumbersSelf()
    {
        final int a = Rnd.get(0, 20);
        final int b = Rnd.get(0, 20);
        PrintManager.info("a: " + (a >= 10 && a <= 20) + " b: " + (b >= 10 && b <= 20));
    }

    private static void numSet(int value)
    {
        PrintManager.info((value >= 0 ? "positive" : "negative"));
    }

    private static void numSet2(int value)
    {
        PrintManager.info(String.valueOf((value < 0)));
    }

    private static void printAndNum(String msg, int value)
    {
        while (value > 0)
        {
            PrintManager.info(msg);
            value--;
        }
    }

    private static void leapYears() {
        final var yearsList = Arrays.asList(100, 400, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031, 2032, 2033);
        yearsList.forEach(year -> PrintManager.info(year + " is leap: " + (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0))));
    }
}

