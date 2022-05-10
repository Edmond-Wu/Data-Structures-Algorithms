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
    public void testFileSystem1() {
        Assert.assertEquals(new ArrayList<String>(), fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        Assert.assertEquals("hello", fileSystem.readContentFromFile("/a/b/c/d"));
        Assert.assertEquals(1, fileSystem.ls("/a").size());
        fileSystem.addContentToFile("/a/b/c/d", " world");
        Assert.assertEquals("hello world", fileSystem.readContentFromFile("/a/b/c/d"));
        fileSystem.cd("/a/b/c");
        Assert.assertEquals("d", fileSystem.ls("").get(0));
        Assert.assertTrue(fileSystem.rm("/a/b/c/d"));
        Assert.assertEquals(0, fileSystem.ls("/a/b/c").size());
    }

    @Test
    public void testFileSystem2() {
        fileSystem.mkdir("/gh");
        Assert.assertEquals("gh", fileSystem.ls("/").get(0));
        fileSystem.mkdir("/e");
        fileSystem.mkdir("/jfo");
        fileSystem.mkdir("/gh/znflyvnd");
        fileSystem.cd("/gh");
        Assert.assertEquals(3, fileSystem.ls("/").size());
        Assert.assertEquals("znflyvnd", fileSystem.ls("/gh").get(0));
        Assert.assertEquals("gh", fileSystem.getCurrentDir().getName());
        fileSystem.addContentToFile("/mhdmck", "v");
        Assert.assertEquals("v", fileSystem.readContentFromFile("/mhdmck"));
        fileSystem.addContentToFile("/bbigs", "kzdi");
        Assert.assertEquals("kzdi", fileSystem.readContentFromFile("/bbigs"));
    }
}
