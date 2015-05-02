import java.util.Stack;


public class BSTIterator {
	
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        TreeNode curNode = root;
        stack = new Stack<TreeNode>();
        while(curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = stack.pop();
        if(nextNode.right != null) {
            TreeNode curNode = nextNode.right;
            while(curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
        }
        return nextNode.val;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.right = right;
		
		  BSTIterator i = new BSTIterator(root);
		  while (i.hasNext()) {
			  System.out.println(i.next());
		  }

	}

}
