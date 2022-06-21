package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DFSTest {

    @Test
    public void testGetCombinations() {
        Assert.assertEquals(DFS.getCombinations("abc", 2).size(), 3);
        Assert.assertEquals(DFS.getCombinations("abcd", 3).size(), 4);
    }

    @Test
    public void testFindSubsets() {
        List<List<Integer>> testList = new ArrayList<>();
        //test empty array
        testList.add(new ArrayList<>());
        Assert.assertEquals(testList, DFS.findSubsets(new int[0]));
        //test array with 1 element
        List<Integer> singleItemList = new ArrayList<>();
        singleItemList.add(0);
        testList.add(singleItemList);
        Assert.assertEquals(testList, DFS.findSubsets(new int[1]));
        int[] testArray = {1, 2, 3};
        System.out.println(DFS.findSubsets(testArray));
    }

    @Test
    public void testLongestStringChain() {
        String[] testArr1 = {"a","b","ba","bca","bda","bdca"};
        Assert.assertEquals(4, DFS.longestStringChain(testArr1));
        String[] testArr2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        Assert.assertEquals(5, DFS.longestStringChain(testArr2));
        String[] testArr3 = {"abcd","dbqca"};
        Assert.assertEquals(1, DFS.longestStringChain(testArr3));
    }

    @Test
    public void testUniquePathsIII() {
        int[][] testArr1 = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        Assert.assertEquals(2, DFS.uniquePathsIII(testArr1));
        int[][] testArr2 = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        Assert.assertEquals(4, DFS.uniquePathsIII(testArr2));
        int[][] testArr3 = {{0,1},{2,0}};
        Assert.assertEquals(0, DFS.uniquePathsIII(testArr3));
    }

    @Test
    public void testNumIslands() {
        char[][] testArr1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Assert.assertEquals(1, DFS.numIslands(testArr1));
        char[][] testArr2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Assert.assertEquals(3, DFS.numIslands(testArr2));
    }
}
