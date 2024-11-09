package algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	@Test
	public void testSearchFound() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		int item = 21;
		assertEquals(1, BinarySearch.binarySearch(item, arr));
	}

	@Test
	public void testSearchNotFound() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		int item = 121;
		assertEquals(-1, BinarySearch.binarySearch(item, arr));
	}

	@Test
	public void testSearchFoundMiddleElement() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		int item = 34;
		assertEquals(2, BinarySearch.binarySearch(item, arr));
	}

	@Test
	public void testSearchFoundCornerElements() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		assertEquals(0, BinarySearch.binarySearch(6, arr));
		assertEquals(4, BinarySearch.binarySearch(456, arr));
	}

	@Test
	public void testSearchFoundOtherElements() {
		int[] arr = new int[] { 6, 21, 34, 76, 456, 782 };
		assertEquals(3, BinarySearch.binarySearch(76, arr));
		assertEquals(4, BinarySearch.binarySearch(456, arr));
	}

	@Test
	public void testRecursiveSearchFound() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		int item = 21;
		assertEquals(1, BinarySearch.binarySearchRecursive(item, arr, 0, arr.length));
	}

	@Test
	public void testRecursiveSearchNotFound() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		int item = 121;
		assertEquals(-1, BinarySearch.binarySearchRecursive(item, arr, 0, arr.length));
	}

	@Test
	public void testRecursiveSearchFoundMiddleElement() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		int item = 34;
		assertEquals(2, BinarySearch.binarySearchRecursive(item, arr, 0, arr.length));
	}

	@Test
	public void testRecursiveSearchFoundCornerElements() {
		int[] arr = new int[] { 6, 21, 34, 76, 456 };
		assertEquals(0, BinarySearch.binarySearchRecursive(6, arr, 0, arr.length));
		assertEquals(4, BinarySearch.binarySearchRecursive(456, arr, 0, arr.length));
	}

	@Test
	public void testRecursiveSearchFoundOtherElements() {
		int[] arr = new int[] { 6, 21, 34, 76, 456, 782 };
		assertEquals(3, BinarySearch.binarySearchRecursive(76, arr, 0, arr.length));
		assertEquals(4, BinarySearch.binarySearchRecursive(456, arr, 0, arr.length));
	}

	@Test
	public void testSearchFoundLargeArray() {
		int size = 1000;
		int[] arr = new Random().ints(size, 0, 10000).distinct().sorted().toArray();
		int randomIdx = new Random().nextInt(size - 1);
		int item = arr[randomIdx];

		long maxDuration = 1;
		long startTime = System.currentTimeMillis();
		int result = BinarySearch.binarySearch(item, arr);
		long duration = System.currentTimeMillis() - startTime;

		assertEquals(randomIdx, result);
		assertTrue(duration < maxDuration, "Method took too long to execute: " + duration + "ms");
	}

	@Test
	public void testSearchNotFoundLargeArray() {
		int size = 1000;
		int[] arr = new Random().ints(size, 0, 10000).distinct().sorted().toArray();
		int item = 20000;

		long maxDuration = 1;
		long startTime = System.currentTimeMillis();
		int result = BinarySearch.binarySearch(item, arr);
		long duration = System.currentTimeMillis() - startTime;

		assertEquals(-1, result);
		assertTrue(duration < maxDuration, "Method took too long to execute: " + duration + "ms");
	}

	@Test
	public void testRecursiveSearchFoundLargeArray() {
		int size = 10000;
		int[] arr = new Random().ints(size, 0, size - 1).distinct().sorted().toArray();
		int randomIdx = new Random().nextInt(size - 1);
		int item = arr[randomIdx];

		long maxDuration = 1;
		long startTime = System.currentTimeMillis();
		int result = BinarySearch.binarySearchRecursive(item, arr, 0, arr.length - 1);
		long duration = System.currentTimeMillis() - startTime;

		assertEquals(randomIdx, result);
		assertTrue(duration < maxDuration, "Method took too long to execute: " + duration + "ms");
	}

	@Test
	public void testRecursiveSearchNotFoundLargeArray() {
		int size = 10000;
		int[] arr = new Random().ints(size, 0, size - 1).distinct().sorted().toArray();
		int item = 20000;

		long maxDuration = 1;
		long startTime = System.currentTimeMillis();
		int result = BinarySearch.binarySearchRecursive(item, arr, 0, arr.length - 1);
		long duration = System.currentTimeMillis() - startTime;

		assertEquals(-1, result);
		assertTrue(duration < maxDuration, "Method took too long to execute: " + duration + "ms");
	}

}