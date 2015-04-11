import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * @author Chris
 *
 */
public class LargestNumber {
	
	static String getLargestNumber(int[] array) {
		StringBuilder str = new StringBuilder();
		if (array == null || array.length == 0) {
			return str.toString();
		}
		List<Integer> lists = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			lists.add(array[i]);
		}
		Collections.sort(lists, new Comparator<Integer>() {

			@Override
			public int compare(Integer value1, Integer value2) {
				int remain1 = value1 % 10;
				int remain2 = value2 % 10;
				while(remain1 == remain2 ) {
					if (value1 == 0 || value2 == 0) {
						return value2 - value1;
					}
					remain1 = value1 % 10;
					remain2 = value2 % 10;
					
					value1 = value1 / 10;
					value2 = value2 / 10;	
				
				}

				return remain2 - remain1;
			}
			
		});
		
		for (int i = 0; i < lists.size(); i++) {
			str.append(lists.get(i));
		}
		return str.toString();
	}
	
	public static String largestNumber(int[] num) {
	     String[] NUM = new String[num.length];
	 
	    for (int i = 0; i <num.length; i++) {
	        NUM[i] = String.valueOf(num[i]);
	    }
	 
	    java.util.Arrays.sort(NUM, new java.util.Comparator<String>() {
	        public int compare(String left, String right) {
	            String leftRight = left.concat(right);
	            String rightLeft = right.concat(left);
	            return rightLeft.compareTo(leftRight);
	        }
	    });
	 
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < NUM.length; i++) {
	        sb.append(NUM[i]);
	    }
	 
	    java.math.BigInteger result = new java.math.BigInteger(sb.toString());
	    return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3, 30, 34, 5, 9};
		System.out.println("Largest Number is " + getLargestNumber(arr));
		System.out.println("Largest Number is " + largestNumber(arr));
		
		int[] arr2 = {300, 30, 34, 5, 9};
		System.out.println("Largest Number is " + getLargestNumber(arr2));
		System.out.println("Largest Number is " + largestNumber(arr2));
		
		int[] arr3 = {300, 30, 34, 5, 9, 100};
		System.out.println("Largest Number is " + getLargestNumber(arr3));
		System.out.println("Largest Number is " + largestNumber(arr3));
	}

}
