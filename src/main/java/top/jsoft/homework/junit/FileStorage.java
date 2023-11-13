package top.jsoft.homework.junit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class FileStorage implements IStorage {
    private final File file = new File("data.txt");
    @Override
    public List<String> getData() {
        List<String> data = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    @Override
    public void save(List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String c : data) {
                writer.write(c);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
