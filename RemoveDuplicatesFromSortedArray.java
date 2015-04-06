/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and 
 * return the new length. Do not allocate extra space for another array, you must do this in place 
 * with constant memory.

* For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
 * 
 * @author Chris
 *
 */
public class RemoveDuplicatesFromSortedArray {
	
	static int removeDuplicates(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int dupSum = 0;
		int j = 0;
		for (int i = 1; i < array.length; i++) {
			if(array[i] == array[i - 1]) {
				dupSum++;
				continue;
			} else {
				j++;
				array[j] = array[i];
			}
		}
		
		for (int i = 0; i < array.length - dupSum; i++) {
			System.out.print(array[i] + "  ");
		}
		
		return array.length - dupSum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3};
		System.out.println("newlen = " + removeDuplicates(arr) + "\n");
		
		int[] arr2 = {1, 2, 2, 3, 3};
		System.out.println("newlen = " + removeDuplicates(arr2) + "\n");
		
		int[] arr3 = {1, 2, 3, 4};
		System.out.println("newlen = " + removeDuplicates(arr3) + "\n");
		
		int[] arr4 = {1, 2, 2, 2};
		System.out.println("newlen = " + removeDuplicates(arr4) + "\n");

	}

}
