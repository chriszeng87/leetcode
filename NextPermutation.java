/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 
 * 3,2,1 → 1,2,3       1,1,5 → 1,5,1
 * 
 * @author Chris
 * 
 */
public class NextPermutation {
	
    public void reverse(int[] nums, int left, int right) {
        while(left < right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
            left++;
            right--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        
        int left = -1;
        //从后往前找第一个相邻的但是左边小于右边的数left和left + 1
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                left = i;
                break;
            }
        }
        
        if(left != -1) {
            int toSwitch = nums.length - 1;
            //找到右边第一个大于nums[left]的数nums[toSwitch]
            while(nums[toSwitch] <= nums[left]) {
                toSwitch--;
            }
            //交换nums[toSwitch]和nums[left]
            int tmp = nums[left];
            nums[left] = nums[toSwitch];
            nums[toSwitch] = tmp;
            //left + 1到最后的数是单调递减的，把它们逆序
            if(left + 1 < nums.length - 1) {
                reverse(nums, left + 1, nums.length - 1);
            }
        } else {
            reverse(nums, 0, nums.length - 1);
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
