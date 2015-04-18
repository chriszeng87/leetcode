/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author Chris
 * 
 */
public class PartitionList {

	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode fakeSmallerHead = new ListNode(0);
		ListNode fakeBiggerHead = new ListNode(0);

		ListNode fakeSmallerNode = fakeSmallerHead;
		ListNode fakeBiggerNode = fakeBiggerHead;

		ListNode p = head;
		while (p != null) {
			if (p.val < x) {
				fakeSmallerNode.next = p;
				fakeSmallerNode = fakeSmallerNode.next;
			} else {
				fakeBiggerNode.next = p;
				fakeBiggerNode = fakeBiggerNode.next;
			}
			p = p.next;
		}
		fakeSmallerNode.next = null;
		fakeBiggerNode.next = null;
		
		printNode(fakeSmallerHead);
		printNode(fakeBiggerHead);

		fakeSmallerNode.next = fakeBiggerHead.next;
		return fakeSmallerHead.next;
	}
	
	public static void printNode(ListNode node) {
		if (node == null) {
			return;
		}

		ListNode p = node;
		System.out.print("node: ");
		while (p != null) {
			System.out.print(p.val + "  ");
			p = p.next;
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode partition = partition(node1, 2);
		printNode(partition);
	}

}
