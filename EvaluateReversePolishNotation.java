import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
 * @author Chris
 *
 */
public class EvaluateReversePolishNotation {
	
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (!(tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/"))) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.push(num1 + num2);
                } else if (tokens[i].equals("-")) {
                    stack.push(num2 - num1);
                } else if (tokens[i].equals("*")) {
                    stack.push(num1 * num2);
                } else if (tokens[i].equals("/")) {
                    stack.push(num2 / num1);
                }
            }
        }
        
        return stack.pop();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
