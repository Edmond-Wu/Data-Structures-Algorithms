package mockfilesystem;

/**
 * Abstract class to represent file system objects like directories and files
 */
public abstract class FileSystemObject {

    private String path;
    private String name;

    /**
     * Constructor that initializes an instance with a given path
     * @param path file path of object, starting with "/" and using "/" to separate directories
     */
    public FileSystemObject(String path) {
        this.path = path;
        String[] pathSplit = path.split("/");
        if (pathSplit.length > 0) {
            this.name = pathSplit[pathSplit.length - 1];
        }
        else {
            this.name = "";
        }
    }

    /**
     * Returns the path of the object
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns the name of the object, which is the last part of the file path
     * @return name of file
     */
    public String getName() {
        return name;
    }
}
