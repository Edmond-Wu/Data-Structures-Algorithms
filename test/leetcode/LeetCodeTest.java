package leetcode;

/**
 * Created by Edmond Wu on 8/23/2017.
 */


import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

/**
 * Tests various LeetCode methods
 * @author Edmond Wu
 *
 */
public class LeetCodeTest {
	@Test
	public void testBinarySearch() {
		int[] testArray = {1, 3, 5, 6};
		Assert.assertEquals(2, LeetCode.binarySearch(testArray, 5));
		Assert.assertEquals(1, LeetCode.binarySearch(testArray, 2));
		Assert.assertEquals(4, LeetCode.binarySearch(testArray, 7));
		Assert.assertEquals(0, LeetCode.binarySearch(testArray, 0));
		Assert.assertEquals(3, LeetCode.binarySearch(testArray, 6));
		Assert.assertEquals(0, LeetCode.binarySearch(new int[0], 5));
	}

	@Test
	public void testMinMaxArray() {
		int[] arr = {5, 24, 15, 16, 8, 4, 7, 2, 50, 10, 10};
		Assert.assertEquals(2, LeetCode.minArray(arr));
		Assert.assertEquals(50, LeetCode.maxArray(arr));
	}
	
	@Test
	public void testReverseString() {
		String test = "stringtest";
		Assert.assertEquals(LeetCode.reverseString(test), "tsetgnirts");
	}
	
	@Test
	public void testCanWinNim() {
		Assert.assertFalse(LeetCode.canWinNim(8));
		Assert.assertTrue(LeetCode.canWinNim(7));
	}
	
	@Test
	public void testRepeatAddDigits() {
		Assert.assertEquals(LeetCode.repeatAddDigits(12234), 3);
		Assert.assertEquals(LeetCode.repeatAddDigits(279), 9);
		Assert.assertEquals(LeetCode.repeatAddDigits(0), 0);
		
	}
	
	@Test
	public void testColumnTitleToNumber() {
		Assert.assertEquals(LeetCode.columnTitleToNumber("A"), 1);
		Assert.assertEquals(LeetCode.columnTitleToNumber("AA"), 27);
		Assert.assertEquals(LeetCode.columnTitleToNumber("ZZ"), 702);
	}
	
	@Test
	public void testRle() {
		String uncompressed = "qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT";
		Assert.assertEquals("q9w5e2rt5y4qw2Er3T", LeetCode.rle(uncompressed));
		Assert.assertEquals("", LeetCode.rle(""));
	}
	
	@Test
	public void testFactorial() {
		Assert.assertEquals(LeetCode.factorial(0), 1);
		Assert.assertEquals(LeetCode.factorial(5), 120);
		Assert.assertEquals(LeetCode.factorial(12), 479001600);
	}

	@Test
	public void testAppealSum() {
		Assert.assertEquals(28, LeetCode.appealSum("abbca"));
		Assert.assertEquals(20, LeetCode.appealSum("code"));
		Assert.assertEquals(105, LeetCode.appealSum("leetcode"));
	}
}
