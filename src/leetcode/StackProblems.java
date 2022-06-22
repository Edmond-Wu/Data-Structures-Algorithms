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
}
