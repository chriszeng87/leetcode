import java.util.ArrayList;
import java.util.List;

/**
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

 * @author Chris
 *
 */
public class ReverseWordsInAString2 {
	
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = new String(sb);
        
        List<String> list = new ArrayList<String>();
        char last = s.charAt(0);
        String sb1 = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
        	if (last == ' ' && s.charAt(i) == ' ') {
        		sb1 += " ";
        	} else if (last == ' ' && s.charAt(i) != ' ') {
        		list.add(sb1);
        		sb1 = s.substring(i , i + 1);
        	} else if (last != ' ' && s.charAt(i) == ' ') {
        		list.add(sb1);
        		sb1 = new String(" ");
        	} else {
        		sb1 = s.substring(i , i + 1);
        	}
        	last = s.charAt(i);
        }
        list.add(sb1);
        
        StringBuilder ret = new StringBuilder();
        for (String temp: list) {
        	ret.append(new StringBuilder(temp).reverse());
        }
        
        return ret.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ret = reverseWords(" ");
		System.out.println("----------ret = " + ret);
	}

}
