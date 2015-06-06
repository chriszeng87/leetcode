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
		
		
		//函数返回除了左根右这种方式之外的最大值，也就是只经过左子树或者只经过
		//右子树的最大值，全局的最大值保存在max[0]中
	    public int getMaxPath(TreeNode root, int[] max) {
	        if(root == null) {
	            return 0;
	        }
	        
	        int left = getMaxPath(root.left, max);
	        int right = getMaxPath(root.right, max);
	        int cur = Math.max(root.val, Math.max(root.val + left, root.val + right));
	        max[0] = Math.max(Math.max(max[0], cur), left + right + root.val);
	        return cur;
	    }
	 
		public int maxPathSum2(TreeNode root) {
	        int[] max = new int[1];
	        max[0] = Integer.MIN_VALUE;
	        getMaxPath(root, max);
	        return max[0];
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
