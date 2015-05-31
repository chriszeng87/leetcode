import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 * @author Chris
 *
 */
public class RecoverBinarySearchTree {
	
    public static void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        
        TreeNode firstWrong = null;
        TreeNode secondWrong = null;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode q = stack.pop();
                if(pre != null) {
                    if(pre.val > q.val) {
                        if (firstWrong == null) {
                        	firstWrong = pre;
                        }
                        secondWrong = q;
                    }
                }
                pre = q;
                p = q.right;
            }
        }
        
        int temp = firstWrong.val;
        firstWrong.val = secondWrong.val;
        secondWrong.val = temp;

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		root.left = left;
		
		recoverTree(root);
	}

}
