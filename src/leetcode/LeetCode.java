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

    /**
     * Sums the digits of a number until there's only 1 number left
     * @param num input number
     * @return number returned by repeatedly summing up its digits
     */
    public int addDigits(int num) {
        if(num == 0) {
            return 0;
        }
        else if(num != 0 && num % 9 == 0) {
            return 9;
        }
        else {
            return num % 9;
        }
    }

    /**
     * Given an Excel column title, return its corresponding column number
     * @param s spreadsheet column ('AA', 'BC')
     * @return number of that column
     */
    public int titleToNumber(String s) {
        //'A' = 65
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length() - i - 1);
            int ascii = (int)c - 64;
            sum += (Math.pow(26, i) * ascii);
        }
        return sum;
    }
}
