package top.jsoft.homework.task7;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.commons.util.Rnd;

import java.util.Scanner;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class RunApp {
    private static void findSymbolOccurance(String msg, char symbol)
    {
        int sumbols = 0;
        for(char s : msg.toCharArray())
        {
            if(s == symbol)
                sumbols++;
        }
        PrintManager.info("Msg: " + msg + " char: " + symbol + " symbols: " + sumbols);
    }

    private static void findWordPosition(String source, String target)
    {
        PrintManager.info("Source: " + source + " target: " + target + " indexOf: " + source.indexOf(target));
    }

    private static String stringReverse(String msg)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(msg).reverse();
        return stringBuilder.toString();
    }

    public static boolean isPalindrome(String msg) {
        StringBuilder strBuilder = new StringBuilder(msg);
        strBuilder.reverse();
        return msg.equalsIgnoreCase(strBuilder.toString());
    }

    public static void main(String[] args) {
        findSymbolOccurance("Blablacar", 'a');
        findWordPosition("LastBlablacar", "Blablacar");
        PrintManager.info("Reverse: " + stringReverse("Blablacar"));
        PrintManager.info("Palindrome: " + isPalindrome("Alla"));
        PrintManager.info("-------------------------------");

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper" , "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);
        String rndWord = words[Rnd.get(words.length) - 1];
        StringBuilder cipher = new StringBuilder("###############");
        //PrintManager.info("Real word: " + rndWord);

        PrintManager.info("For play minigame enter words: ");
        while (scanner.hasNext())
        {
            String word = scanner.nextLine().toLowerCase();
            // Cheat code
            if(word.equalsIgnoreCase("cheat"))
            {
                PrintManager.info("Secret word: " + rndWord);
                continue;
            }
            else if(word.equalsIgnoreCase(rndWord))
            {
                PrintManager.info("Mission complete! Your word " + word);
                break;
            }
            for (int i = 0; i < rndWord.length(); i++) {
                if (word.length() > i && rndWord.charAt(i) == word.charAt(i)) {
                    cipher.setCharAt(i, word.charAt(i));
                }
            }
            PrintManager.info("Cipher: " + cipher);
        }
        scanner.close();
    }
}
