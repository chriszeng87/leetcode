/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author Chris
 * 
 */
public class RotateList {
	
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        
        int len = 0;
        ListNode t = head;
        while (t != null) {
        	t = t.next;
        	len++;
        }
        k = k % len;
        if (k == 0) {
        	return head;
        }
        
        ListNode p = head;
        ListNode q = p;
        int i = 0;
        while (q != null && i < k) {
            q = q.next;
            i++;
        }
        
        if(q == null && i < k) {
            return head;
        }
        
        if (q != null) {
	        while (q.next != null) {
	            p = p.next;
	            q = q.next;
	        }
        }
        //p.next is the new head
        //p is the new tail
        //now q is the tail
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = p.next;
        p.next = null;
        if (q != null) {
        	q.next = head;
        }
        
        return fakeHead.next;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ListNode node = new ListNode(1);
//		ListNode ret = rotateRight(node, 1);
//		Utils.printNode(ret);
		
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode ret = rotateRight(node2, 2);
		Utils.printNode(ret);
	}

}
