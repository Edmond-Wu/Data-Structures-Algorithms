package leetcode;

/**
 * Created by Edmond Wu on 8/23/2017.
 */


import org.junit.Assert;
import org.junit.Test;

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
	public void testCompareAdjacents() {
		Assert.assertEquals(LeetCode.compareAdjacents(9), 9);
		Assert.assertEquals(LeetCode.compareAdjacents(12345), 1235);
		Assert.assertEquals(LeetCode.compareAdjacents(12), 2);
		Assert.assertEquals(LeetCode.compareAdjacents(4321), 421);
	}
	
	@Test
	public void testMinCoins() {
		int[] coins = {1, 5, 10, 25};
		Assert.assertEquals(LeetCode.minCoins(coins, 11), 2);
		Assert.assertEquals(LeetCode.minCoins(coins, 24), 6);
		Assert.assertEquals(LeetCode.minCoins(coins, 60), 3);
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
	public void testGetCombinations() {
		Assert.assertEquals(LeetCode.getCombinations("abc", 2).size(), 3);
		Assert.assertEquals(LeetCode.getCombinations("abcd", 3).size(), 4);
	}
}
