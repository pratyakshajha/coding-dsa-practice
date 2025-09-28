package algorithms;

public class BinarySearch {

	public static int binarySearch(int item, int[] arr) {

		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (item == arr[mid]) {
				return mid;
			}
			// search left half
			else if (item < arr[mid]) {
				right = mid - 1;
			}
			// search right half
			else if (item > arr[mid]) {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearchRecursive(int item, int[] arr, int left, int right) {
		if (left > right)
			return -1;

		int leftResult = -1;
		int rightResult = -1;
		int mid = left + (right - left) / 2;
		if (item == arr[mid]) {
			return mid;
		} else if (item < arr[mid]) {
			leftResult = binarySearchRecursive(item, arr, left, mid - 1);
		} else {
			rightResult = binarySearchRecursive(item, arr, mid + 1, right);
		}
		return leftResult != -1 ? leftResult : rightResult;
	}

}
