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
    public static <V> void info(V msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][INFO]: " + msg);
    }
    public static <V> void warn(V msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][WARN]: " + msg);
    }
    public static <V> void error(V msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][ERROR]: " + msg);
    }

    public static <V> void printSection(V msg)
    {
        System.out.println("[" + dateFormat.format(new Date(System.currentTimeMillis())) + "][INFO]: ====================[" + msg + "]====================");
    }
}
