/**
 * 
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the 

depth of the two subtrees of every node never differ by more than 1.

 * @author Chris
 *
 */
public class BalancedBinaryTree {
	
    public int getDepthOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(1 + getDepthOfTree(root.left),
                        1 + getDepthOfTree(root.right));
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        if(isBalanced(root.left) && isBalanced(root.right)) {
            if (Math.abs(getDepthOfTree(root.left) - getDepthOfTree(root.right)) <= 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
