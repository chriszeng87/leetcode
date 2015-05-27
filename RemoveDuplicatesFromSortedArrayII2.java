import java.util.HashMap;
import java.util.Map;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author Chris
 * 
 */
public class RemoveDuplicatesFromSortedArrayII2 {
	
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        

        int newTail = 1;
        int tempCount = 1;
        int lastVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == lastVal) {
                if(tempCount == 2) {
                    continue;
                } else {
                    tempCount++;
                    nums[newTail] = nums[i];
                    newTail++;
                }
            } else {
                    nums[newTail] = nums[i];
                    newTail++;
                    lastVal = nums[i];
                    tempCount = 1;
            }
        }

        
        return newTail;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,2,3};
		int size = removeDuplicates(nums);
		System.out.println("-----size = " + size);
	}

}
