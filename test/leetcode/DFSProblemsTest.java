package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DFSProblemsTest {

    @Test
    public void testGetCombinations() {
        Assert.assertEquals(DFSProblems.getCombinations("abc", 2).size(), 3);
        Assert.assertEquals(DFSProblems.getCombinations("abcd", 3).size(), 4);
    }

    @Test
    public void testFindSubsets() {
        List<List<Integer>> testList = new ArrayList<>();
        //test empty array
        testList.add(new ArrayList<>());
        Assert.assertEquals(testList, DFSProblems.findSubsets(new int[0]));
        //test array with 1 element
        List<Integer> singleItemList = new ArrayList<>();
        singleItemList.add(0);
        testList.add(singleItemList);
        Assert.assertEquals(testList, DFSProblems.findSubsets(new int[1]));
        int[] testArray = {1, 2, 3};
        System.out.println(DFSProblems.findSubsets(testArray));
    }

    @Test
    public void testLongestStringChain() {
        String[] testArr1 = {"a","b","ba","bca","bda","bdca"};
        Assert.assertEquals(4, DFSProblems.longestStringChain(testArr1));
        String[] testArr2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        Assert.assertEquals(5, DFSProblems.longestStringChain(testArr2));
        String[] testArr3 = {"abcd","dbqca"};
        Assert.assertEquals(1, DFSProblems.longestStringChain(testArr3));
    }

    @Test
    public void testUniquePathsIII() {
        int[][] testArr1 = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        Assert.assertEquals(2, DFSProblems.uniquePathsIII(testArr1));
        int[][] testArr2 = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        Assert.assertEquals(4, DFSProblems.uniquePathsIII(testArr2));
        int[][] testArr3 = {{0,1},{2,0}};
        Assert.assertEquals(0, DFSProblems.uniquePathsIII(testArr3));
    }

    @Test
    public void testNumIslands() {
        char[][] testArr1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Assert.assertEquals(1, DFSProblems.numIslands(testArr1));
        char[][] testArr2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Assert.assertEquals(3, DFSProblems.numIslands(testArr2));
    }
}
