package top.jsoft.homework.logger;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class StdoutLogger extends Logger {
    @Override
    protected void log(String msg) {
        System.out.println(msg);
    }
}
