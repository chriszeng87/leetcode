import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.
 * @author Chris
 *
 */
public class MinStack {
	
	Stack<Integer> mValueStack;
	Stack<Integer> mMinStack;
	
	public MinStack() {
	
		mValueStack = new Stack<Integer>();
		mMinStack = new Stack<Integer>();
	}
	
	public void push(int x) {
		mValueStack.push(x);
		if (!mMinStack.isEmpty()) {
			int currentMin = mMinStack.peek();
			mMinStack.push(Math.min(currentMin, x));
		} else {
			mMinStack.push(x);
		}
	}
	
	public int pop() {
		if (mValueStack.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			mMinStack.pop();
			return mValueStack.pop();
		}
	}
	
	public int top() {
		if (mValueStack.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			return mValueStack.peek();
		}
	}
	
	public int getMin() {
		return mMinStack.peek();
	}
	
	public int getMinStackSize() {
		return mMinStack.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(2);
		System.out.println("stack min is " + stack.getMin());
		
		stack.push(3);
		System.out.println("stack min is " + stack.getMin());
		
		stack.push(-1);
		System.out.println("stack min is " + stack.getMin());
		
		stack.push(1);
		System.out.println("stack min is " + stack.getMin());
		
		stack.push(4);
		System.out.println("stack min is " + stack.getMin());
		
		stack.push(-2);
		System.out.println("stack min is " + stack.getMin());

	}

}
