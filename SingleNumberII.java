/**
 * Single Number II Total Accepted: 47591 Total Submissions: 136724 My
 * Submissions Question Solution Given an array of integers, every element
 * appears three times except for one. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author Chris
 * 
 */
public class SingleNumberII {
	
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) != 0) {
                    count[i]++;
                }
            }
            
            result = result | ((count[i] % 3) << i);
        }
        
        return result;
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
