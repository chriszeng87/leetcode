import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * 1 2 3 4 5 6    123 654
 * 1 6 2 5 3 4
 * 
 * 1 2 3 4 5 6 7   1234 765
 * 1 7 2 6 3 5 4
 * 
 * 1 2 3 4 5 6 7 8   1234 5678
 * 1 8 2 7 3 6 4 5   
 * 
 * @author Chris
 * 
 */


public class ReorderList {
	
	public static ListNode simpleReorder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode p = head.next;
		head.next = null;
		ListNode q = p.next;
		while(p != null) {
			q = p.next;
			p.next = head;
			head = p;
			p = q;
		}
		return head;
	}

	public static ListNode getHalfNode (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		int num = 0;
		while(p != null) {
			num++;
			p = p.next;
		}
		p = head;
		int half = num / 2;
		if (num % 2 == 0) {
			half = half - 1;
		}
		while(half > 0 ) {
			half--;
			p = p.next;
		}
		ListNode realHalf = p.next;
		p.next = null;
		return realHalf;
		
	}

	public static void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		
		ListNode halfNode = getHalfNode(head);
		printNode(head);		
		printNode(halfNode);
		ListNode newHalfNode = simpleReorder(halfNode);
		printNode(newHalfNode);
	    ListNode p = head, q = newHalfNode;
	    int i = 0;
	    while(p != null && q != null) {
	    	ListNode preNext = p.next;
	    	ListNode sufNext = q.next;
	    	if (i % 2 == 0) {
	    		p.next = q;
		    	p = preNext;
	    	} else {
	    		q.next = p;
	    		q = sufNext;
	    	}
	    	i++;
	    }
	    printNode(head);
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
		
		List<ListNode> list = new ArrayList<ListNode>();
		for (int i = 1; i <= 6; i++) {
			ListNode temp = new ListNode(i);
			list.add(temp);
		}
		for (int i = 0; i < 5; i++) {
			list.get(i).next = list.get(i + 1);
		}
		ListNode node = list.get(0);
		reorderList(node);
		printNode(node);

		

	}

}
