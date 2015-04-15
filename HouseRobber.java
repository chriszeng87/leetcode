/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
 * 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
 * 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.

 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
 * 
 * money you can rob tonight without alerting the police.

 * @author Chris
 *
 */
public class HouseRobber {
	
    public static int rob(int[] num) {
    	if (num == null || num.length == 0) {
    		return 0;
    	} else if (num.length == 1) {
    		return num[0];
    	}
    	
    	int[] maxSum = new int[num.length];
    	int max = Math.max(num[0], num[1]);
    	System.arraycopy(num, 0, maxSum, 0, num.length);
    	for (int i = 2; i < num.length; i++) {
    		for (int j = 0; j < i - 1; j++) {
    			if (maxSum[j] + num[i] > maxSum[i]) {
    				maxSum[i] = maxSum[j] + num[i];
    			}
    		}
    		if (maxSum[i] > max) {
    			max = maxSum[i];
    		}
    	}
    	
    	return max;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2, 1, 5, 10, 25};
		System.out.println("max rob sum = " + rob(array));
		int[] array2 = {1, 3, 1};
		System.out.println("max rob sum = " + rob(array2));
	}

}
