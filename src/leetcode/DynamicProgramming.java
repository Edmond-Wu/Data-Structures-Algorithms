package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode questions that feature dynamic programming solutions
 */
public class DynamicProgramming {
    /**
     * Method to find the minimum amount of coins to add up to a certain value
     * @param coins array of types of coins
     * @param value value to be matched
     * @return minimum number of coins to add up to that value
     */
    public static int minCoins(int[] coins, int value) {
        //table stores the min number of coins for value i
        int[] table = new int[value + 1];
        //initialize as infinite
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        //get minimum coins for values 1 to value
        for (int i = 1; i <= value; i++) {
            //iterate through coins smaller than or equal to i
            for (int coin : coins) {
                if (coin <= i) {
                    //subtract coin from i to find the sub answer that would yield the current value
                    int subAnswer = table[i - coin];
                    //if the sub-answer isn't max value and adding the coin to the sub-answer is smaller than the current value, update table[i]
                    if (subAnswer != Integer.MAX_VALUE && subAnswer + 1 < table[i]) {
                        table[i] = subAnswer + 1;
                    }
                }
            }
        }
        //return the value at the last index
        return table[value];
    }

    /**
     * Given 2 strings, what is the minimum number of characters to delete from either/both strings such that the remaining substrings are equal?
     * @param s1 first string
     * @param s2 second string
     * @return minimum deletions to make the strings equal
     */
    public static int minDeletionsToMakeStringsEqual(String s1, String s2) {
        //use dynamic programming to keep track of the minimum deletions for each string up to a given length
        //use a 2D array to represent the 2 strings
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //go through both strings
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                //if either i or j is 0, then the minimum deletions is just the sum of i and j
                //ex: if i is 0 and j is 5, since i represents a substring of length 0 so all of j needs to be deleted
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                }
                //otherwise check if the characters and i - 1 and j - 1 are equal, need to subtract 1 as the indices are 0-indexed
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //they're equal, so no need to delete anything and just set the value to the previous value
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    //at least one needs to be deleted, so see whether deleting from i or j is smaller, then add 1
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * Given a dictionary of words wordDict, determine whether the string s can be broken up into words from wordDict
     * @param s input string
     * @param wordDict a list of words
     * @return true if s can be formed from words in wordDict, and false otherwise
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        //use dynamic programming
        //a boolean array that represents for each substring from the beginning, whether that substring fits the criteria
        boolean[] visitedSubstrings = new boolean[s.length() + 1];
        //set the first value to true to start the loop
        visitedSubstrings[0] = true;
        //use a set to store the dictionary for easy look-up
        Set<String> wordSet = new HashSet<>(wordDict);
        //iterate through the substrings
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                //if the value at visitedSubstrings is false, then skip
                if (!visitedSubstrings[j]) {
                    continue;
                }
                //otherwise, if the current substring is found in the set, mark the i index as true and break out
                if (wordSet.contains(s.substring(j, i))) {
                    visitedSubstrings[i] = true;
                    break;
                }
            }
        }
        //return the value that represents the full string s
        return visitedSubstrings[s.length()];
    }
}
