import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
    
    public static List<String> wordBreak2(String s, Set<String> dict) {
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
        for(int i=0; i<s.length(); i++){
          //i是开始位置
          if( dp[i] == null ) continue; //前面的部分必须是可以匹配的
          for(String word:dict){
            int len = word.length();
            int end = i+len;
            if(end > s.length()) continue;
            if(s.substring(i,end).equals(word)){
              if(dp[end] == null){
                dp[end] = new ArrayList<String>();
              }
              dp[end].add(word);//记录上一个位置
            }
          }
        }

        List<String> ans = new LinkedList<String>();
        if(dp[s.length()] == null) return ans; 
        ArrayList<String> tmp = new ArrayList<String>();
        dfsStringList(dp,s.length(),ans, tmp);
        return ans;
      }

      public static void dfsStringList(List<String> dp[],int end,List<String> res, ArrayList<String> tmp){
        if(end <= 0){
          String ans = tmp.get(tmp.size()-1);
          for(int i=tmp.size()-2; i>=0; i--)
            ans += (" " + tmp.get(i) );
          res.add(ans);
          return;
        }
        for(String str:dp[end]){
          tmp.add(str);
          dfsStringList(dp,end-str.length(), res, tmp);
          tmp.remove(tmp.size()-1);
        }
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
		List<String> ret = wordBreak2(word, wordDict);
		System.out.println("------ret = " + ret);
		
		
//		Set<String> wordDict2 = new HashSet<String>();
//		//"a","aa","aaa","aaaa"
//		wordDict2.add("a");
//		wordDict2.add("aa");
//		wordDict2.add("aaa");
//		wordDict2.add("aaaa");
//		
//		String word2 = "aaaaaa";
//		List<String> ret2 = wordBreak(word2, wordDict2);
//		System.out.println("------ret = " + ret2);
	}

}
