/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

* Find the minimum element.You may assume no duplicate exists in the array.

 * @author Chris
 *
 */
public class FindMinimumInRotatedSortedArray {
	
	static int findMinimum(int[] array) {
		if (array == null) {
			return Integer.MAX_VALUE;
		}
		return findMinimum(array, 0, array.length - 1);
	}
	
	static int findMinimum(int[] array, int start, int end) {
		if (start == end) {
			return array[start];
		} else if (end == start + 1) {
			return Math.min(array[start], array[end]);
		}
		
		int mid = (start + end) / 2;
		if (array[start] < array[end]) {
			return array[start];
		} else if (array[mid] > array[start]) {
			//go right
			return findMinimum(array, mid, end);
		} else {
			//go left
			return findMinimum(array, start, mid);
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(findMinimum(arr));
		int[] arr2 = {4, 5, 6, 7, -3, -2, -1, 0, 1, 2};
		System.out.println(findMinimum(arr2));
		int[] arr3 = { -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7};
		System.out.println(findMinimum(arr3));
		int[] arr4 = { -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
		System.out.println(findMinimum(arr4));

	}

}
