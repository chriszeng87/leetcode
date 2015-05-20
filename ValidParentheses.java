import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author Chris
 * 
 */
public class ValidParentheses {
	
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                
                char c = stack.pop();
                if(s.charAt(i) == ')') {
                    if (c != '(') {
                        return false;
                    }
                } else if(s.charAt(i) == '}') {
                    if (c != '{') {
                        return false;
                    }
                } else if(s.charAt(i) == ']') {
                    if (c != '[') {
                        return false;
                    }                    
                }
            }
        }
        
        return stack.isEmpty();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
