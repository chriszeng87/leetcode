import java.util.HashSet;

/**
 * Given a string, find the longest substring that contains only two unique characters. 
 * For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique 
 * character is "bcbbbbcccb".
 * @author Chris
 *
 */
public class LongestSubstringContains2UniChar {
	
//	String getLongestSubstringContains2UniChar(String str) {
//		if (str == null || str.length() < 2) {
//			return null;
//		}
//		StringBuilder retStr = new StringBuilder();
//		int tmpLongestStart = 0;
//		int tmpLongestEnd = -1;
//		int tmpLongestSum = 2;
//
//		int maxLongestStart = 0;
//		int maxLongestSum = 2;
//		char c1 = str.charAt(0);
//		char c2 = str.charAt(1);
//		int tmpLongestSum2 = 1; // c2出现的次数
//		int i = 2;
//		if (c1 == c2) {
//			while(i < str.length() && str.charAt(i) == c1) {
//				i++;
//				tmpLongestSum++;
//			}
//			if (i < str.length()) {
//				tmpLongestSum++;
//				tmpLongestEnd = i;
//				c2 = str.charAt(i);
//			} else {
//				return null;
//			}
//		}
//		
//		while ( i < str.length()) {
//			if (str.charAt(i) == c1) {
//				char tmp = c1;
//				c1 = c2;
//				c2 = tmp;
//				tmpLongestSum++;
//				tmpLongestSum2 = 1;
//			} else if(str.charAt(i) == c2) {
//				tmpLongestSum2++;
//				tmpLongestSum++;
//			} else {
//				if (tmpLongestSum > maxLongestSum) {
//					maxLongestSum = tmpLongestSum;
//					maxLongestStart = tmpLongestStart;
//					tmpLongestStart = i - tmpLongestSum2;
//					tmpLongestSum = 1;
//				} else {
//					c1 = c2;
//					c2 = str.charAt(i);
//				}
//			}
//		}
//
//		
//		return retStr.toString();
//	}
	
	public static String subString(String s) {
		// checking
	 
		char[] arr = s.toCharArray();
		int max = 0;
		int j = 0;
		int m = 0, n = 0;
	 
		HashSet<Character> set = new HashSet<Character>();
		set.add(arr[0]);
	 
		for (int i = 1; i < arr.length; i++) {
			if (set.add(arr[i])) {
				if (set.size() > 2) {
					String str = s.substring(j, i);
	 
					//keep the last character only
					set.clear();
					set.add(arr[i - 1]);
	 
					if ((i - j) > max) {
						m = j;
						n = i - 1;
						max = i - j;
					}
	 
					j = i - helper(str);
				}
			}
		}
	 
		return s.substring(m, n + 1);
	}
	 
	// This method returns the length that contains only one character from right side. 
	public static int helper(String str) {
		// null & illegal checking here
		if(str == null){
			return 0;
		}
	 
		if(str.length() == 1){
			return 1;
		}
	 
		char[] arr = str.toCharArray();
		char p = arr[arr.length - 1];
		int result = 1;
	 
		for (int i = arr.length - 2; i >= 0; i--) {
			if (p == arr[i]) {
				result++;
			} else {
				break;
			}
		}
	 
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("abcbbbbcccbdddadacb");
		System.out.println("-----------" + subString(str));

	}

}
