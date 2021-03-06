/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 * @author Chris
 *
 */
public class ValidateBinarySearchTree {
	
    public boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        
        
        if(root.val >= max || root.val <= min) {
            return false;
        }
        
        return isValidBST(root.left, root.val, min) 
                    && isValidBST(root.right, max, root.val);
    }
    
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }    
        
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
