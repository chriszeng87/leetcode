/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

 * @author Chris
 *
 */
public class RemoveLinkedListElements {
	
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        
        ListNode fakeHead = new ListNode(0);
        ListNode q = fakeHead;
        ListNode p = head;
        while (p != null) {
            if(p.val != val) {
                q.next = p;
                q = q.next;
            }
            p = p.next;
        }
        q.next = null;
        
        return fakeHead.next;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
