package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testNumIslands() {
        char[][] testArr1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Assert.assertEquals(1, LeetCode2.numIslands(testArr1));
        char[][] testArr2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Assert.assertEquals(3, LeetCode2.numIslands(testArr2));
    }

    @Test
    public void testMinSwaps() {
        int[] testArr1 = {1,0,1,0,1};
        Assert.assertEquals(1, LeetCode2.minSwaps(testArr1));
        int[] testArr2 = {0,0,0,1,0};
        Assert.assertEquals(0, LeetCode2.minSwaps(testArr2));
        int[] testArr3 = {1,0,1,0,1,0,0,1,1,0,1};
        Assert.assertEquals(3, LeetCode2.minSwaps(testArr3));
    }

    @Test
    public void testShortestPathToFood() {
        char[][] grid1 = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
        Assert.assertEquals(3, LeetCode2.shortestPathToFood(grid1));
        char[][] grid2 = {{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
        Assert.assertEquals(-1, LeetCode2.shortestPathToFood(grid2));
        char[][] grid3 = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
        Assert.assertEquals(6, LeetCode2.shortestPathToFood(grid3));
    }

    @Test
    public void testWordBreak() {
        String s1 = "leetcode";
        String s2 = "applepenapple";
        String s3 = "catsandog";
        List<String> list1 = Arrays.asList("leet", "code");
        List<String> list2 = Arrays.asList("apple","pen");
        List<String> list3 = Arrays.asList("cats","dog","sand","and","cat");
        Assert.assertTrue(LeetCode2.wordBreak(s1, list1));
        Assert.assertTrue(LeetCode2.wordBreak(s2, list2));
        Assert.assertFalse(LeetCode2.wordBreak(s3, list3));
    }
}
