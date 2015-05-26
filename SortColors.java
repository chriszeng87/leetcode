/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {
	
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        
        int r = 0, w = 0, b = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                r++;
            } else if (nums[i] == 1) {
                w++;
            } else {
                b++;
            }
        }
        
        i = 0;
        while(i < r) {
            nums[i] = 0;
            i++;
        }
        
        while(i < r + w) {
            nums[i] = 1;
            i++;
        }
        
        while(i < nums.length) {
            nums[i] = 2;
            i++;
        }
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
