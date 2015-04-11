/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author Chris
 *
 */
public class LongestCommonPrefix {
	
	static String getLongestCommonPrefix(String[] lists) {
		StringBuilder prefix = new StringBuilder();
		if (lists == null || lists.length == 0) {
			return prefix.toString();
		} else if (lists.length == 1) {
			return lists[0];
		}
		
		int i = 0;
		while (i < lists[0].length() && i < lists[1].length()) {
			if (lists[0].charAt(i) == lists[1].charAt(i)) {
				prefix.append(lists[0].charAt(i));
				i++;
			} else {
				break;
			}
		}
		
		for (int j = 2; j < lists.length; j++) {
			i = 0;
			while(i < prefix.length() && i < lists[j].length()) {
				if (prefix.charAt(i) == lists[j].charAt(i)) {
					i++;
				} else {
					break;
				}
			}
			
			if (i == 0) {
				prefix = new StringBuilder();
			} else {
				String newPrefixStr = prefix.substring(0, i);
				prefix = new StringBuilder(newPrefixStr);
			}
		}		
		
		return prefix.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strList = {new String("abcdefg"), new String("abcde"), new String("abcdhij"), new String("abch")};
		System.out.println("Longest common prefix is " + getLongestCommonPrefix(strList));
		
		String[] strList2 = {new String("abcdefg"), new String("abcde"), new String("abcdhij"), new String("")};
		System.out.println("Longest common prefix is " + getLongestCommonPrefix(strList2));
		
		String[] strList3 = {new String("abcdefg"), new String("abcde"), new String("abcdhij"), new String("abcdef")};
		System.out.println("Longest common prefix is " + getLongestCommonPrefix(strList3));
	}

}
