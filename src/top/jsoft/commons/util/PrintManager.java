package top.jsoft.commons.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by psygrammator
 * group jsoft.top
 * Logger
 */
public class PrintManager {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    public static void info(Object msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][INFO]: " + msg);
    }
    public static void warn(Object msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][WARN]: " + msg);
    }
    public static void error(Object msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][ERROR]: " + msg);
    }
}
