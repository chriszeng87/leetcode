/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author Chris
 * 
 */
public class RemoveElement {
	
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int tail = 0;
        int i = 0;
        while(i < nums.length) {
            if(nums[i] != val) {
                nums[tail] = nums[i];
                tail++;
            }
            i++;
        }
        
        return tail;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
