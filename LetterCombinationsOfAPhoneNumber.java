import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * @author Chris
 * 
 */
public class LetterCombinationsOfAPhoneNumber {
	
    private String getString(char digit) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");       
    
        return map.get((int)(digit - '0'));
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> lists = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return lists;
        }
        
        List<String> remainList = new ArrayList<String>();
        if(digits.length() > 1) {
            remainList = letterCombinations(digits.substring(1));
        }
        
        String possible = getString(digits.charAt(0));
        for (int i = 0; i < possible.length(); i++) {
            StringBuilder str = new StringBuilder();
            str.append(possible.charAt(i));
            if (remainList.size() != 0) {
                for (String remain: remainList) {
                    String newStr = str + remain;
                    lists.add(newStr);
                }
            } else {
                lists.add(str.toString());
            }
        }
        
        return lists;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
