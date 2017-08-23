package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import sort.QuickSort;

/**
 * Created by Edmond Wu on 8/22/2016.
 */
public class QuickSortTest {
	@Test
	public void randomInput() {
		int[] arr = {5, 24, 15, 16, 8, 4, 7, 2, 50, 10, 10};
		QuickSort.sort(arr, 0, arr.length - 1);
		assertEquals("[2, 4, 5, 7, 8, 10, 10, 15, 16, 24, 50]", Arrays.toString(arr));
	}
	
    @Test
    public void reverseInput() {
        int[] arr = {22, 21, 19, 18, 15, 14, 9, 7, 5};
        QuickSort.sort(arr, 0, arr.length - 1);
        assertEquals("[5, 7, 9, 14, 15, 18, 19, 21, 22]", Arrays.toString(arr));
    }

    @Test
    public void emptyInput() {
        int[] arr = {};
        QuickSort.sort(arr, 0, arr.length - 1);
        assertEquals("[]", Arrays.toString(arr));
    }

    @Test
    public void alreadySorted() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        QuickSort.sort(arr, 0, arr.length - 1);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr));
    }
}
