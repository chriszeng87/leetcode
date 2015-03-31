import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

*  The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author Chris
 *
 */
public class ValidParenthese {
	
	static boolean isInputValid(String input) {
		
		if (input == null || input.equals("")) {
			return false;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("(", ")");
		map.put("{", "}");
		map.put("[", "]");
		
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < input.length(); i++) {
			String sub = input.substring(i, i + 1);
			if (map.keySet().contains(sub)) { 
				stack.push(sub);
			} else if (map.values().contains(sub)) {
				String key = stack.pop();
				if (!map.get(key).equals(sub)) {
					return false;
				}
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("() valid: " + isInputValid("()"));
		System.out.println("()[]{} valid: " + isInputValid("()[]{}"));
		System.out.println("(] valid: " + isInputValid("(]"));
		System.out.println("([)] valid: " + isInputValid("([)]"));
		System.out.println("([] valid: " + isInputValid("([]"));

	}

}
