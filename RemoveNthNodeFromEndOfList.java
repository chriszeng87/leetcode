/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author Chris
 * 
 */
public class RemoveNthNodeFromEndOfList {
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        
        ListNode p = head;
        int i = 0;
        while(p != null && i < n) {
            p = p.next;
            i++;
        }
        
        if(p == null) {
        	head = head.next;
            return head;
        }
        
        ListNode q = head;
        ListNode pre = null;
        while(p != null) {
            p = p.next;
            pre = q;
            q = q.next;
        }
        if (q.next != null) {
        	q.val = q.next.val;
        	q.next = q.next.next;
        } else {
        	if(pre != null) {
        		pre.next = null;
        	}
        }
        return head;
    }
    
    public static void printNodes(ListNode p) {
    	if (p == null) {
    		return;
    	}
    	
    	System.out.print("------nodes: ");
    	while(p != null) {
    		System.out.print("  " + p.val);
    		p = p.next;
    	}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1->2->3->4->5, and n = 2.
		ListNode[] nodes = new ListNode[5];
		int i;
		for (i = 0; i < 2; i++) {
			nodes[i] = new ListNode(i + 1);
		}
		for(i = 0; i < 1; i++) {
			nodes[i].next = nodes[i + 1];
		}
		
		ListNode newHead = removeNthFromEnd(nodes[0], 1);
		printNodes(newHead);
	}

}
