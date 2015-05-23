import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Chris
 * 
 */
public class FirstMissingPositive {
	
	// set is not constant size ?
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }
        
        int j = 1;
        while(set.contains(j)) {
            j++;
        }
        return j;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
