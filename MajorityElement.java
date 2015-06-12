import java.util.Arrays;

/**
 * Problem:

 * Given an array of size n, find the majority element. The majority element is the element 
 * that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * @author Chris
 *
 */
public class MajorityElement {
	
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
