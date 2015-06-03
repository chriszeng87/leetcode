/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
             
 * @author Chris
 *
 */
public class FlattenBinaryTreeToLinkedList {
	
    public static TreeNode getLeftMostRight(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        TreeNode leftMostRight  = root;
        if(root.right != null) {
        	leftMostRight = getLeftMostRight(root.right);
        } else if (root.left != null){
        	leftMostRight = getLeftMostRight(root.left);
        }
        
        return leftMostRight;
    }
    
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode leftMostRight;
        if (root.left == null) {
        	leftMostRight = root;
        } else {
        	leftMostRight = getLeftMostRight(root.left);
        }
        
        flatten(root.left);
        flatten(root.right);

        leftMostRight.right = root.right;
        if (root.left != null) {
        	root.right = root.left;
        	root.left = null;
        }
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode[]  nodes = new TreeNode[6];
		for (int i = 0; i < 6; i++) {
			nodes[i] = new TreeNode(i + 1);
		}
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[4];
		nodes[1].left = nodes[2];
		nodes[1].right = nodes[3];
		nodes[4].right = nodes[5];

		flatten(nodes[0]);
		Utils.prePrintTreeNode(nodes[0]);
		System.out.println();
		Utils.inPrintTreeNode(nodes[0]);
	}

}
