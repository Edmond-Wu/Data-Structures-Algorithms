package mockfilesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Problem to design an in-memory file system.
 * File system consists of files and directories, and files can contain text inside them
 * Implement methods to create directories and files, and add contents to files
 * Bonus: Implement methods to change current directories and remove folders/files
 * All path inputs will always start with "/"
 */
public class MockFileSystem {

    //a directory to represent the home directory which has a path of "/"
    private final SystemDirectory homeDir;

    private SystemDirectory currentDir;

    /**
     * Constructor to initialize home directory
     */
    public MockFileSystem() {
        this.homeDir = new SystemDirectory("/");
        //current directory is the home directory by default
        this.currentDir = homeDir;
    }

    /**
     * Creates a new directory with the given path
     * @param path a path that currently doesn't exist. If any middle directories in the path don't exist, creates them as well
     */
    public void mkdir(String path) {
        String[] pathSplit = path.split("/");
        StringBuilder pathBuilder = new StringBuilder("/");
        SystemDirectory currentDir = homeDir;

        //start from 1 since due to the nature of the split the first string will be empty
        for (int i = 1; i < pathSplit.length; i++) {
            //append the current directory to the pathBuilder
            pathBuilder.append(pathSplit[i]);
            String currentPath = pathBuilder.toString();

            //check if the current directory contains the current path
            Map<String, FileSystemObject> fileMap = currentDir.getSystemMap();
            if (fileMap.containsKey(currentPath)) {
                FileSystemObject obj = fileMap.get(currentPath);
                //if it's a directory, just update the directory
                if (obj instanceof SystemDirectory) {
                    currentDir = (SystemDirectory) obj;
                }
                //it's a file, so we can't make a directory so just break out
                else {
                    System.out.println("There's a file that already exists in the path, so cannot make new directory.");
                    return;
                }
            }
            //have to make intermediate directory before updating current directory
            else {
                SystemDirectory newDir = new SystemDirectory(currentPath);
                fileMap.put(currentPath, newDir);
                currentDir = newDir;
            }
            //add a "/" to separate directories if it's not the last one
            if (i != pathSplit.length - 1) {
                pathBuilder.append("/");
            }
        }
    }

    /**
     * Simulates the "ls" command on unix machines, reveals all files/directories contained in that specific path
     * @param path path of the system object
     * @return a list of files/directories contained if the path is a directory, otherwise a list with the object's name if it's a file
     */
    public List<String> ls(String path) {
        List<String> dirContents = new ArrayList<>();
        //base cases
        //if the path is empty, then just reveal the contents of the current directory
        if (path == null || path.length() == 0) {
            for (Map.Entry<String, FileSystemObject> currentEntry : currentDir.getSystemMap().entrySet()) {
                dirContents.add(currentEntry.getValue().getName());
            }
            return dirContents;
        }
        //check if the path is the home directory
        if (path.equals("/") || path.equals("~")) {
            //return contents of home directory
            for (Map.Entry<String, FileSystemObject> homeEntry : homeDir.getSystemMap().entrySet()) {
                dirContents.add(homeEntry.getValue().getName());
            }
            return dirContents;
        }

        //find the file
        FileSystemObject obj = find(path);
        //let the user know the path doesn't exist if the object is null
        if (obj == null) {
            System.out.println("Path doesn't exist.");
        }
        else {
            //return just the file name if it's a file, and list of contents if it's a directory
            if (obj instanceof SystemFile) {
                dirContents.add(obj.getName());
            }
            else {
                //go through directory's contents
                SystemDirectory dir = (SystemDirectory) obj;
                for (Map.Entry<String, FileSystemObject> mapEntry : dir.getSystemMap().entrySet()) {
                    dirContents.add(mapEntry.getValue().getName());
                }
            }
        }
        return dirContents;
    }

    /**
     * Changes directory to the specified path
     * If the path doesn't exist (or is a file), let the user know
     * If the path is null/empty or a "~", that means go home
     * @param path path to switch directories to
     */
    public void cd(String path) {
        if (path == null || path.length() == 0 || path.equals("~")) {
            this.currentDir = homeDir;
            return;
        }
        FileSystemObject obj = find(path);
        //if it's not a directory, output error
        if (!(obj instanceof SystemDirectory)) {
            System.out.println("Folder doesn't exist or is a file.");
        }
        else {
            this.currentDir = (SystemDirectory) obj;
        }
    }

    /**
     * Attempts to delete a file/folder found at the specified path and returns based on success
     * @param path file/folder path to be deleted
     * @return true if it was deleted, false otherwise
     */
    public boolean rm(String path) {
        //base case, cannot remove home directory
        if (path == null || path.equals("/") || path.equals("~")) {
            return false;
        }
        //find the higher level parent directory containing the file/folder
        String[] pathSplit = path.split("/");
        StringBuilder pathBuilder = new StringBuilder("/");
        //only want to iterate up to the 2nd to last element
        for (int i = 1; i < pathSplit.length - 1; i++) {
            pathBuilder.append(pathSplit[i]);
            //if it's not the last one in the iteration add a "/"
            if (i != pathSplit.length - 2) {
                pathBuilder.append("/");
            }
        }
        //check if that folder exists
        FileSystemObject obj = find(pathBuilder.toString());
        if (!(obj instanceof SystemDirectory)) {
            return false;
        }
        SystemDirectory dir = (SystemDirectory) obj;
        //remove the path key from the parent dir to delete it
        return (dir.getSystemMap().remove(path) != null);
    }

    /**
     * Adds content to a file given the path. If the file doesn't exist, creates the file
     * @param filePath file path of the file
     * @param content content to be added to the file
     */
    public void addContentToFile(String filePath, String content) {
        //need to find the directory that contains the file, so we can then check whether to create a new file or not
        String[] pathSplit = filePath.split("/");
        StringBuilder pathBuilder = new StringBuilder("/");

        //only want to iterate up to the 2nd to last element
        for (int i = 1; i < pathSplit.length - 1; i++) {
            pathBuilder.append(pathSplit[i]);
            //if it's not the last one in the iteration add a "/"
            if (i != pathSplit.length - 2) {
                pathBuilder.append("/");
            }
        }
        //search for the dir associated with the path
        SystemDirectory dir = (SystemDirectory) find(pathBuilder.toString());
        //if it's null, then let user know the directory to make the file does not exist
        if (dir == null) {
            System.out.println("Directory in which the file to add content to does not exist");
        }
        else {
            //check if the file to add content to already exists or not
            SystemFile file = (SystemFile) dir.getSystemMap().get(filePath);
            //if it's null, create a new file and add it to the directory
            if (file == null) {
                file = new SystemFile(filePath, content);
                dir.getSystemMap().put(filePath, file);
            }
            //otherwise just add content
            else {
                file.addContent(content);
            }
        }
    }

    /**
     * Returns the content found in the file of the given file path. If the file doesn't exist or is a directory, return null
     * @param filePath path of the file to be read
     * @return contents found in the file
     */
    public String readContentFromFile(String filePath) {
        FileSystemObject obj = find(filePath);
        //cannot read a file that's null
        if (obj == null) {
            System.out.println("Cannot read a null file.");
            return null;
        }
        else {
            //if it's a directory, let the user know it's a directory before returning null
            if (obj instanceof SystemDirectory) {
                System.out.println("Cannot read contents from a directory.");
                return null;
            }
            SystemFile file = (SystemFile) obj;
            return file.getContent();
        }
    }

    public SystemDirectory getCurrentDir() {
        return currentDir;
    }

    /**
     * Helper method that returns a file system object with the given path, or null if it doesn't exist
     * @param path file path
     * @return the file/directory of the path, or null if it doesn't exist
     */
    protected FileSystemObject find(String path) {
        //base case where the path is the home dir
        if (path.equals("/")) {
            return homeDir;
        }

        //split the string and go through the directories to find the system object
        String[] pathSplit = path.split("/");
        StringBuilder pathBuilder = new StringBuilder("/");
        //start from the home directory
        SystemDirectory currentDir = homeDir;
        //start from 1 to ignore the first empty string
        for (int i = 1; i < pathSplit.length; i++) {
            pathBuilder.append(pathSplit[i]);
            String currentPath = pathBuilder.toString();
            Map<String, FileSystemObject> fileMap = currentDir.getSystemMap();
            //check if the current directory contains the object
            if (fileMap.containsKey(currentPath)) {
                FileSystemObject obj = fileMap.get(currentPath);
                //if it's a directory, just update current directory
                if (obj instanceof SystemDirectory) {
                    currentDir = (SystemDirectory) obj;
                    //if we're at the last index return the found object
                    if (i == pathSplit.length - 1) {
                        return obj;
                    }
                }
                //otherwise it's a file
                else {
                    //if i is the last one, then we are at the end of the path so we can return the file
                    if (i == pathSplit.length - 1) {
                        return fileMap.get(currentPath);
                    }
                    //otherwise we would be returning earlier than expected, so log and return null
                    return null;
                }
                //add a "/" at the end if i is not the last one
                if (i != pathSplit.length - 1) {
                    pathBuilder.append("/");
                }
            }
            //otherwise the path doesn't exist, so return null
            else {
                return null;
            }
        }
        return null;
    }
}
