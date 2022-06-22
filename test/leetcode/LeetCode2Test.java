package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCode2Test {

    @Test
    public void testLongestIncreasingSubsequence() {
        int[] arr1 = {10,9,2,5,3,7,101,18};
        Assert.assertEquals(4, LeetCode2.longestIncreasingSubsequence(arr1));
        int[] arr2 = {0,1,0,3,2,3};
        Assert.assertEquals(4, LeetCode2.longestIncreasingSubsequence(arr2));
        int[] arr3 = {7,7,7,7,7,7,7};
        Assert.assertEquals(1, LeetCode2.longestIncreasingSubsequence(arr3));
    }
}
