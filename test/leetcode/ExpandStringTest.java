package leetcode;

import org.junit.Test;
import junit.framework.TestCase;

public class ExpandStringTest extends TestCase {
    @Test
    public void testExpandString() {
        assertEquals(ExpandString.expandString("{a,b,c}d{e,f}"), "ade bde cde adf bdf cdf");
        assertEquals(ExpandString.expandString("a{b,c,d}ef{g,h}"), "abefg acefg adefg abefh acefh adefh");
    }
}
