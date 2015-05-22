/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author Chris
 * 
 */
public class ReverseNodesInKGroup {

	public static ListNode reverseNode(ListNode node1, ListNode node2) {
		ListNode fakeHead = new ListNode(0);
		ListNode p = node1;
		while (p != node2) {
			ListNode q = p.next;
			p.next = fakeHead.next;
			fakeHead.next = p;
			p = q;
		}
		node1.next = node2;
		return fakeHead.next;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		int len = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			len++;
		}

		if (len < k) {
			return head;
		}

		int i = 0;
		int remain = len;
		p = head;
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		while (remain >= k) {
			ListNode left = p;
			ListNode newPre = p;
			i = 0;
			while (i < k) {
//				newPre = p;
				p = p.next;
				i++;
			}
			ListNode right = p;
			pre.next = reverseNode(left, right);
			pre = newPre;
			p = right;
			remain = remain - k;
		}

		return fakeHead.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode[] nodes = new ListNode[5];
		int i;
		for (i = 0; i < nodes.length; i++) {
			nodes[i] = new ListNode(i + 1);
		}
		for (i = 0; i < nodes.length - 1; i++) {
			nodes[i].next = nodes[i + 1];
		}
		
		
		ListNode newHead = reverseKGroup(nodes[0],3);
//		ListNode newHead = reverseNode(nodes[0], nodes[2]);
		Utils.printNode(newHead);
		
	}

}
