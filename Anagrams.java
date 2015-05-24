import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * For example:
 * 
 * Input:　　["tea","and","ate","eat","den"]
 * 
 * Output: ["tea","ate","eat"]
 * 
 * @author Chris
 * 
 */
public class Anagrams {
	
    public static String sortString(String str) {
        if(str == null || str.length() <=1) {
            return str;
        }
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    public static List<String> anagrams(String[] strs) {
         List<String> lists = new ArrayList<String>();
         if (strs == null || strs.length <= 1) {
             return lists;
         }
         
         Map<String, Integer> map = new HashMap<String, Integer>();
         for (int i = 0; i < strs.length; i++) {
        	 String sortedStr = sortString(strs[i]);
        	 if (!map.containsKey(sortedStr)) {
        		 map.put(sortedStr, i);
        	 } else {
        		 // -1 means the value has already putted in lists,
        		 // no need to add anymore
        		 if (map.get(sortedStr) != -1) {
        			 lists.add(strs[map.get(sortedStr)]);
        			 map.put(sortedStr, -1);
        		 }
        		 lists.add(strs[i]);
        	 }
         }
         
         return lists;
         
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"tea","and","ate","eat","den"};
		System.out.println(anagrams(strs));

	}

}
