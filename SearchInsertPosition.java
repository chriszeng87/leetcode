/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author Chris
 * 
 */
public class SearchInsertPosition {
	
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if(target == nums[left]) {
            return left;
        } else if (target > nums[left]) {
            return left + 1;
        } else {
            return left;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
