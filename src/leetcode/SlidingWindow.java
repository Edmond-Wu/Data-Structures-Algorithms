package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode problems that focus on the "sliding-window" algorithm
 */
public class SlidingWindow {
    /**
     * Given an array of integers, return the length of the longest subarray where the product of its values is positive
     * Sliding Window problem
     * @param nums an array of integers
     * @return length of the longest subarray of nums where the product of its elements is positive
     */
    public static int maxSubArrayLenPositiveProduct(int[] nums) {
        int maxLength = 0;
        //keep track of the number of negative values, index of the first negative number, and index of 0
        int numNegatives = 0;
        int firstNegativeIndex = -1;
        int zeroIndex = -1;
        //these values will be updated as the array is traversed via "sliding window"
        for (int i = 0; i < nums.length; i++) {
            //if it's negative, increment numNegatives and update the first index if it hasn't been updated
            if (nums[i] < 0) {
                numNegatives++;
                if (firstNegativeIndex == -1) {
                    firstNegativeIndex = i;
                }
            }
            //if the value is 0, then a reset is needed as 0 cannot be included in the subarray
            if (nums[i] == 0) {
                numNegatives = 0;
                firstNegativeIndex = -1;
                //update zeroIndex
                zeroIndex = i;
            }
            else {
                //find sub-array length based on numNegatives
                //even number of negatives, so subarray from zeroIndex to i
                int subLength;
                if (numNegatives % 2 == 0) {
                    subLength = i - zeroIndex;
                }
                //odd number of negatives, so exclude the first negative index
                else {
                    subLength = i - firstNegativeIndex;
                }
                //update max length
                maxLength = Math.max(maxLength, subLength);
            }
        }
        return maxLength;
    }

    /**
     * Counts the minimum number of swaps needed to group all the 1's together in an array of 1's and 0's
     * @param data an array of only 1's and 0's
     * @return minimum number of swaps to group all the 1's together
     */
    public static int minSwaps(int[] data) {
        //count number of 1's
        //that number is the size of the final group
        //find sub-array of that size in data that has the most amount of 1's
        int numOnes = 0;
        for (int num : data) {
            if (num == 1) {
                numOnes++;
            }
        }
        int maxNumOnesInSubArr = 0;
        int leftBound = 0;
        int rightBound = 0;
        int oneCount = 0;
        //track max # of 1's in every sub-array of size numOnes
        while (rightBound < data.length) {
            //increase the right side and update the oneCount; can just add directly since array
            //will only have 1's and 0's
            oneCount += data[rightBound];
            rightBound++;
            //if the rightBound - leftBound exceeds the sub-array size, move up the leftBound and remove the old value
            //from oneCount
            if (rightBound - leftBound > numOnes) {
                oneCount -= data[leftBound];
                leftBound++;
            }
            maxNumOnesInSubArr = Math.max(maxNumOnesInSubArr, oneCount);
        }
        //answer is the total # of 1's minus the max 1's in sub-array
        return numOnes - maxNumOnesInSubArr;
    }

    /**
     * Given a string s and integer k, find the number of k-length substrings in s that have no repeating characters
     * @param s string with only lower-case English letters
     * @param k length of substring
     * @return number of substrings that have no repeating characters
     */
    public static int numKLenSubstrNoRepeats(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        int numStrings = 0;
        //use 2 pointers for sliding window
        int leftPtr = 0;
        int rightPtr = 0;
        //use an int array of size 26 to track frequencies
        int[] frequencies = new int[26];
        while (rightPtr < s.length()) {
            //update frequency
            char rightC = s.charAt(rightPtr);
            frequencies[rightC - 'a']++;

            //if the frequency of rightC exceeds 1, move up leftPtr and decrement frequencies until the duplicate is removed
            while (frequencies[rightC - 'a'] > 1) {
                frequencies[s.charAt(leftPtr) - 'a']--;
                leftPtr++;
            }

            //if the distance between left and right pointers is k, then increment the count
            if (rightPtr - leftPtr + 1 == k) {
                numStrings++;
                //move up the left ptr and update frequency since that substring is done
                frequencies[s.charAt(leftPtr) - 'a']--;
                leftPtr++;
            }
            rightPtr++;
        }
        return numStrings;
    }

    /**
     * Given 2 strings s and p, find the start indices of p's anagrams in s.
     * @param s string to find anagrams in
     * @param p string to be compared to for anagrams
     * @return a list of indices of anagrams of p in s
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndices = new ArrayList<>();
        if (s.length() < p.length()) {
            return anagramIndices;
        }
        //count frequencies in p
        int[] pFreqs = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreqs[p.charAt(i) - 'a']++;
        }
        //find frequencies of the substring at index 0
        int[] sFreqs = new int[26];
        for (int j = 0; j < p.length(); j++) {
            sFreqs[s.charAt(j) - 'a']++;
        }
        if (Arrays.equals(sFreqs, pFreqs)) {
            anagramIndices.add(0);
        }
        //go through rest of s
        for (int k = 1; k < s.length() - p.length() + 1; k++) {
            //delete char occurrence of previous index as it's not in the window anymore
            sFreqs[s.charAt(k - 1) - 'a']--;
            //add char occurrence of the end of the new window
            sFreqs[s.charAt(k + p.length() - 1) - 'a']++;
            if (Arrays.equals(sFreqs, pFreqs)) {
                anagramIndices.add(k);
            }
        }
        return anagramIndices;
    }
}
