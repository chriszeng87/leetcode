/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author Chris
 * 
 */
public class SingleNumber {
	
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        
        return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
