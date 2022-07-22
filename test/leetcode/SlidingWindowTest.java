package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowTest {

    @Test
    public void testMaxSubArrayLenPositiveProduct() {
        int[] arr1 = {1,-2,-3,4};
        Assert.assertEquals(4, SlidingWindow.maxSubArrayLenPositiveProduct(arr1));
        int[] arr2 = {0,1,-2,-3,-4};
        Assert.assertEquals(3, SlidingWindow.maxSubArrayLenPositiveProduct(arr2));
        int[] arr3 = {-1,-2,-3,0,1};
        Assert.assertEquals(2, SlidingWindow.maxSubArrayLenPositiveProduct(arr3));
    }

    @Test
    public void testMinSwaps() {
        int[] testArr1 = {1,0,1,0,1};
        Assert.assertEquals(1, SlidingWindow.minSwaps(testArr1));
        int[] testArr2 = {0,0,0,1,0};
        Assert.assertEquals(0, SlidingWindow.minSwaps(testArr2));
        int[] testArr3 = {1,0,1,0,1,0,0,1,1,0,1};
        Assert.assertEquals(3, SlidingWindow.minSwaps(testArr3));
    }

    @Test
    public void testNumKLenSubstrNoRepeats() {
        Assert.assertEquals(6, SlidingWindow.numKLenSubstrNoRepeats("havefunonleetcode", 5));
        Assert.assertEquals(0, SlidingWindow.numKLenSubstrNoRepeats("home", 5));
    }
}
