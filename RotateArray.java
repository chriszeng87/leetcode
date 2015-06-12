/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

 * @author Chris
 *
 */
public class RotateArray {
	
    public void rotate(int[] nums, int begin ,int end) {
        while(begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        if (nums == null || k % nums.length == 0) {
            return;
        }
        
        if (k >= nums.length) {
            k = k % nums.length;
        }
        
        int cutPosition = nums.length - k;
        rotate(nums, 0, cutPosition -  1);
        rotate(nums, cutPosition, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
