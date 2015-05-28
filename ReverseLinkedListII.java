/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

 * @author Chris
 *
 */
public class ReverseLinkedListII {
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode rHead = head;
        ListNode rPrev = null;
        int i = 1;
        while (i < m) {
            i++;
            rPrev = rHead;
            rHead = rHead.next;
        }
        
        ListNode rTail = rHead;
        while (i < n) {
            i++;
            rTail = rTail.next;
        }
        ListNode remain = rTail.next;
        
        ListNode p = rHead.next;
        rHead.next = remain;
        while(p != remain) {
            ListNode q = p.next;
            p.next = rHead;
            if (rPrev != null) {
            	rPrev.next = p;
            } else {
            	head = p;
            }
            rHead = p;
            
            p = q;
        }
        
        return head;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] lists = new ListNode[5];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new ListNode(i + 1);
			if ( i > 0) {
				lists[i - 1].next = lists[i];
			}
		}
		
		Utils.printNode(lists[0]);
		
		ListNode newHead = reverseBetween(lists[0], 2, 5);
		Utils.printNode(newHead);
		
		ListNode[] lists2 = new ListNode[5];
		lists2[0] = new ListNode(3);
		lists2[1] = new ListNode(5);
		lists2[0].next = lists2[1];
		
		Utils.printNode(lists2[0]);
		
		ListNode newHead2 = reverseBetween(lists2[0], 1, 2);
		Utils.printNode(newHead2);
	}

}
