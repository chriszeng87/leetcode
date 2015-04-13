/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. 
 * Each element in the array represents your maximum jump length at that position. Determine if you are 
 * able to reach the last index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
 * 
 * @author Chris
 *
 */
public class JumpGame {
	
	static boolean isReachable(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
		
		boolean[][] reachable = new boolean[A.length][A.length];
		
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] > 0) {
				int k = 1;
				while(k <= A[i] && i + k < A.length) {
					reachable[i][i + k] = true;
					k++;
				}
			}
		}
		
		for (int end = A.length - 1 ; end >= 0; end--) {
			for (int mid = end - 1; mid >= 0; mid--) {
				for (int start = mid - 1; start >= 0; start--)
				if (reachable[start][mid] && reachable[mid][end]) {
					reachable[start][end] = true;
				}
			}
		}
		
		return reachable[0][A.length - 1];
	}
	
	public static boolean canJump(int[] A) {
	    if(A.length <= 1)
	        return true;
	 
	    int max = A[0];
	 
	    for(int i=0; i<A.length; i++){
	        //if not enough to go to next
	        if(max <= i && A[i] == 0) 
	            return false;
	 
	        //update max    
	        if(i + A[i] > max){
	            max = i + A[i];
	        }
	 
	        //max is enough to reach the end
	        if(max >= A.length-1) 
	            return true;
	    }
	 
	    return false;    
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,3,1,1,4};
		System.out.println("--------- " + isReachable(arr));
		System.out.println("--------- " + canJump(arr));		
		
		int[] arr2 = {3,2,1,0,4};
		System.out.println("--------- " + isReachable(arr2));
		System.out.println("--------- " + canJump(arr2));
		
		int[] arr3 = {1,3,0,1,2,1,2,0,4};
		System.out.println("--------- " + isReachable(arr3));
		System.out.println("--------- " + canJump(arr3));		
		
		int[] arr4 = {2,3,0,2,0,2};
		System.out.println("--------- " + isReachable(arr4));
		System.out.println("--------- " + canJump(arr4));

	}
	
	/*
	 * We can track the maximum length a position can reach. The key to solve this problem is to find 
	 * 2 conditions: 1) the position can not reach next step (return false) , and 2) the maximum reach 
	 * the end (return true).
	 */

}
