/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return
 *  the new length.

 * Do not allocate extra space for another array, you must do this in place with constant memory.

 * For example,
 * Given input array A = [1,1,2],

 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author Chris
 *
 */
public class RemoveDuplicatesFromSortedArray {
	
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        
        int curNum = A[0];
        int curIndex = 1;
        int duplicate = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] == curNum) {
                duplicate++;
                continue;
            } else {
                A[curIndex++] = A[i];
                curNum = A[i];
            }
        }        
        return A.length - duplicate;       
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
