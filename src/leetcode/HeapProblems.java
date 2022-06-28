package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode problems that focus on using heaps
 */
public class HeapProblems {
    /**
     * How far can we get through an array of buildings to climb given some ladders and bricks?
     * Ladders are a one-size-fits-all, each brick is 1 unit
     * Climbing a building can use a ladder that covers the entire climb or use bricks to cover the height difference
     * @param buildings array of heights of buildings
     * @param bricks number of bricks starting out with
     * @param ladders number of ladders starting out with
     * @return the index of the farthest building that can be made before running out of bricks/ladders
     */
    public static int bricksAndLadders(int[] buildings, int bricks, int ladders) {
        //use a min-heap to store the sizes that are used by ladders
        //we want to use ladders for the biggest climbs and bricks for the smallest
        //use ladders if available, otherwise replace the smallest ladder being used with bricks
        Queue<Integer> ladderHeap = new PriorityQueue<>();
        for (int i = 0; i < buildings.length - 1; i++) {
            int heightDiff = buildings[i + 1] - buildings[i];
            //only care about positive climbs as equal/negative climbs don't need bricks/ladders
            if (heightDiff > 0) {
                //use a ladder if available
                if (ladders > 0) {
                    ladders--;
                    ladderHeap.add(heightDiff);
                }
                else {
                    //if the heap is empty or the smallest ladder being used exceeds the current climb, use bricks
                    if (ladderHeap.isEmpty() || ladderHeap.peek() >= heightDiff) {
                        bricks -= heightDiff;
                    }
                    //replace the smallest ladder with bricks and use a ladder for the current climb
                    else {
                        bricks -= ladderHeap.poll();
                        ladderHeap.add(heightDiff);
                    }
                    //if bricks becomes negative we need to return
                    if (bricks < 0) {
                        return i;
                    }
                }
            }
        }
        //return the last building if the loop didn't prematurely exit
        return buildings.length - 1;
    }

    /**
     * Find the K-th largest element in an array of numbers
     * @param nums array of integers
     * @param k K
     * @return the K-th largest number in nums
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        //2 approaches depending on whether space or time is more important
        //for time, use a heap, for space, sort the array in place
        //use a heap as this is a Heap problem class
        Queue<Integer> minHeap = new PriorityQueue<>();
        //store the k smallest elements in the heap, when the capacity exceeds k poll the heap
        for (int num : nums) {
            minHeap.add(num);
            //if the heap exceeds k capacity poll
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        //return top element of heap
        return minHeap.peek();
    }

    /**
     * Given a 2D array of courses, where course[i][0] represents the duration of a course and course[i][1] represents the last day it has to be finished by
     * Return the max number of courses that can be taken
     * @param courses 2D array of courses represented by duration and last day
     * @return max number of courses that can be taken
     */
    public static int scheduleCourse(int[][] courses) {
        //sort the array by end day
        Arrays.sort(courses, Comparator.comparingInt(arr -> arr[1]));
        //keep track of the current time while taking classes
        int scheduleTime = 0;
        //use a max-heap to store classes
        //as we iterate through courses, if we come across a class we can't take we can remove the longest class taken
        Queue<Integer> maxHeap = new PriorityQueue<>(courses.length, (num1, num2) -> Integer.compare(num2, num1));
        for (int[] course : courses) {
            //can take the class, so update the time and add to heap
            if (scheduleTime + course[0] <= course[1]) {
                scheduleTime += course[0];
                maxHeap.add(course[0]);
            }
            //need to remove the largest element from the heap and update time appropriately
            //obviously only do this if the heap is not empty
            else if (!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
                scheduleTime += course[0] - maxHeap.poll();
                maxHeap.add(course[0]);
            }
        }
        return maxHeap.size();
    }
}
