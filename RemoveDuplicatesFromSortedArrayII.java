/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?

 * For example, given sorted array A = [1,1,1,2,2,3], your function should return length = 5, 
 * and A is now [1,1,2,2,3].
 * 
 * @author Chris
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
	
	static int removeDuplicates(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int dupSecond = 0;
		int tempDupTimes = 0;
		int j = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i - 1]) {
				tempDupTimes++;
				if (tempDupTimes > 1) {
					dupSecond++;
					continue;
				} else {
					j++;
					array[j] = array[i];
				}
			} else {
				tempDupTimes = 0;
				j++;
				array[j] = array[i];
			}
		}
		
		for (int i = 0; i < array.length - dupSecond; i++) {
			System.out.print(array[i] + "  ");
		}
		
		System.out.println();
		
		return array.length - dupSecond;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		System.out.println("newlen = " + removeDuplicates(arr));
	}

}
