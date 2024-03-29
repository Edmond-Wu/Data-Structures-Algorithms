package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode questions focused on BFS-related algorithms
 */
public class BFSProblems {
    /**
     * Given a 2D matrix of empty spaces, fresh oranges, and rotten oranges, find the minimum time it takes for a "plague" to completely spread from the rotten
     * oranges to the fresh ones. Each minute, a rotten orange will "infect" any fresh oranges in its 4 adjacent cells, though will be blocked by any empty spaces
     * @param grid 2D matrix of 0's, 1's, and 2's, with 0 representing an empty space, 1 representing a fresh orange, and 2 representing a rotten orange
     * @return the minimum amount of "turns" it takes for a grid to be completely rotten, or -1 if it's impossible for all the oranges to be rotten
     */
    public static int plagueOranges(int[][] grid) {
        //this is a bfs problem, given the nature of the rotten oranges spreading
        //first go through the grid once to get an initial count of fresh and rotten oranges
        int cleanOranges = 0;
        //use a queue to store the cells of the rotten oranges for bfs
        Queue<int[]> rottenOrangeCells = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                //if it's a 1, increment clean oranges
                if (grid[row][col] == 1) {
                    cleanOranges++;
                }
                //if it's a 2, add the cell to the queue
                else if (grid[row][col] == 2) {
                    int[] cell = {row, col};
                    rottenOrangeCells.add(cell);
                }
            }
        }
        //now perform bfs, with the breakpoint being determined by when cleanOranges is reduced to 0 or less
        int minutes = 0;
        while (!rottenOrangeCells.isEmpty()) {
            //first check if cleanOranges is <= 0 as return condition
            if (cleanOranges <= 0) {
                return minutes;
            }
            int queueSize = rottenOrangeCells.size();
            //for each element in the queue, apply the infection to its neighbors and update the queue
            for (int i = 0; i < queueSize; i++) {
                int[] rottenCell = rottenOrangeCells.poll();
                int row = rottenCell[0];
                int col = rottenCell[1];
                //check 4 directions
                //up
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    int[] upCell = {row - 1, col};
                    //add the up cell to the queue, and change its value in the grid from 1 to 2 to update its rotten status
                    rottenOrangeCells.add(upCell);
                    grid[row - 1][col] = 2;
                    //decrement cleanOranges
                    cleanOranges--;
                }
                //down
                if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                    int[] downCell = {row + 1, col};
                    rottenOrangeCells.add(downCell);
                    grid[row + 1][col] = 2;
                    cleanOranges--;
                }
                //left
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    int[] leftCell = {row, col - 1};
                    rottenOrangeCells.add(leftCell);
                    grid[row][col - 1] = 2;
                    cleanOranges--;
                }
                //right
                if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    int[] rightCell = {row, col + 1};
                    rottenOrangeCells.add(rightCell);
                    grid[row][col + 1] = 2;
                    cleanOranges--;
                }
            }
            //increment minutes
            minutes++;
        }
        //-1 is the default return if we did not return earlier, which means the clean oranges cannot become completely rotten
        return -1;
    }

    /**
     * Given a character 2D grid, where '*' represents the starting square, 'X' represents an obstacle that can't be walked through
     * 'O' represents an empty space that can be walked through, '#' which represents a cell with food
     * Find the length of the shortest path from the start to any food cell
     * @param grid a 2D character matrix
     * @return length of the shortest path to any food cell, or -1 if a path doesn't exist
     */
    public static int shortestPathToFood(char[][] grid) {
        //first find the starting cell
        boolean foundStartingCell = false;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < grid.length; row++) {
            //break out of the outer loop once starting cell is found
            if (foundStartingCell) {
                break;
            }
            for (int col = 0; col < grid[0].length; col++) {
                //starting cell represented by '*'
                if (grid[row][col] == '*') {
                    startRow = row;
                    startCol = col;
                    foundStartingCell = true;
                    break;
                }
            }
        }
        //call bfs algorithm
        return bfsFood(grid, new boolean[grid.length][grid[0].length], startRow, startCol);
    }

    /**
     * BFS helper method to find the shortest path to a food cell. Uses BFS instead of DFS since the nature of BFS means that the first food cell encountered
     * is the shortest path by default
     * @param grid character grid representing the room with food
     * @param visited boolean grid with the same dimensions as the grid representing visited cells
     * @param startRow starting row index
     * @param startCol starting column index
     * @return length of the shortest path to a food cell, or -1 if there exists no path
     */
    private static int bfsFood(char[][] grid, boolean[][] visited, int startRow, int startCol) {
        //use a queue for BFS
        Queue<int[]> cellQueue = new ArrayDeque<>();
        int shortestPath = 0;
        cellQueue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        while (!cellQueue.isEmpty()) {
            int queueSize = cellQueue.size();
            for (int i = 0; i < queueSize; i++) {
                //poll the queue, then add the 4 neighboring cells
                int[] cell = cellQueue.poll();
                int currRow = cell[0];
                int currCol = cell[1];
                //if the current cell is a food cell, return shortestPath
                if (grid[currRow][currCol] == '#') {
                    return shortestPath;
                }
                //add the neighboring, unvisited, valid cells to the queue
                //up
                if (currRow - 1 >= 0 && grid[currRow - 1][currCol] != 'X' && !visited[currRow - 1][currCol]) {
                    cellQueue.add(new int[]{currRow - 1, currCol});
                    visited[currRow - 1][currCol] = true;
                }
                //down
                if (currRow + 1 < grid.length && grid[currRow + 1][currCol] != 'X' && !visited[currRow + 1][currCol]) {
                    cellQueue.add(new int[]{currRow + 1, currCol});
                    visited[currRow + 1][currCol] = true;
                }
                //left
                if (currCol - 1 >= 0 && grid[currRow][currCol - 1] != 'X' && !visited[currRow][currCol - 1]) {
                    cellQueue.add(new int[]{currRow, currCol - 1});
                    visited[currRow][currCol - 1] = true;
                }
                //right
                if (currCol + 1 < grid[0].length && grid[currRow][currCol + 1] != 'X' && !visited[currRow][currCol + 1]) {
                    cellQueue.add(new int[]{currRow, currCol + 1});
                    visited[currRow][currCol + 1] = true;
                }
            }
            //increment length of the shortest path
            shortestPath++;
        }
        //no path, so return -1
        return -1;
    }

    /**
     * Given a matrix times, where each row is [i, j, k] where i is the start node, j is the dest node, and k is the time it takes for a signal to go from i to j
     * From the startingNode, find the minimum time it takes for all other nodes to receive a signal from the startingNode
     * @param times 2D matrix of length 3 rows
     * @param numNodes number of nodes in the network
     * @param startingNode starting node, between 1 and numNodes inclusive
     * @return minimum time for all nodes to receive a signal from startingNode, or -1 if not all nodes can receive the signal
     */
    public static int networkDelayTime(int[][] times, int numNodes, int startingNode) {

        //DIJKSTRA'S ALGORITHM

        //create a graph, adjacency map
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
        for (int[] edge : times) {
            int source = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            if (!graph.containsKey(source)) {
                graph.put(source, new ArrayList<>());
            }
            graph.get(source).add(new Pair<>(dest, weight));
        }

        //use priority queue to store nodes by shortest distance
        Queue<Pair<Integer, Integer>> shortestNodeQueue = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        shortestNodeQueue.add(new Pair<>(0, startingNode));

        int[] signalReceivedArr = new int[numNodes + 1];
        Arrays.fill(signalReceivedArr, Integer.MAX_VALUE);
        signalReceivedArr[startingNode] = 0;

        //go through the queue and update distances
        while (!shortestNodeQueue.isEmpty()) {
            Pair<Integer, Integer> node = shortestNodeQueue.poll();
            int distanceToVertex = node.getKey();
            int vertex = node.getValue();
            //skip if the current distance is not less than the current shortest distance or if the graph doesn't have the vertex
            if (distanceToVertex > signalReceivedArr[vertex] || !graph.containsKey(vertex)) {
                continue;
            }
            //go through each neighbor
            for (Pair<Integer, Integer> neighbor : graph.get(vertex)) {
                int dest = neighbor.getKey();
                int distanceToDest = distanceToVertex + neighbor.getValue();
                //update the time in signalReceivedArr and add to queue
                if (distanceToDest < signalReceivedArr[dest]) {
                    signalReceivedArr[dest] = distanceToDest;
                    shortestNodeQueue.add(new Pair<>(distanceToDest, dest));
                }
            }
        }
        //find the max time in the signal received array to find out how long it took for all nodes to be hit
        int totalTime = 0;
        for (int i = 1; i < signalReceivedArr.length; i++) {
            //if any nodes did not receive a signal, return -1
            if (signalReceivedArr[i] == Integer.MAX_VALUE) {
                return -1;
            }
            totalTime = Math.max(totalTime, signalReceivedArr[i]);
        }
        return totalTime;
    }

    /**
     * Given a 2D matrix of city connections, where isConnected[i][j] is 1 if city i is connected to city j and 0 if not
     * A province is a network of connected cities
     * Return the # of provinces
     * @param isConnected 2D matrix of city connections
     * @return # of distinct provinces
     */
    public static int numProvinces(int[][] isConnected) {
        //use BFS
        //use a visited array to track if each city is visited
        int numCities = isConnected.length;
        int numProvinces = 0;
        boolean[] visited = new boolean[numCities];
        Queue<Integer> cityQueue = new ArrayDeque<>();
        for (int city = 0; city < numCities; city++) {
            //if it's not been visited already, add to queue
            if (!visited[city]) {
                cityQueue.add(city);
                //bfs from that city
                while (!cityQueue.isEmpty()) {
                    int deque = cityQueue.poll();
                    //mark the deque city as visited
                    visited[deque] = true;
                    //add its connections to the queue
                    for (int otherCity = 0; otherCity < numCities; otherCity++) {
                        //if the other city hasn't been visited yet and it's connected, add to queue
                        if (!visited[otherCity] && isConnected[deque][otherCity] == 1) {
                            cityQueue.add(otherCity);
                        }
                    }
                }
                //increment num provinces at the end
                numProvinces++;
            }
        }

        return numProvinces;
    }
}
