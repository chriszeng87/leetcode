import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

 * @author Chris
 *
 */

/**
  Definition for binary tree */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 
public class BinaryTreePreorderTraversal {
	
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<Integer>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {
        	// loop start with p, not a element from stack(if start from stack, there maybe duplicates)
            while(p != null) {
            	lists.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            
            p = p.right;
        }
        
        return lists;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t2.right = t3;
		t2.left = t4;
		
		System.out.println(preorderTraversal(t1));

	}

}
