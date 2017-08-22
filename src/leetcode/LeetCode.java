package leetcode;

import java.util.*;

/**
 * Created by Edmond Wu on 8/22/2016.
 */
public class LeetCode {
    public static void main(String[] args) {
        System.out.println(compareAdjacents(12345));
        int[] coins = {9, 6, 5, 1};
        System.out.println("Minimum number of coins to make 11: " + minCoins(coins, 11));
        System.out.println(rle("aaaaAAAwwwweerrr"));
        System.out.println("Factorial of 5: " + factorial(5));
    }

    /**
     * Method to find smallest number in the array
     * @param arr input array of integers
     * @return smallest value in array
     */
    public static int minArray(int[] arr) {
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    /**
     * Method to find biggest number in the array
     * @param arr input array of integers
     * @return biggest value in array
     */
    public static int maxArray(int[] arr) {
        int biggest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > biggest) {
                biggest = arr[i];
            }
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
    public static int addDigits(int num) {
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
    public static int titleToNumber(String s) {
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
        HashSet<Integer> numbers = new HashSet<>();
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
        int table[] = new int[value + 1];
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
     * @param source an uncompressed input string
     * @return source string in RLE-compressed form
     */
    public static String rle(String source) {
        StringBuilder compressed = new StringBuilder();
        int consecutive = 1;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (i != source.length() - 1 && c == source.charAt(i + 1)) {
                consecutive++;
            } else {
                if (consecutive == 1) {
                    compressed.append(c);
                }
                else if (consecutive == 2) {
                    compressed.append(c + "" + c);
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
     * @return
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
}
