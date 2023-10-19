package top.jsoft.homework.logger;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
public class LoggerConfiguration {
    private final String path;
    private final LoggingLevel loggingLevel;
    private final int maxFileSize;
    private final String textFormat;
}
