import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters. For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *  For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Chris
 *
 */
public class LongestSubstringWithoutRepeatingChar {
	
    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while(exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        
        return maxLen;
    }
    
    public static int lengthOfLongestSubstring2(String s) {
    	int[] charMap = new int[256];
    	Arrays.fill(charMap, -1);
    	int i = 0, maxLen = 0;
    	for (int j = 0; j < s.length(); j++) {
    		if(charMap[s.charAt(j)] >= i) {
    			i = charMap[s.charAt(j)] + 1;
    		}
    		
    		charMap[s.charAt(j)] = j;
    		if(j - i + 1 > maxLen) {
    			maxLen = j - i + 1;
    		}
    	}
    	
    	return maxLen;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("abcdcedf");
		System.out.println(lengthOfLongestSubstring(str));
		System.out.println(lengthOfLongestSubstring2(str));
		
		String str2 = new String("bbbbb");
		System.out.println(lengthOfLongestSubstring(str2));
		System.out.println(lengthOfLongestSubstring2(str2));
		
		String str3 = new String("bbbbbc");
		System.out.println(lengthOfLongestSubstring(str3));
		System.out.println(lengthOfLongestSubstring2(str3));

	}

}
