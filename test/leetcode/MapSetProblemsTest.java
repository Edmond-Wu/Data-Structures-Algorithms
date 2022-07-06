package leetcode;


import org.junit.Assert;
import org.junit.Test;

public class MapSetProblemsTest {
    @Test
    public void testLongestConsecutiveSequence() {
        int[] nums1 = {4,2,7,6,9,14,12};
        Assert.assertEquals(2, MapSetProblems.longestConsecutiveSequence(nums1));
        int[] nums2 = {100,4,200,1,3,2};
        Assert.assertEquals(4, MapSetProblems.longestConsecutiveSequence(nums2));
        int[] nums3 = {0,3,7,2,5,8,4,6,0,1};
        Assert.assertEquals(9, MapSetProblems.longestConsecutiveSequence(nums3));
    }

    @Test
    public void testCompareAdjacents() {
        Assert.assertEquals(MapSetProblems.compareAdjacents(9), 9);
        Assert.assertEquals(MapSetProblems.compareAdjacents(12345), 1235);
        Assert.assertEquals(MapSetProblems.compareAdjacents(12), 2);
        Assert.assertEquals(MapSetProblems.compareAdjacents(4321), 421);
    }

    @Test
    public void testLongestIncreasingSubsequence() {
        int[] arr1 = {10,9,2,5,3,7,101,18};
        Assert.assertEquals(4, MapSetProblems.longestIncreasingSubsequence(arr1));
        int[] arr2 = {0,1,0,3,2,3};
        Assert.assertEquals(4, MapSetProblems.longestIncreasingSubsequence(arr2));
        int[] arr3 = {7,7,7,7,7,7,7};
        Assert.assertEquals(1, MapSetProblems.longestIncreasingSubsequence(arr3));
    }
}
