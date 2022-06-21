package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class BFSTest {
    @Test
    public void testPlagueOranges() {
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        Assert.assertEquals(4, BFS.plagueOranges(grid1));
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        Assert.assertEquals(-1, BFS.plagueOranges(grid2));
        int[][] grid3 = {{0,2}};
        Assert.assertEquals(0, BFS.plagueOranges(grid3));
    }

    @Test
    public void testShortestPathToFood() {
        char[][] grid1 = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
        Assert.assertEquals(3, BFS.shortestPathToFood(grid1));
        char[][] grid2 = {{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
        Assert.assertEquals(-1, BFS.shortestPathToFood(grid2));
        char[][] grid3 = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
        Assert.assertEquals(6, BFS.shortestPathToFood(grid3));
    }
}
