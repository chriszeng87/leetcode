/**
 * Given a sorted array and a target value, return the index if the target is found. If not, 
 * return the index where it would be if it were inserted in order. You may assume no duplicates in the array.

* Here are few examples.

 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * 
 * @author Chris
 *
 */
public class SearchInsertPosition {
	
	static int getSearchInsertPosition(int[] array, int value) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int mid;
		int left = 0;
		int right = array.length - 1;
		while (left < right && left >=0 && right <= array.length - 1) {
			mid = (left + right) /2;
			if (array[mid] == value) {
				return mid;
			} else if (array[mid] > value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		if (value > array[left]) {
			return left + 1;
		} else {
			return left;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3 , 5, 6};
		System.out.println("5's position is " + getSearchInsertPosition(arr, 5));
		System.out.println("2's position is " + getSearchInsertPosition(arr, 2));
		System.out.println("7's position is " + getSearchInsertPosition(arr, 7));
		System.out.println("0's position is " + getSearchInsertPosition(arr, 0));
		System.out.println("4's position is " + getSearchInsertPosition(arr, 4));
	}

}
