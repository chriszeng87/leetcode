/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author Chris
 * 
 */
public class SearchForARange {

	public int[] searchRange(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return ret;
		}

		int left = 0, right = nums.length - 1;
		int index = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				index = mid;
				break;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (index == -1) {
			return ret;
		}

		left = index - 1;
		while (left >= 0 && nums[left] == target) {
			left--;
		}

		right = index + 1;
		while (right < nums.length && nums[right] == target) {
			right++;
		}

		ret[0] = left + 1;
		ret[1] = right - 1;
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
