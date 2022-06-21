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
}
