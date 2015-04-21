/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author Chris
 * 
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public static TreeNode buildTree(int[] inorder, int[] postorder, int inOrderStart,
			int inOrderEnd, int postOrderStart, int postOrderEnd) {

		if (inOrderEnd < inOrderStart || postOrderEnd < postOrderStart) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postOrderEnd]);
		if (inOrderEnd == inOrderStart) {
			return root;
		}
		int inOrderRootPosition = inOrderStart;
		while (inorder[inOrderRootPosition] != root.val) {
			inOrderRootPosition++;
		}
		int leftChildLen = inOrderRootPosition - inOrderStart;
		root.left = buildTree(inorder, postorder, inOrderStart,
				inOrderRootPosition - 1, postOrderStart, postOrderStart
						+ leftChildLen - 1);
		root.right = buildTree(inorder, postorder, inOrderRootPosition + 1,
				inOrderEnd, postOrderStart + leftChildLen, postOrderEnd - 1);
		return root;
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}

		return buildTree(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inorder = {1, 3, 2};
		int[] postorder = {3, 2, 1};
		buildTree(inorder, postorder);
	}

}
