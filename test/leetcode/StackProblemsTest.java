package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class StackProblemsTest {
    @Test
    public void testLongestValidParentheses() {
        Assert.assertEquals(2, StackProblems.longestValidParentheses("(()"));
        Assert.assertEquals(4, StackProblems.longestValidParentheses(")()())"));
        Assert.assertEquals(0, StackProblems.longestValidParentheses(""));
    }

    @Test
    public void testSumOfSubarrayMinimums() {
        int[] nums1 = {3,1,2,4};
        Assert.assertEquals(17, StackProblems.sumOfSubarrayMinimums(nums1));
        int[] nums2 = {11,81,94,43,3};
        Assert.assertEquals(444, StackProblems.sumOfSubarrayMinimums(nums2));
    }
}
