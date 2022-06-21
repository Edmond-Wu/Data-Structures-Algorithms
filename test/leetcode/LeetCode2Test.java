package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCode2Test {

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
