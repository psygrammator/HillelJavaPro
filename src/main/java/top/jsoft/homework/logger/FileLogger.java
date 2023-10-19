package top.jsoft.homework.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class FileLogger extends Logger {
    private File file;

    public File createFile() {
        String fileName = getFolder() + "/java_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy_HH-mm-ss-SSS")) + ".log";
        file = new File(fileName);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    @Override
    protected void log(String msg) {
        if (file == null || file.length() >= getLoggerConfiguration().getMaxFileSize()) {
            file = createFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(msg);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
