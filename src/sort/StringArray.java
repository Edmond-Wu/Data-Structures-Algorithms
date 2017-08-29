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
    	if (arr.length < 1 || arr == null) {
    		return "";
    	}
    	StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
        	sb.append(arr[i] + ", ");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }
}
