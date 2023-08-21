package top.jsoft.commons.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by psygrammator
 * group jsoft.top
 * Logger
 */
public class PrintManager {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    public static void info(String msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][INFO]: " + msg);
    }
    public static void warn(String msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][WARN]: " + msg);
    }
    public static void error(String msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][ERROR]: " + msg);
    }
}
