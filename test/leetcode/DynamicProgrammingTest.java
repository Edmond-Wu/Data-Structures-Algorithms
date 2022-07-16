package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingTest {
    @Test
    public void testMinCoins() {
        int[] coins = {1, 5, 10, 25};
        Assert.assertEquals(DynamicProgramming.minCoins(coins, 11), 2);
        Assert.assertEquals(DynamicProgramming.minCoins(coins, 24), 6);
        Assert.assertEquals(DynamicProgramming.minCoins(coins, 60), 3);
    }

    @Test
    public void testMinDeletionsToMakeStringsEqual() {
        Assert.assertEquals(2, DynamicProgramming.minDeletionsToMakeStringsEqual("sea", "eat"));
        Assert.assertEquals(4, DynamicProgramming.minDeletionsToMakeStringsEqual("sea", "ate"));
        Assert.assertEquals(4, DynamicProgramming.minDeletionsToMakeStringsEqual("leetcode", "etco"));
        Assert.assertEquals(2, DynamicProgramming.minDeletionsToMakeStringsEqual("b", "a"));
    }

    @Test
    public void testWordBreak() {
        String s1 = "leetcode";
        String s2 = "applepenapple";
        String s3 = "catsandog";
        List<String> list1 = Arrays.asList("leet", "code");
        List<String> list2 = Arrays.asList("apple","pen");
        List<String> list3 = Arrays.asList("cats","dog","sand","and","cat");
        Assert.assertTrue(DynamicProgramming.wordBreak(s1, list1));
        Assert.assertTrue(DynamicProgramming.wordBreak(s2, list2));
        Assert.assertFalse(DynamicProgramming.wordBreak(s3, list3));
    }

    @Test
    public void testClimbStairs() {
        Assert.assertEquals(3, DynamicProgramming.climbStairs(3));
        Assert.assertEquals(5, DynamicProgramming.climbStairs(4));
        Assert.assertEquals(8, DynamicProgramming.climbStairs(5));
    }

    @Test
    public void testMinCostClimbingStairs() {
        int[] arr1 = {10,15,20};
        Assert.assertEquals(15, DynamicProgramming.minCostClimbingStairs(arr1));
        int[] arr2 = {1,100,1,1,1,100,1,1,100,1};
        Assert.assertEquals(6, DynamicProgramming.minCostClimbingStairs(arr2));
    }

    @Test
    public void testOutOfBoundaryPaths() {
        Assert.assertEquals(6, DynamicProgramming.outOfBoundaryPaths(2, 2, 2, 0, 0));
        Assert.assertEquals(12, DynamicProgramming.outOfBoundaryPaths(1, 3, 3, 0, 1));
        Assert.assertEquals(914783380, DynamicProgramming.outOfBoundaryPaths(8, 50, 23, 5, 26));
    }
}
