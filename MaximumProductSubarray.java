/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author Chris
 * 
 */
public class MaximumProductSubarray {

	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxP = nums[0];
		int minP = nums[0];
		int ret = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int a = Math.max(maxP * nums[i], minP * nums[i]);
			int b = Math.min(maxP * nums[i], minP * nums[i]);

			maxP = Math.max(a, nums[i]);
			minP = Math.min(b, nums[i]);

			ret = Math.max(maxP, ret);
		}

		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,-2,4};
		System.out.println("-------max product is " + maxProduct(nums));
	}

}
