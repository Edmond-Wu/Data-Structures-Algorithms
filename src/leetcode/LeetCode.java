package leetcode;

import java.util.*;

/**
 * Created by Edmond Wu on 8/22/2016.
 */
public class LeetCode {
    public static void main(String[] args) {

    }

    /**
     * Method to reverse a string
     * @param s input string
     * @return reversed string
     */
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Method to determine whether you can win the Nim game
     * @param n number of stones
     * @return true if you can win, false otherwise
     */
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}
