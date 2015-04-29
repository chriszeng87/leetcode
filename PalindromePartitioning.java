import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.

* Return all possible palindrome partitioning of s.

* For example, given s = "aab",
* Return
*
*  [
*    ["aa","b"],
*    ["a","a","b"]
*  ]
 * @author Chris
 *
 */
public class PalindromePartitioning {
	
//	public static ArrayList<ArrayList<String>> partition(String s) {
//		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//	 
//		if (s == null || s.length() == 0) {
//			return result;
//		}
//	 
//		ArrayList<String> partition = new ArrayList<String>();
//		addPalindrome(s, 0, partition, result);
//	 
//		return result;
//	}
//	 
//	private static void addPalindrome(String s, int start, ArrayList<String> partition,
//			ArrayList<ArrayList<String>> result) {
//		//stop condition
//		if (start == s.length()) {
//			ArrayList<String> temp = new ArrayList<String>(partition);
//			result.add(temp);
//			return;
//		}
//	 
//		for (int i = start + 1; i <= s.length(); i++) {
//			String str = s.substring(start, i);
//			if (isPalindrome(str)) {
//				partition.add(str);
//				addPalindrome(s, i, partition, result);
//				partition.remove(partition.size() - 1);
//			}
//		}
//	}
//	 
//	private static boolean isPalindrome(String str) {
//		int left = 0;
//		int right = str.length() - 1;
//	 
//		while (left < right) {
//			if (str.charAt(left) != str.charAt(right)) {
//				return false;
//			}
//	 
//			left++;
//			right--;
//		}
//	 
//		return true;
//	}
	
    public static boolean isPalidrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public static void partition(String s, List<List<String>> result, List<String> tempList) {
        if (s == null || s.length() == 0) {
        	ArrayList<String> newTempList = new ArrayList<String>(tempList);
            result.add(newTempList);
            return;
        }
        
        String temp;
        for (int i = 1; i <= s.length(); i++) {
            temp = s.substring(0, i); 
            if(isPalidrome(temp)) {
                tempList.add(temp);
                partition(s.substring(i), result, tempList);
                tempList.remove(temp);
            }
            
            
        }
    }
    
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> tempList = new ArrayList<String>();
        partition(s, result, tempList);
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(partition("aab"));

	}

}
