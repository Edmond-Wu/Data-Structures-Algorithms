package test;

/**
 * Created by Edmond Wu on 8/23/2017.
 */


import org.junit.Test;

import junit.framework.TestCase;
import leetcode.LeetCode;

public class LeetCodeTest extends TestCase {
	@Test
	public void testMinMaxArray() {
		int[] arr = {5, 24, 15, 16, 8, 4, 7, 2, 50, 10, 10};
		assertEquals(2, LeetCode.minArray(arr));
		assertEquals(50, LeetCode.maxArray(arr));
	}
	
	@Test
	public void testReverseString() {
		String test = "stringtest";
		assertEquals(LeetCode.reverseString(test), "tsetgnirts");
	}
	
	@Test
	public void testCanWinNim() {
		assertFalse(LeetCode.canWinNim(8));
		assertTrue(LeetCode.canWinNim(7));
	}
	
	@Test
	public void testRepeatAddDigits() {
		assertEquals(LeetCode.repeatAddDigits(12234), 3);
		assertEquals(LeetCode.repeatAddDigits(279), 9);
		assertEquals(LeetCode.repeatAddDigits(0), 0);
	}
	
	@Test
	public void testColumnTitleToNumber() {
		assertEquals(LeetCode.columnTitleToNumber("A"), 1);
		assertEquals(LeetCode.columnTitleToNumber("AA"), 27);
		assertEquals(LeetCode.columnTitleToNumber("ZZ"), 702);
	}
	
	@Test
	public void testCompareAdjacents() {
		assertEquals(LeetCode.compareAdjacents(12345), 1235);
		assertEquals(LeetCode.compareAdjacents(12), 2);
	}
	
	@Test
	public void testMinCoins() {
		int[] coins = {1, 5, 10, 25};
		assertEquals(LeetCode.minCoins(coins, 11), 2);
		assertEquals(LeetCode.minCoins(coins, 24), 6);
		assertEquals(LeetCode.minCoins(coins, 60), 3);
	}
	
	@Test
	public void testRle() {
		String uncompressed = "qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT";
		assertEquals("q9w5e2rt5y4qw2Er3T", LeetCode.rle(uncompressed));
		assertEquals("", LeetCode.rle(""));
	}
	
	@Test
	public void testFactorial() {
		assertEquals(LeetCode.factorial(5), 120);
		assertEquals(LeetCode.factorial(12), 479001600);
	}
}
