package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LeetCode2 {
    /**
     * Find the longest chain of predecessors in an array words
     * A word is a predecessor of another if you can add a single letter at any index to the word to make the other word
     * while preserving order
     * Solved with recursive DFS and a map for look-ups to prevent excessive processing
     * Go in reverse order; check longest word, delete character from it, check if that is in words, so and so forth
     * @param words an array of words
     * @return the length of the longest predecessor chain you can form
     */
    public static int longestStringChain(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);
        Map<String, Integer> chainMap = new HashMap<>();
        int maxLength = 1;
        for (String word : words) {
            maxLength = Math.max(maxLength, recursiveDfs(wordSet, chainMap, word));
        }
        return maxLength;
    }

    /**
     * Helper method for longestStringChain that performs recursive DFS to find the longest possible chain for a given word
     * @param wordSet set containing all the words in the original input array
     * @param chainMap map containing each word as a key and how long its chain length is that ends with that key
     * @param currentWord current word in the chain
     * @return length of the longest chain for that particular word
     */
    private static int recursiveDfs(Set<String> wordSet, Map<String, Integer> chainMap, String currentWord) {
        //if the map already contains the currentWord, return it
        if (chainMap.containsKey(currentWord)) {
            return chainMap.get(currentWord);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        //for each character in currentWord, delete it to form a predecessor, and check for that predecessor in the word set
        for (int i = 0; i < currentWord.length(); i++) {
            char c = currentWord.charAt(i);
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            //if the new word exists in the word set, recurse
            if (wordSet.contains(newWord)) {
                int chainLength = 1 + recursiveDfs(wordSet, chainMap, newWord);
                //update the max length
                maxLength = Math.max(maxLength, chainLength);
            }
            //re-insert the character back into the word before moving on to next character
            sb.insert(i, c);
        }
        //insert the word/max-length pairing into the map
        chainMap.put(currentWord, maxLength);
        return maxLength;
    }

    /**
     * You are given an m x n integer array grid where grid[i][j] could be:
     *
     * 1 representing the starting square. There is exactly one starting square.
     * 2 representing the ending square. There is exactly one ending square.
     * 0 representing empty squares we can walk over.
     * -1 representing obstacles that we cannot walk over.
     * @param grid an m x n matrix
     * @return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
     */
    public static int uniquePathsIII(int[][] grid) {
        //keep track of paths and visited cells with a list and a boolean array
        List<Integer> numPaths = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int startingRow = 0;
        int startingCol = 0;
        int nonObstacleCells = 0;
        //go through the grid once to find the number of non-obstacle cells (anything that is not -1) and the starting cell
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) {
                    nonObstacleCells++;
                    if (grid[i][j] == 1) {
                        startingRow = i;
                        startingCol = j;
                    }
                }
            }
        }
        //call dfs backtrack method on starting cell
        dfsBacktrack(grid, startingRow, startingCol, nonObstacleCells, numPaths, visited);
        return numPaths.size();
    }

    /**
     * Helper method for uniquePathsIII that performs the recursive DFS backtracking algorithm to find the unique paths
     * @param grid 2D matrix containing cells to be navigated
     * @param row row of the current cell
     * @param col column of the current cell
     * @param nonObstacleCells number of non-obstacle cells that remain
     * @param numPaths list containing number of paths (list size represents paths)
     * @param visited boolean visited array
     */
    private static void dfsBacktrack(int[][] grid, int row, int col, int nonObstacleCells, List<Integer> numPaths, boolean[][] visited) {
        //return case, check if the cell is the ending square and the nonObstacleCells == 1 which means we hit the end condition
        if (grid[row][col] == 2 && nonObstacleCells == 1) {
            numPaths.add(1);
            return;
        }
        //mark current cell as visited
        visited[row][col] = true;
        //recurse in the other 4 directions
        //up
        if (row - 1 >= 0 && grid[row - 1][col] != -1 && !visited[row - 1][col]) {
            dfsBacktrack(grid, row - 1, col, nonObstacleCells - 1, numPaths, visited);
        }
        //down
        if (row + 1 < grid.length && grid[row + 1][col] != -1 && !visited[row + 1][col]) {
            dfsBacktrack(grid, row + 1, col, nonObstacleCells - 1, numPaths, visited);
        }
        //left
        if (col - 1 >= 0 && grid[row][col - 1] != -1 && !visited[row][col - 1]) {
            dfsBacktrack(grid, row, col - 1, nonObstacleCells - 1, numPaths, visited);
        }
        //right
        if (col + 1 < grid[0].length && grid[row][col + 1] != -1 && !visited[row][col + 1]) {
            dfsBacktrack(grid, row, col + 1, nonObstacleCells - 1, numPaths, visited);
        }
        //after mark visited as false again
        visited[row][col] = false;
    }

    /**
     * "Shuffles" an array, by returning the array in a randomly sorted order
     * @param arr array to be shuffled
     * @return a shuffled array
     */
    public static int[] shuffleArray(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for (int num : arr) {
            arrList.add(num);
        }
        int[] shuffled = new int[arr.length];
        Random rand = new Random();
        //randomly pick element from list, add it to shuffled, then remove from arrList
        int counter = 0;
        while (!arrList.isEmpty()) {
            int randomIndex = rand.nextInt(arrList.size());
            shuffled[counter] = arrList.get(randomIndex);
            counter++;
            arrList.remove(randomIndex);
        }
        return shuffled;
    }

    /**
     * Given a 2D matrix of 0's and 1's, with 1 representing land and 0 representing water, returns the # of islands in the matrix
     * @param grid a character grid of 1's and 0's
     * @return number of islands in the grid
     */
    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                //only process if cell isn't visited
                if (!visited[row][col]) {
                    //run DFS if it's a 1
                    if (grid[row][col] == '1') {
                        dfsIsland(grid, visited, row, col);
                        numIslands++;
                    }
                    //otherwise just mark cell as visited
                    else {
                        visited[row][col] = true;
                    }
                }
            }
        }
        return numIslands;
    }

    /**
     * Helper recursive DFS method to mark the islands on the grid
     * @param grid character grid of 1's and 0's
     * @param visited boolean matrix that represents visited cells
     * @param row row of cell
     * @param col column of cell
     */
    private static void dfsIsland(char[][] grid, boolean[][] visited, int row, int col) {
        //if it's already visited or it's a '0', don't do anything
        if (grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        //mark current cell as visited
        visited[row][col] = true;
        //recurse to the neighboring adjacent cells
        //up
        if (row - 1 >= 0) {
            dfsIsland(grid, visited, row - 1, col);
        }
        //down
        if (row + 1 < grid.length) {
            dfsIsland(grid, visited, row + 1, col);
        }
        //left
        if (col - 1 >= 0) {
            dfsIsland(grid, visited, row, col - 1);
        }
        //right
        if (col + 1 < grid[0].length) {
            dfsIsland(grid, visited, row, col + 1);
        }
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
}
