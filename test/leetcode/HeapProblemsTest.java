package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class HeapProblemsTest {
    @Test
    public void testBricksAndLadders() {
        int[] buildings1 = {4,2,7,6,9,14,12};
        Assert.assertEquals(4, HeapProblems.bricksAndLadders(buildings1, 5, 1));
        int[] buildings2 = {4,12,2,7,3,18,20,3,19};
        Assert.assertEquals(7, HeapProblems.bricksAndLadders(buildings2, 10, 2));
        int[] buildings3 = {14,3,19,3};
        Assert.assertEquals(3, HeapProblems.bricksAndLadders(buildings3, 17, 0));
        int[] buildings4 = {2,7,9,3,1,2,5,9,4,6};
        Assert.assertEquals(9, HeapProblems.bricksAndLadders(buildings4, 8, 2));
    }

    @Test
    public void testFindKthLargest() {
        int[] arr1 = {3,2,1,5,6,4};
        Assert.assertEquals(5, HeapProblems.findKthLargest(arr1, 2));
        int[] arr2 = {3,2,3,1,2,4,5,5,6};
        Assert.assertEquals(4, HeapProblems.findKthLargest(arr2, 4));
    }
}
