package sort;

/**
 * Created by Edmond Wu on 8/23/2016.
 */
public class StringArray {
    /**
     * Gets the string form of an array
     * @param arr input array
     * @return array in string form
     */
    public static String arrayString(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length - 1; i++) {
            result += (arr[i] + ",");
        }
        result += arr[arr.length - 1];
        return result;
    }
}
