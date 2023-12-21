package top.jsoft.springmvc.util;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class DateFormatter {
    @Getter
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd:MM:yyyy hh:mm:ss");

    public static String timeNow()
    {
        return dateFormatter.format(new Date(System.currentTimeMillis()));
    }
}
