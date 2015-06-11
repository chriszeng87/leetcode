/**
 * Sort a linked list using insertion sort.
 * @author Chris
 *
 */
public class InsertionSortList2 {
	
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode q = p.next;
            ListNode t = fakeHead;
            while(t.next != null && p.val > t.next.val) {
                t = t.next;
            }
            
            p.next = t.next;
            t.next = p;
            
            p = q;
        }
        
        return fakeHead.next;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
