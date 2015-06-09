import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

 * @author Chris
 *
 */
public class WordBreak {
	
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        } else if (wordDict == null) {
            return false;
        }
        
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!t[i]) {
                continue;
            }
            
            for(String word: wordDict) {
                int len = word.length();
                int end = i + len;
                if (i + len > s.length()) {
                    continue;
                }
                if (t[end]) {
                    continue;
                }
                if (s.substring(i, i + len).equals(word)) {
                    t[end] = true;
                }
            }
        }
        
        return t[s.length()];
    }
    
    public boolean wordBreak2(String s, Set<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }
        
        if (s.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (t[j] && wordDict.contains(s.substring(j,i))) {
                    t[i] = true;
                    break;
                }
            }
        }
        
        return t[s.length()];
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
