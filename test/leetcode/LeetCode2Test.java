package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode2Test {
    @Test
    public void testLongestStringChain() {
        String[] testArr1 = {"a","b","ba","bca","bda","bdca"};
        Assert.assertEquals(4, LeetCode2.longestStringChain(testArr1));
        String[] testArr2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        Assert.assertEquals(5, LeetCode2.longestStringChain(testArr2));
        String[] testArr3 = {"abcd","dbqca"};
        Assert.assertEquals(1, LeetCode2.longestStringChain(testArr3));
    }

    @Test
    public void testUniquePathsIII() {
        int[][] testArr1 = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        Assert.assertEquals(2, LeetCode2.uniquePathsIII(testArr1));
        int[][] testArr2 = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        Assert.assertEquals(4, LeetCode2.uniquePathsIII(testArr2));
        int[][] testArr3 = {{0,1},{2,0}};
        Assert.assertEquals(0, LeetCode2.uniquePathsIII(testArr3));
    }
}
