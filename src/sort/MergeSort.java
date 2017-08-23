package sort;

import java.util.Arrays;

/**
 * Created by Edmond Wu on 8/22/2016.
 */
public class MergeSort extends StringArray {

    /**
     * Merge sort
     * @param input input array
     */
    public static int[] sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int mid = input.length / 2, sizeLeft = mid;
        int[] left = Arrays.copyOfRange(input, 0, sizeLeft), right = Arrays.copyOfRange(input, sizeLeft, input.length);

        sort(left);
        sort(right);
        return merge(left, right, input);
    }

    /**
     * Merges 2 lists
     * @param left first array
     * @param right second array
     * @param array merged array
     */
    public static int[] merge(int[] left, int[] right, int[] array) {
        int leftIndex = 0, rightIndex = 0, arrIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                array[arrIndex] = left[leftIndex];
                leftIndex++;
            }
            else {
                array[arrIndex] = right[rightIndex];
                rightIndex++;
            }
            arrIndex++;
        }

        //left array finishes first
        if (leftIndex == left.length) {
            while (rightIndex < right.length) {
                array[arrIndex] = right[rightIndex];
                rightIndex++;
                arrIndex++;
            }
        }
        //right finishes first
        else {
            while (leftIndex < left.length) {
                array[arrIndex] = left[leftIndex];
                leftIndex++;
                arrIndex++;
            }
        }
        return array;
    }
}
