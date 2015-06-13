/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author Chris
 * 
 */
public class HouseRobber2 {
	
    public int rob(int[] num) {
        int max = 0;
        int len = num.length;
        if(num == null || len == 0) {
            return max;
        } else if (len == 1) {
            return num[0];
        }
        
        int[] maxArray = new int[len];
        maxArray[0] = num[0];
        max = Math.max(num[0], num[1]);
        maxArray[1] = max;
        
        for (int i = 2; i < len; i++) {
            maxArray[i] = Math.max(maxArray[i - 1], maxArray[i - 2] + num[i]);
            max = Math.max(max, maxArray[i]);
        }
        
        return max;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
