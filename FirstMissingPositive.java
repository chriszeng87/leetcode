import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Chris
 * 
 */
public class FirstMissingPositive {

	// set is not constant size ?
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				set.add(nums[i]);
			}
		}

		int j = 1;
		while (set.contains(j)) {
			j++;
		}
		return j;
	}

	// http://www.cnblogs.com/yuzhangcmu/p/4200096.html
	// SOLUTION 2:
	public static int firstMissingPositive2(int[] A) {
		// bug 3: when length is 0, return 1;
		if (A == null) {
			return 0;
		}

		for (int i = 0; i < A.length; i++) {
			// 1: A[i] is in the range;
			// 2: A[i] > 0.
			// 3: The target is different;
			//swap until every element are in the right position
			while (A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
				swap(A, i, A[i] - 1);
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return A.length + 1;
	}
	
	public static void swap(int[] A, int l, int r) {
		int tmp = A[l];
		A[l] = A[r];
		A[r] = tmp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 4, -1, 1};
		int missing = firstMissingPositive2(array);
		System.out.println("------missing = " + missing);
	}

}
