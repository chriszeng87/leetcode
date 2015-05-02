/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author Chris
 * 
 */
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int sum = 0;
		int tempMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
				if (sum > tempMax) {
					tempMax = sum;
				}
			} else {
				sum = sum + nums[i];
				if (sum > tempMax) {
					tempMax = sum;
				}
			}
		}

		return tempMax;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
