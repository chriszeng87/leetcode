/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author Chris
 * 
 */
public class LongestCommonPrefix2 {
	
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ret = new StringBuilder();
        
        if(strs.length == 0) {
            return ret.toString();
        }
        
        int minLen = Integer.MAX_VALUE;
        for (String str: strs) {
            if (str == null || str.length() == 0) {
                return ret.toString();
            } else if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        
        for (int i = 0; i < minLen; i++) {
            char toCompare = strs[0].charAt(i);
            int j;
            for (j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != toCompare) {
                    break;
                }
            }
            
            if (j == strs.length) {
                ret.append(toCompare);
            } else {
                return ret.toString();
            }
        }
        
        return ret.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
