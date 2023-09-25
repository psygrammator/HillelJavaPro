package top.jsoft.homework.task11;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.jsoft.commons.util.PrintManager;

import java.io.File;
import java.util.*;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
public class FileNavigator {
    private final Map<String, List<FileData>> navMap = new HashMap<>();

    public void add(FileData file, String addedPath)
    {
        String path = file.getPath();
        File pathExist = new File(path);
        if(!pathExist.exists())
        {
            PrintManager.error("Path not exists: " + path);
            return;
        }
        String parent = pathExist.getParent();
        if(!addedPath.equals(parent))
        {
            PrintManager.error("Error: equals path added -> " + addedPath);
            return;
        }

        if(navMap.containsKey(parent))
            navMap.get(parent).add(file);
        else
            navMap.put(parent, new ArrayList<>(List.of(file)));
    }

    public List<FileData> find(String path)
    {
        return navMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredList = new ArrayList<>();
        navMap.values().forEach(fileData -> fileData.stream().filter(file -> file.getSize() <= maxSize)
                .forEach(filteredList::add));
        return filteredList;
    }

    public void remove(String path)
    {
        navMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortList = new ArrayList<>();
        navMap.values().forEach(sortList::addAll);
        sortList.sort(Comparator.comparingLong(FileData::getSize));
        return sortList;
    }
}
