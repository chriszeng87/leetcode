import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

 * @author Chris
 *
 */

public class WordBreakII {
	
	//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	//time exceeded
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || wordDict == null) {
            return null;
        } else if (s.length() == 0 || wordDict.size() == 0) {
            return null;
        }
        
        boolean[] t = new boolean[s.length() + 1];
        // List<StringBuilder> list = new ArrayList<StringBuilder>();
        Map<Integer, List<StringBuilder>> map = new HashMap<Integer, List<StringBuilder>>(); 
        t[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            List<StringBuilder> list = new ArrayList<StringBuilder>();
            for (int j = 0; j < i; j++) {
                if(t[j] && wordDict.contains(s.substring(j, i))) {
                    if (map.containsKey(j)) {
                        List<StringBuilder> lastList = map.get(j);
                        for (StringBuilder lastSb: lastList) {
                            StringBuilder newSb = new StringBuilder(lastSb);
                            newSb.append(' ');
                            newSb.append(s.substring(j, i));
                            list.add(newSb);
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.substring(j, i));
                        list.add(sb);
                    }
                    t[i] = true;
                    continue;
                }
            }
            map.put(i, list);
        }
        
        List<String> result = new ArrayList<String>();
        if (map.containsKey(s.length())) {
            for (StringBuilder resultSb : map.get(s.length())) {
                result.add(resultSb.toString());
            }
        }
        
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<String>();
		//"cat", "cats", "and", "sand", "dog"
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		String word = "catsanddog";
		List<String> ret = wordBreak(word, wordDict);
		System.out.println("------ret = " + ret);
	}

}
