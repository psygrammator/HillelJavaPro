package top.jsoft.homework.task8;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.task8.exceptions.ArrayDataException;
import top.jsoft.homework.task8.exceptions.ArraySizeException;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class ArrayValueCalculator {
    public static int doCalc(String[][] arr) throws ArraySizeException, ArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new ArraySizeException();
        }
        for (String[] strings : arr) {
            if (strings.length != 4) {
                throw new ArraySizeException();
            }
            for (String string : strings) {
                try {
                    count = count + Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(e);
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String[][] arrayValid = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        //valid
        try
        {
            try
            {
                int result = doCalc(arrayValid);
                PrintManager.info(result);
            }
            catch (ArraySizeException e) {
                PrintManager.error("" + e);
            }
        }
        catch (ArrayDataException e) {
            PrintManager.error("" + e);
        }

        //invalid
        String[][] arrayInvalid = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "q"}};
        try
        {
            try
            {
                int result = doCalc(arrayInvalid);
                PrintManager.info(result);
            }
            catch (ArraySizeException e) {
                PrintManager.error("" + e);
            }
        }
        catch (ArrayDataException e) {
            PrintManager.error("" + e);
        }
    }
}
