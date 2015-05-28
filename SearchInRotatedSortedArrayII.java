/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author Chris
 * 
 */
public class SearchInRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 出现重复的时候，因为重复的次数我们无从得知，原数组旋转折叠的位置我们也无从得知，所以最后折叠后的状态我们也就无从得知，
	 * 所以我们无法去按着Search in Rotated Sorted Array的判断标准去判断哪部分有序，设想一种情形1，1,
	 * 1，2，1,1,1，恰好左中右都是1,这时我们 ++左下标，--右下标，为什么这样我们不会将这个值跳过呢？
	 * 就是说，凭什么我们说除却这两个位置，在两者之间就一定还存在这个值？当然能
	 * ，因为我们进入的条件是左中右相等，所以我们可以把首尾的值都略过，进行下一次循环。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	boolean search2(int nums[], int target) {
		if (0 == nums.length)
			return false;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int midle = (left + right) >> 1;
			if (nums[midle] == target)
				return true;
			if (nums[left] == nums[midle] && nums[midle] == nums[right]) {
				++left;
				--right;
			} else if (nums[left] <= nums[midle]) {
				if (nums[left] <= target && target < nums[midle]) {
					right = midle - 1;
				} else
					left = midle + 1;
			} else {
				if (nums[midle] < target && target <= nums[right])
					left = midle + 1;
				else
					right = midle - 1;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
