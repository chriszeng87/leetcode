/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Chris
 * 
 */
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		int ret = -1;
		if (nums == null || nums.length == 0) {
			return ret;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (nums[left] < nums[mid]) {
				// the left part is ordered
				if (target >= nums[left] && target <= nums[mid]) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				// the right part is ordered
				if (target >= nums[mid] && target <= nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}

		if (nums[left] == target) {
			return left;
		}

		if (nums[right] == target) {
			return right;
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
