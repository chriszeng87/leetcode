/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric 
 * characters and ignoring cases.

 * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
 * 
 * @author Chris
 *
 */
public class ValidPalindrome {
	
	static boolean isPanlindrome(String s) {
		if (s == null) {
			return false;
		}
		
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
	static String getSmallString(String s) {
		if (s == null) {
			return null;
		}
		
		s = s.toLowerCase();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'z' <= 0) {
				result.append(s.charAt(i));
			}
		}
		return result.toString();
	}
	
	static boolean isValidPalindrome(String str) {
		String small = getSmallString(str);
		return isPanlindrome(small);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValidPalindrome("Red rum, sir, is murder"));
		System.out.println(isValidPalindrome("Programcreek is awesome"));		
		System.out.println(isValidPalindrome("P"));	
		System.out.println(isValidPalindrome("Pt"));	
	}

}
