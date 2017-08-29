package test;

import org.junit.Test;

import junit.framework.TestCase;
import sort.StringArray;

public class StringArrayTest extends TestCase {
	@Test
	public void testStringArray() {
		int arr[] = {1, 2, 3, 4, 5};
		assertEquals("1, 2, 3, 4, 5", StringArray.arrayString(arr));
		int emptyArr[] = new int[0];
		assertEquals("", StringArray.arrayString(emptyArr));
	}
}
