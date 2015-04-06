/**
 * Given a string, find the length of the longest substring without repeating characters. For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *  For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Chris
 *
 */
public class LongestSubstringWithoutRepeatingChar {
	
	static String getLongestSubstringWithoutRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder retStr = new StringBuilder();
		boolean[] charArray = new boolean[26];
		for (int i = 0; i < 26; i++) {
			charArray[i] = false;
		}
		
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i) - 'a';
			if (charArray[value] == false) {
				charArray[value] = true;
				retStr.append(str.charAt(i));
			}
		}
		
		return retStr.toString();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("abcabcbb");
		System.out.println(getLongestSubstringWithoutRepeatingChar(str));
		
		String str2 = new String("bbbbb");
		System.out.println(getLongestSubstringWithoutRepeatingChar(str2));

	}

}
