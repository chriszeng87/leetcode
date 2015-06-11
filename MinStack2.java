import java.util.Stack;
/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

 * @author Chris
 *
 */

public class MinStack2 {
	
    Stack<Integer> valueStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        if (valueStack.isEmpty()) {
            minStack.push(x);
        } else {
            int curMin = minStack.peek();
            if (x <= curMin) {
                minStack.push(x);
            }
        }
        valueStack.push(x);
    }

    public void pop() {
        if(!valueStack.isEmpty()) {
            int value = valueStack.pop();
            if(value == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (valueStack.isEmpty()) {
            return -1;
        } else {
            return valueStack.peek();
        }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        } else {
            return minStack.peek();
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
