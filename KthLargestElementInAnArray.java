import java.util.PriorityQueue;
/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 *  not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author Chris
 *
 */

public class KthLargestElementInAnArray {
	
    public static int findKthLargest(int[] nums, int k) {
    	if (nums == null || k > nums.length) {
    		return Integer.MIN_VALUE;
    	}
    	
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++) {
        	queue.offer(nums[i]);
        	if (queue.size() > k)
        		queue.poll();
        }
        
        int ret = queue.poll();
        
        return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		int ret = findKthLargest(nums,k);
		System.out.println("------ret = " + ret);
	}

}
