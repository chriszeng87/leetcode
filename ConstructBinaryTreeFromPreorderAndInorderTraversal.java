public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static TreeNode buildTree(int[] preorder, int[] inorder, int preLeft,
			int preRight, int inLeft, int inRight) {
		if (preLeft < 0 || preLeft >= preorder.length
				|| preRight >= preorder.length || inLeft < 0
				|| inLeft >= preorder.length || inRight >= preorder.length
				|| preLeft > preRight || inLeft > inRight) {
			return null;
		}
		int rootIndexInOrder = inLeft;
		while (rootIndexInOrder <= inRight) {
			if (inorder[rootIndexInOrder] == preorder[preLeft]) {
				break;
			}
			rootIndexInOrder++;
		}
		int leftSize = rootIndexInOrder - inLeft;

		TreeNode root = new TreeNode(preorder[preLeft]);
		root.left = buildTree(preorder, inorder, preLeft + 1, preLeft
				+ leftSize, inLeft, inLeft + leftSize - 1);
		root.right = buildTree(preorder, inorder, preLeft + leftSize + 1,
				preRight, inLeft + leftSize + 1, inRight);
		return root;
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0
				|| inorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}

		int length = preorder.length;
		TreeNode root =  buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = new TreeNode(1);
//		TreeNode left = new TreeNode(2);
//		root.left = left;
		int[] preorder = {1, 2, 4, 5 ,3, 6};
		int[] inorder = {4, 2, 5, 1, 6, 3};
		
		TreeNode root = buildTree(preorder, inorder);
		Utils.prePrintTreeNode(root);
		System.out.println();
		Utils.inPrintTreeNode(root);
	}

}
