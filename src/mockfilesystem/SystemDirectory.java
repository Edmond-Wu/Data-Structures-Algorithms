package mockfilesystem;

import java.util.Map;
import java.util.TreeMap;

public class SystemDirectory extends FileSystemObject {

    //Use a TreeMap to store the contents of the directory, mapping each file/directory by path
    private Map<String, FileSystemObject> systemMap = new TreeMap<>();

    public SystemDirectory(String path) {
        super(path);
    }

    public Map<String, FileSystemObject> getSystemMap() {
        return systemMap;
    }

    public String toString() {
        return "Directory: " + getPath();
    }
}
