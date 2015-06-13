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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
