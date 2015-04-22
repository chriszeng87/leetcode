/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author Chris
 *
 */
public class ConvertSortedListToBinarySearchTree {
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        
        ListNode midNode = head;
        int mid = len/2;
        while(midNode != null && mid > 1) {
            midNode = midNode.next;
            mid--;
        }
        
        ListNode rootNode = midNode.next;
        TreeNode root = new TreeNode(rootNode.val);
        ListNode rightNode = rootNode.next;
        midNode.next = null;
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightNode);
        
        return root;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
