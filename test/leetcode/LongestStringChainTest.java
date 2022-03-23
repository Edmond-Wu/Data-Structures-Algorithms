package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestStringChainTest {
    @Test
    public void testLongestStringChain() {
        String[] testArr1 = {"a","b","ba","bca","bda","bdca"};
        Assert.assertEquals(4, LongestStringChain.longestStringChain(testArr1));
        String[] testArr2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        Assert.assertEquals(5, LongestStringChain.longestStringChain(testArr2));
        String[] testArr3 = {"abcd","dbqca"};
        Assert.assertEquals(1, LongestStringChain.longestStringChain(testArr3));
    }
}
