import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author Chris
 * 
 */
public class SubstringWithConcatenationOfAllWords {
	
	// leetcode's checking algorithm is wrong?   
	// 
	// Input:	"a", ["a","a"]
	//		Output:	[0]
	//		Expected:	[]
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }
        
        Set<String> set = new HashSet<String>();
        for (String str : words) {
            set.add(str);
        }
        
        int i = 0;
        int sublen = words[0].length();
        int lastIn = -1;
        while(i + sublen <= s.length()) {
            int j = i + sublen;
            if(set.contains(s.substring(i, j))) {
	            if(lastIn != i) {
	                list.add(i);
	            }
	            lastIn = j;
	            i = j;
	            continue;           	
            }
            i++;
        }   
        return list;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"lingmindraboofooowingdingbarrwingmonkeypoundcake", ["fooo","barr","wing","ding","wing"]
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		List<Integer> list = findSubstring(s, words);		
		System.out.println("----list = " + list);
		
		String s2 = "bar";
		String[] words2 = {"bar","aa"};
		list = findSubstring(s2, words2);
		System.out.println("----list = " + list);
	}

}
