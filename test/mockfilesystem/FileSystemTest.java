package mockfilesystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FileSystemTest {

    private MockFileSystem fileSystem;

    @Before
    public void setUp() {
        fileSystem = new MockFileSystem();
    }

    @Test
    public void testFileSystem() {
        Assert.assertEquals(new ArrayList<String>(), fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        Assert.assertEquals("hello", fileSystem.readContentFromFile("/a/b/c/d"));
        Assert.assertEquals(1, fileSystem.ls("/a").size());
        fileSystem.addContentToFile("/a/b/c/d", " world");
        Assert.assertEquals("hello world", fileSystem.readContentFromFile("/a/b/c/d"));
    }
}
