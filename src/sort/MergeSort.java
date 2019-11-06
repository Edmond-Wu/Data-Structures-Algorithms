package sort;

/**
 * Created by Edmond Wu on 8/22/2016.
 */
public class MergeSort extends StringArray {

    /**
     * Merge sort
     * @param input input array
     */
    public static void sort(int[] input) {
        if (input.length <= 1) {
            return;
        }
        int mid = input.length / 2;
        int[] left = new int[mid];
        int[] right = new int[input.length - mid];
        int index = 0;
        while (index < input.length) {
        	if (index < mid) {
        		left[index] = input[index];
        	}
        	else {
        		right[index - mid] = input[index];
        	}
        	index++;
        }
        sort(left);
        sort(right);
        merge(left, right, input);
    }

    /**
     * Merges two sorted lists
     * @param left
     * @param right
     */
    public static void merge(int[] left, int[] right, int[] arrayToMerge) {
    	int leftIndex = 0;
    	int rightIndex = 0;
    	int mergeIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
        	if (left[leftIndex] < right[rightIndex]) {
        		arrayToMerge[mergeIndex] = left[leftIndex];
        		leftIndex++;
        	}
        	else {
        		arrayToMerge[mergeIndex] = right[rightIndex];
        		rightIndex++;
        	}
        	mergeIndex++;
        }
        if (leftIndex == left.length) {
        	while (rightIndex < right.length) {
        		arrayToMerge[mergeIndex] = right[rightIndex];
        		rightIndex++;
        		mergeIndex++;
        	}
        }
        else {
        	while (leftIndex < left.length) {
        		arrayToMerge[mergeIndex] = left[leftIndex];
        		leftIndex++;
        		mergeIndex++;
        	}
        }
    }
}
