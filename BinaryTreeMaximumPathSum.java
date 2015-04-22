/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

There maybe negative numbers.


 * @author Chris
 *
 */
public class BinaryTreeMaximumPathSum {
	
		//store max value
		int max; 
	 
		public int maxPathSum(TreeNode root) {
			max = (root == null) ? 0 : root.val;
			findMax(root);
			return max;
		}
	 
		public int findMax(TreeNode node) {
			if (node == null)
				return 0;
	        
	        int left = Math.max(findMax(node.left), 0);
	        int right = Math.max(findMax(node.right), 0);
	        if(node.val + left + right > max) {
	            max = node.val + left + right;
	        }
	        
	        return Math.max(left + node.val, right + node.val);

		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
