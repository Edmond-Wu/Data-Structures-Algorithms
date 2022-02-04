package leetcode;

import java.util.*;

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
        if(num == 0) {
            return 0;
        }
        else if(num % 9 == 0) {
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
     * Generates a list of numbers by comparing 2 adjacent digits in the input and replaces the 2 with the larger of the 2 compared digits
     * then finds the smallest number in that list of numbers
     * @param n input
     * @return smallest number generated by replacing 2 adjacent digits with the larger of the 2 digits
     */
    public static int compareAdjacents(int n) {
        if (n < 10) {
            return n;
        }
        Set<Integer> numbers = new HashSet<>();
        //convert n to string form
        String stringForm = n + "";
        //compare each set of 2 adjacent numbers, pick larger one and form new string, then add to set
        for (int i = 0; i < stringForm.length() - 1; i++) {
            int first = Integer.parseInt(stringForm.charAt(i) + "");
            int second = Integer.parseInt(stringForm.charAt(i + 1) + "");
            int larger = Math.max(first, second);
            StringBuilder sub = new StringBuilder(stringForm);
            if (larger == first) {
                sub.deleteCharAt(i + 1);
            }
            else {
                sub.deleteCharAt(i);
            }
            numbers.add(Integer.parseInt(sub.toString()));
        }
        return Collections.min(numbers);
    }

    /**
     * Method to find the minimum amount of coins to add up to a certain value
     * @param coins array of types of coins
     * @param value value to be matched
     * @return minimum number of coins to add up to that value
     */
    public static int minCoins(int[] coins, int value) {
        //table stores the min number of coins for value i
        int[] table = new int[value + 1];
        table[0] = 0;
        //initialize as infinite
        for (int i = 1; i <= value; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        //get minimum coins for values 1 to value
        for (int i = 1; i <= value; i++) {
            //iterate through coins smaller than i
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int subAnswer = table[i - coins[j]];
                    if (subAnswer != Integer.MAX_VALUE && subAnswer + 1 < table[i]) {
                        table[i] = subAnswer + 1;
                    }
                }
            }
        }
        return table[value];
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
					compressed.append(consecutive + "" + c);
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
    	long answer = (long)x;
    	for (int i = x - 1; i >= 1; i--) {
    		answer *= i;
    	}
    	return answer;
    }
    
    /**
     * Gets distinct combinations of set length of a String of distinct, lexicographically sorted characters
     * Set combinations don't have repeating letters
     * @param characters
     * @param combinationLength
     * @return
     */
    public static List<String> getCombinations(String characters, int combinationLength) {
    	List<String> comboList = new ArrayList<>();
    	buildCombinations(characters, combinationLength, comboList, 0, new StringBuilder());
    	return comboList;
    }
    
    /**
     * Helper, recursive method to getCombinations
     * @param characters
     * @param combinationLength
     * @param comboList
     * @param startIndex
     * @param sb
     */
    private static void buildCombinations(String characters, int combinationLength, 
    		List<String> comboList, int startIndex, StringBuilder sb) {
    	if (sb.length() == combinationLength) {
    		comboList.add(sb.toString());
    		return;
    	}
    	if (sb.length() > combinationLength) {
    		return;
    	}
    	for (int i = startIndex; i < characters.length(); i++) {
    		int sbCurrentLength = sb.length();
    		sb.append(characters.charAt(i));
    		buildCombinations(characters, combinationLength, comboList, i + 1, sb);
    		sb.setLength(sbCurrentLength);
    	}
    }

    /**
     * Method to find all subsets of an array of numbers (power set)
     * @param nums non-null array of numbers
     * @return a list containing all the subsets of nums
     */
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsetsBacktrack(subsets, nums, new ArrayList<Integer>(), 0, i);
        }
        return subsets;
    }

    /**
     * Helper method using the backtracking algorithm to build the different subsets
     * @param subsets list of subsets
     * @param nums array of numbers to build subsets from
     * @param currentCombination the current subset being built
     * @param index index in the nums array
     * @param combinationLen current max length of subset to add to subsets list
     */
    private static void subsetsBacktrack(List<List<Integer>> subsets, int[] nums, List<Integer> currentCombination, int index, int combinationLen) {
        //if the current subset's size is the length of the combinationLen, add it to the subsets list and return
        if (currentCombination.size() == combinationLen) {
            subsets.add(new ArrayList<Integer>(currentCombination));
            return;
        }
        //iterate through nums from index and backtrack
        for (int i = index; i < nums.length; i++) {
            //add current value at index to combination
            currentCombination.add(nums[i]);
            //backtrack from the next index
            subsetsBacktrack(subsets, nums, currentCombination, i + 1, combinationLen);
            //reset currentCombination
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
