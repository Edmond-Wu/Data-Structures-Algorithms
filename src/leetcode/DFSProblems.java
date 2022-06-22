package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode questions focused on DFS-related algorithms like backtracking
 */
public class DFSProblems {
    /**
     * Gets distinct combinations of set length of a String of distinct, lexicographically sorted characters
     * Set combinations don't have repeating letters
     * @param characters string of characters to build combinations from
     * @param combinationLength specified length of combinations
     * @return list of combinations of given combination length
     */
    public static List<String> getCombinations(String characters, int combinationLength) {
        List<String> comboList = new ArrayList<>();
        buildCombinations(characters, combinationLength, comboList, 0, new StringBuilder());
        return comboList;
    }

    /**
     * Helper, recursive backtracking method to getCombinations
     * @param characters string of characters to build combinations from
     * @param combinationLength length of the combination to add
     * @param comboList list of combinations
     * @param startIndex starting index in characters
     * @param currentStringBuilder string builder to build the combination string
     */
    private static void buildCombinations(String characters, int combinationLength,
                                          List<String> comboList, int startIndex, StringBuilder currentStringBuilder) {
        if (currentStringBuilder.length() == combinationLength) {
            comboList.add(currentStringBuilder.toString());
            return;
        }
        for (int i = startIndex; i < characters.length(); i++) {
            //backtracking algorithm
            int sbCurrentLength = currentStringBuilder.length();
            currentStringBuilder.append(characters.charAt(i));
            buildCombinations(characters, combinationLength, comboList, i + 1, currentStringBuilder);
            currentStringBuilder.setLength(sbCurrentLength);
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
            subsetsBacktrack(subsets, nums, new ArrayList<>(), 0, i);
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
            subsets.add(new ArrayList<>(currentCombination));
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

    /**
     * Find the longest chain of predecessors in an array words
     * A word is a predecessor of another if you can add a single letter at any index to the word to make the other word
     * while preserving order
     * Solved with recursive DFS and a map for look-ups to prevent excessive processing
     * Go in reverse order; check longest word, delete character from it, check if that is in words, so on and so forth
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
}
