package leetcode;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void testLongestIncreasingSubsequence() {
        int[] arr1 = {10,9,2,5,3,7,101,18};
        Assert.assertEquals(4, LeetCode2.longestIncreasingSubsequence(arr1));
        int[] arr2 = {0,1,0,3,2,3};
        Assert.assertEquals(4, LeetCode2.longestIncreasingSubsequence(arr2));
        int[] arr3 = {7,7,7,7,7,7,7};
        Assert.assertEquals(1, LeetCode2.longestIncreasingSubsequence(arr3));
    }

    @Test
    public void testBricksAndLadders() {
        int[] buildings1 = {4,2,7,6,9,14,12};
        Assert.assertEquals(4, LeetCode2.bricksAndLadders(buildings1, 5, 1));
        int[] buildings2 = {4,12,2,7,3,18,20,3,19};
        Assert.assertEquals(7, LeetCode2.bricksAndLadders(buildings2, 10, 2));
        int[] buildings3 = {14,3,19,3};
        Assert.assertEquals(3, LeetCode2.bricksAndLadders(buildings3, 17, 0));
        int[] buildings4 = {2,7,9,3,1,2,5,9,4,6};
        Assert.assertEquals(9, LeetCode2.bricksAndLadders(buildings4, 8, 2));
    }
}
