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

    /**
     * Given a string s, return the minimum # of deletions so that the frequency of each character in s is unique
     * @param s string containing only lower-case English letters
     * @return minimum # of deletions to make all frequencies unique
     */
    public static int minDeletionsUniqueFrequencies(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int minDeletions = 0;
        //find frequencies of characters
        int[] charFrequencies = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';
            charFrequencies[ascii]++;
        }
        //store frequencies in a frequency max heap
        Queue<Integer> freqMaxHeap = new PriorityQueue<>(26, (num1, num2) -> Integer.compare(num2, num1));
        for (int freq : charFrequencies) {
            if (freq > 0) {
                freqMaxHeap.add(freq);
            }
        }
        //while the heap has at least 2 elements, compare the top 2 elements and decrement one of them if they are equal
        //add back to the heap if the decremented value > 0
        while (freqMaxHeap.size() > 1) {
            int firstFreq = freqMaxHeap.poll();
            if (firstFreq == freqMaxHeap.peek()) {
                firstFreq--;
                minDeletions++;
                if (firstFreq > 0) {
                    freqMaxHeap.add(firstFreq);
                }
            }
        }
        return minDeletions;
    }

    /**
     * Given an array of meeting time intervals (start, end), return the minimum # of conference rooms needed to host all meetings
     * @param meetingIntervals 2D array where each array is of size 2 with a start time and end time of the meeting
     * @return minimum # of conference rooms needed
     */
    public static int minMeetingRooms(int[][] meetingIntervals) {
        //sort the matrix by meeting start times
        Arrays.sort(meetingIntervals, Comparator.comparingInt(a -> a[0]));

        //use a heap to store the end times of meetings
        Queue<Integer> endTimeHeap = new PriorityQueue<>();

        for (int[] meeting : meetingIntervals) {
            //if the heap isn't empty, compare the current meeting start to the earliest meeting to end
            if (!endTimeHeap.isEmpty()) {
                //if the earliest meeting ends before the current one, remove it from the heap
                if (endTimeHeap.peek() <= meeting[0]) {
                    endTimeHeap.poll();
                }
            }
            //add the current meeting end to the heap
            endTimeHeap.add(meeting[1]);
        }

        //# of conference rooms is the size of the heap at the end
        return endTimeHeap.size();
    }

    /**
     * Given an n * n matrix where both rows and columns are sorted in ascending order, find
     * the kth smallest element in the matrix
     * @param matrix n * n matrix
     * @param k value of k
     * @return the kth smallest number in the matrix
     */
    public static int kthSmallestNumberInMatrix(int[][] matrix, int k) {
        //store smallest element of every row in a min-heap
        //go from 1 to k, polling the smallest element, and then replacing that with the next element in that same row
        //represent heap items as a 3-size array of [value, row, col]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(matrix.length, Comparator.comparingInt(o -> o[0]));

        //only add up to the smaller between k and the length of the matrix
        for (int row = 0; row < Math.min(matrix.length, k); row++) {
            int[] heapEntry = new int[3];
            heapEntry[0] = matrix[row][0];
            heapEntry[1] = row;
            minHeap.add(heapEntry);
        }

        //now iterate through k
        for (int i = 1; i < k; i++) {
            int[] minEntry = minHeap.poll();
            int row = minEntry[1];
            int col = minEntry[2];
            if (col < matrix.length - 1) {
                int[] nextEntry = new int[3];
                nextEntry[0] = matrix[row][col + 1];
                nextEntry[1] = row;
                nextEntry[2] = col + 1;
                minHeap.add(nextEntry);
            }
        }

        //return the top of the heap
        return minHeap.peek()[0];
    }
}
