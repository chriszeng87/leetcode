import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem:

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    
 * @author Chris
 *
 */


public class ThreeSum {
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		if (num.length < 3)
			return result;
	 
		// sort array
		Arrays.sort(num);
	 
		for (int i = 0; i < num.length - 2; i++) {
			// //avoid duplicate solutions
			// ensure that num[i] != num[i-1] when i>= 0
			if (i == 0 || num[i] > num[i - 1]) {
	 
				int negate = -num[i];
	 
				int start = i + 1;
				int end = num.length - 1;
	 
				while (start < end) {
					//case 1
					if (num[start] + num[end] == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[start]);
						temp.add(num[end]);
	 
						result.add(temp);
						start++;
						end--;
						//avoid duplicate solutions
						while (start < end && num[end] == num[end + 1])
							end--;
	 
						while (start < end && num[start] == num[start - 1])
							start++;
					//case 2
					} else if (num[start] + num[end] < negate) {
						start++;
					//case 3
					} else {
						end--;
					}
				}
	 
			}
		}
	 
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		
		System.out.println(threeSum(arr));
	}

}
