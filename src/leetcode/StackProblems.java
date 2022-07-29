package leetcode;

import java.util.Stack;

public class StackProblems {
    /**
     * Given a string consisting of "(" and ")", return the length of the longest valid parentheses that can be formed from the string
     * A valid parentheses is "well-formed" where each opening and closing parentheses is perfectly matched
     * @param s parentheses string
     * @return length of the longest valid parentheses substring
     */
    public static int longestValidParentheses(String s) {
        //base cases
        if (s == null || s.length() < 1) {
            return 0;
        }

        int maxLen = 0;
        //use a stack to keep track of the indices
        Stack<Integer> parenStack = new Stack<>();
        //start by pushing -1 onto the stack to account for the beginning, as stack calculations are done as a difference of indices
        parenStack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            //if it's an open parentheses, push the index onto the stack
            if (s.charAt(i) == '(') {
                parenStack.push(i);
            }
            //otherwise, pop the stack
            else {
                parenStack.pop();
                //check if the stack is empty, if the stack is empty then push i onto the stack
                if (parenStack.isEmpty()) {
                    parenStack.push(i);
                }
                //otherwise, the valid parentheses length is (i - stack top element)
                else {
                    int validLen = i - parenStack.peek();
                    maxLen = Math.max(validLen, maxLen);
                }
            }
        }
        return maxLen;
    }

    /**
     * Given an array of integer nums, find the minimum of every contiguous subarray in nums, and find the sum of those minimums
     * @param nums array of integers
     * @return sum of the subarray minimums, modulo 10^9 + 7 to keep the size within integer limits
     */
    public static int sumOfSubarrayMinimums(int[] nums) {
        //use a combination of a monotonic decreasing stack to keep track of the index of the last element smaller than the current iteration
        //and a dynamic programming array to keep track of the subarray min sums that end with each element in nums
        Stack<Integer> monotoneStack = new Stack<>();
        int[] dp = new int[nums.length];
        int mod = 1000000007;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            //if the current element is smaller than the top of the stack, pop the stack until it isn't
            while (!monotoneStack.isEmpty() && nums[i] < nums[monotoneStack.peek()]) {
                monotoneStack.pop();
            }

            //if the stack is empty, then dp[i] is the current value * (i + 1)
            if (monotoneStack.isEmpty()) {
                dp[i] = (i + 1) * nums[i];
            }
            //otherwise use the value of the dp array at the index of the top of the stack
            else {
                dp[i] = dp[monotoneStack.peek()] + (i - monotoneStack.peek()) * nums[i];
            }

            //update the total with the dp value and push i onto the stack
            total = (total + dp[i]) % mod;
            monotoneStack.push(i);
        }
        return total;
    }
}
