/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 * @author Chris
 *
 */
public class MaximumDepthOfBinaryTree {
	
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } 
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
