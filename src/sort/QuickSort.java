package sort;

/**
 * Created by Edmond Wu on 8/22/2016.
 */
public class QuickSort extends StringArray {

    /**
     * Method to quicksort an array
     * @param arr input array
     * @param low lower bound
     * @param high higher bound
     * @return array in sorted form
     */
    public static int[] sort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        if (low >= high) {
            return arr;
        }

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j) {
            sort(arr, low, j);
        }
        if (high > i) {
            sort(arr, i, high);
        }
        return arr;
    }
}
