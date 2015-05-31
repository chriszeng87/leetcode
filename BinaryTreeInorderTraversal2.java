import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
*/

public class BinaryTreeInorderTraversal2 {
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                while(p != null) {
                    stack.push(p);
                    p = p.left;
                }
            } else {
                TreeNode t = stack.pop();
                list.add(t.val);
                if(t.right != null) {
                    p = t.right;
                }
            }
        }
        
        return list;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
