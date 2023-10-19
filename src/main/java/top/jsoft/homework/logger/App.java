package top.jsoft.homework.logger;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = new FileLogger();
        for (int i = 0; i < 5000; i++) {
            logger.info("info i: " + i);
            logger.debug("debug i:" + i);
            Thread.sleep(1);
        }

        logger = new StdoutLogger();
        for (int i = 0; i < 500; i++) {
            logger.info("info i: " + i);
            logger.debug("debug i: " + i);
            Thread.sleep(1);
        }
    }
}
