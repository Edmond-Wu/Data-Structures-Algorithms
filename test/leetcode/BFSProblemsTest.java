package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class BFSProblemsTest {
    @Test
    public void testPlagueOranges() {
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        Assert.assertEquals(4, BFSProblems.plagueOranges(grid1));
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        Assert.assertEquals(-1, BFSProblems.plagueOranges(grid2));
        int[][] grid3 = {{0,2}};
        Assert.assertEquals(0, BFSProblems.plagueOranges(grid3));
    }

    @Test
    public void testShortestPathToFood() {
        char[][] grid1 = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
        Assert.assertEquals(3, BFSProblems.shortestPathToFood(grid1));
        char[][] grid2 = {{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
        Assert.assertEquals(-1, BFSProblems.shortestPathToFood(grid2));
        char[][] grid3 = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
        Assert.assertEquals(6, BFSProblems.shortestPathToFood(grid3));
    }

    @Test
    public void testNetworkDelayTime() {
        int[][] times1 = {{2,1,1},{2,3,1},{3,4,1}};
        Assert.assertEquals(2, BFSProblems.networkDelayTime(times1, 4, 2));
        int[][] times2 = {{1,2,1}};
        Assert.assertEquals(1, BFSProblems.networkDelayTime(times2, 2, 1));
        Assert.assertEquals(-1, BFSProblems.networkDelayTime(times2, 2, 2));
    }

    @Test
    public void testNumProvinces() {
        int[][] connect1 = {{1,1,0},{1,1,0},{0,0,1}};
        Assert.assertEquals(2, BFSProblems.numProvinces(connect1));
        int[][] connect2 = {{1,0,0},{0,1,0},{0,0,1}};
        Assert.assertEquals(3, BFSProblems.numProvinces(connect2));
    }
}
