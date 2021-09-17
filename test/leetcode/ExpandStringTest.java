package leetcode;

import org.junit.Test;
import junit.framework.TestCase;

public class ExpandStringTest extends TestCase {
    @Test
    public void testExpandString() {
        assertEquals("ade bde cde adf bdf cdf", ExpandString.expandString("{a,b,c}d{e,f}"));
        assertEquals("abefg acefg adefg abefh acefh adefh", ExpandString.expandString("a{b,c,d}ef{g,h}"));
        assertEquals("abcdefg", ExpandString.expandString("abcdefg"));
    }
}
