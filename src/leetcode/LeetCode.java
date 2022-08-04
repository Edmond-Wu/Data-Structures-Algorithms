package leetcode;


import java.util.Arrays;

/**
 * Created by Edmond Wu on 8/22/2016.
 */
public class LeetCode {

    /**
     * Binary search algorithm that returns the index of the target
     * If the index doesn't exist then return the index where it should be placed
     * @param arr array of integers
     * @param target target to search for
     * @return index of the target or where it should be if it's not found
     */
    public static int binarySearch(int[] arr, int target) {
        //if the array length is 0, return 0
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //sort the array
        Arrays.sort(arr);
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //if it's a match, return the index
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            //update the index
            index = mid;
        }
        //if the element wasn't found, return the index where it should be
        //check the number at index, if the target is bigger than that return index + 1
        if (arr[index] < target) {
            index++;
        }
        return index;
    }

    /**
     * Method to find smallest number in the array
     * @param arr input array of integers
     * @return smallest value in array
     */
    public static int minArray(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        for (int num : arr) {
            smallest = Math.min(smallest, num);
        }
        return smallest;
    }

    /**
     * Method to find biggest number in the array
     * @param arr input array of integers
     * @return biggest value in array
     */
    public static int maxArray(int[] arr) {
        int biggest = Integer.MIN_VALUE;
        for (int num : arr) {
            biggest = Math.max(biggest, num);
        }
        return biggest;
    }

    /**
     * Method to reverse a string
     * @param s input string
     * @return reversed string
     */
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Method to determine whether you can win the Nim game
     * The game starts with a number of stones on the table
     * 2 players take turns removing 1-3 stones from the table
     * Whoever removes the last stone wins
     * @param n number of stones
     * @return true if you can win, false otherwise
     */
    public static boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }

    /**
     * Sums the digits of a number until there's only 1 number left
     * @param num input number
     * @return number returned by repeatedly summing up its digits
     */
    public static int repeatAddDigits(int num) {
        if (num == 0) {
            return 0;
        }
        else if (num % 9 == 0) {
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
    public static int columnTitleToNumber(String s) {
        //'A' = 65'
    	s = s.toUpperCase();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
        	//start in reverse order of the string
            char c = s.charAt(s.length() - i - 1);
            int ascii = (int)c - 64;
            sum += (Math.pow(26, i) * ascii);
        }
        return sum;
    }

    /**
     * RLE compression algorithm
     * @param input an uncompressed input string
     * @return source string in RLE-compressed form
     */
    public static String rle(String input) {
    	if (input.length() == 0) {
			return "";
		}
		StringBuilder compressed = new StringBuilder();
		int consecutive = 1;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (i != input.length() - 1 && c == input.charAt(i + 1)) {
				consecutive++;
			}
			else {
				if (consecutive == 1) {
					compressed.append(c);
				}
				else {
					compressed.append(consecutive);
                    compressed.append(c);
				}
				consecutive = 1;
			}
		}
		return compressed.toString();
    }
    
    /**
     * Calculates the factorial of a number
     * @param x input number
     * @return x * (x - 1) * (x - 2)... * 2 * 1
     */
    public static long factorial(int x) {
    	if (x == 0) {
    		return 1;
    	}
    	long answer = 1;
        for (int i = 1; i <= x; i++) {
            answer *= i;
        }
    	return answer;
    }

    /**
     * Given a binary string of 1's and 0's, return the minimum # of swaps to make the string a palindrome, or -1 if it's impossible
     * @param binaryString string of only 1's and 0's
     * @return minimum # of swaps to make the string a palindrome, or -1 otherwise
     */
    public static int minSwapsToMakeBinaryStringPalindrome(String binaryString) {
        int len = binaryString.length();
        if (len <= 1) {
            return 0;
        }
        //count the # of times the indices don't match
        //every 2 times you can make a swap
        int numDifferences = 0;
        int leftIndex = 0;
        int rightIndex = len - 1;
        while (leftIndex < rightIndex) {
            if (binaryString.charAt(leftIndex) != binaryString.charAt(rightIndex)) {
                numDifferences++;
            }
            leftIndex++;
            rightIndex--;
        }
        //even length but odd differences means it's impossible
        if (numDifferences % 2 != 0 && len % 2 == 0) {
            return -1;
        }
        //number of swaps is half of the differences rounded up
        return (numDifferences + 1) / 2;
    }

    /**
     * Find the sum of the # of distinct characters found in every substring in s
     * @param s string of lower-case English characters
     * @return the sum of the "appeal" of all sub-strings, the # of distinct characters in each substring
     */
    public static long appealSum(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        long sum = 0;
        //use an array to keep track of the last-seen occurrence of each character in s
        int[] lastSeen = new int[26];
        //initialize it to be -1 for every value as no character is seen yet
        Arrays.fill(lastSeen, -1);

        //iterate through each character in s
        for (int i = 0; i < length; i++) {
            //for a character at i to contribute to a distinct character
            //the given substring must start before i and end after the previously last-seen occurrence of the character at i
            int ascii = s.charAt(i) - 'a';

            //there are (i - lastSeen[ascii]) possible start positions for the substring to contain the character at i
            //length - i possible end positions for the substring
            //multiply the 2 and add to the sum to get total # of substrings that can contribute the current character
            sum += (long) (i - lastSeen[ascii]) * (length - i);

            //update the last-seen occurrence of character at i
            lastSeen[ascii] = i;
        }

        return sum;
    }
}
