package top.jsoft.homework.logger;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
public abstract class Logger {
    private final LoggerConfiguration loggerConfiguration;

    public Logger()
    {
        LoggerConfigurationLoader loggerConfigurationLoader = LoggerConfigurationLoader.load();
        String fileName = loggerConfigurationLoader.getString("FILE", "log");
        LoggingLevel loggingLevel = loggerConfigurationLoader.getEnum("LEVEL", LoggingLevel.class, LoggingLevel.INFO);
        int maxFileSize = loggerConfigurationLoader.getInt("MAX-SIZE", 20000);
        String textFormat = loggerConfigurationLoader.getString("FORMAT", "[%s][%s] MSG: %s");

        loggerConfiguration = new LoggerConfiguration(fileName, loggingLevel, maxFileSize, textFormat);
    }

    public void debug(String msg) {
        log(String.format(loggerConfiguration.getTextFormat(), LocalDateTime.now(), LoggingLevel.DEBUG, msg));
    }

    public void info(String msg) {
        log(String.format(loggerConfiguration.getTextFormat(), LocalDateTime.now(), LoggingLevel.INFO, msg));
    }

    protected String getFolder() {
        return "./logger/" + getLoggerConfiguration().getPath();
    }

    protected abstract void log(String msg);

}
