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
}
