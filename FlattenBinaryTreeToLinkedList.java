//import java.util.Stack;
//
///**
// * 
// * Definition for binary tree public class TreeNode { int val; TreeNode left;
// * TreeNode right; TreeNode(int x) { val = x; } }
// * 
// * @author Chris
// * 
// */
//
//
//
//public class FlattenBinaryTreeToLinkedList {
//
//	public void flatten(TreeNode root) {
//	        if(root == null) {
//	            return;
//	        }
//	        
//	        Stack<TreeNode> stack = new Stack<TreeNode>();
//	        stack.push(root);
//	        TreeNode pre = null;
//	        while(!stack.isEmpty()) {
//	            TreeNode p = stack.pop();
//	            if(pre == null) {
//	                pre = root;
//	            } else {
//	                pre.left = null;
//	                pre.right = p;
//	                pre = p;
//	            }
//	            if(p.right != null) {
//	                stack.push(p.right);
//	            }
//	            if(p.left != null) {
//	                stack.push(p.left);
//	            }
//	        }
//	        
//	    }
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
