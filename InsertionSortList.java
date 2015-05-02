/**
 * Sort a linked list using insertion sort.
 * 
 * @author Chris
 *
 */
public class InsertionSortList {
	
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;
        ListNode p = head.next;
        head.next = null;
        while(p != null) {
            int val = p.val;
            ListNode realNext = p.next;
            ListNode q = fakeHead;
            if (val < fakeHead.next.val) {
            	p.next = fakeHead.next;
            	fakeHead.next = p;
            } else {
            
	            while(q.next != null && q.next.val <= val) {
	                q = q.next;
	            }
	            
	            if(q != p) {
	                p.next = q.next;
	                q.next = p;
	            }
            }
            
            p = realNext;
        }
        
        return fakeHead.next;
        
    }
    
    public static void printNode(ListNode head) {
    	if(head == null) {
    		return;
    	}
    	
    	ListNode p = head;
    	System.out.print("-----node = ");
    	while(p != null) {
    		System.out.print("   " + p.val);
    		p = p.next;
    	}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		ListNode next = new ListNode(1);
		head.next = next;
		ListNode newHead = insertionSortList(head);
		printNode(newHead);
	}

}
