package mockfilesystem;

public class SystemFile extends FileSystemObject {

    private StringBuilder contentBuilder = new StringBuilder();

    public SystemFile(String path) {
        super(path);
    }

    public SystemFile(String path, String content) {
        super(path);
        contentBuilder.append(content);
    }

    public String getContent() {
        return contentBuilder.toString();
    }

    public void addContent(String content) {
        contentBuilder.append(content);
    }

    public String toString() {
        return "File: " + getPath() + ", Content: " + getContent();
    }
}
