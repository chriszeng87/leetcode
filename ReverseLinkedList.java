/**
 * Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

 * @author Chris
 *
 */
public class ReverseLinkedList {
	
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = head.next;
        head.next = null;
        while(p != null) {
            ListNode q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        
        return head;
    }
    
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = head.next;
        ListNode reverseNext = reverseList2(p);
        p.next = head;
        head.next = null;
        
        return reverseNext;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		ListNode newHead = reverseList2(node1);
		Utils.printNode(newHead);
	}

}
