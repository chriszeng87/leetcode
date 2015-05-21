/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author Chris
 * 
 */
public class SwapNodesinPairs {
	
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode fakeHead = new ListNode(0);
        ListNode fakePre = fakeHead;
        
        ListNode q = head;
        ListNode p = head.next;
        ListNode newNext = head.next.next;
        
        while(true) {
            fakePre.next = p;
            p.next = q;
            fakePre = q;
            if(newNext == null) {
                q.next = null;
                break;
            }
            
            q = newNext;
            if(q != null) {
                p = q.next;
                if (p != null) {
                    newNext = p.next;
                } else {
                    fakePre.next = q;
                    break;
                }
            }
        }
        
        return fakeHead.next;
        
        
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
		
		ListNode[] nodes = new ListNode[5];
		int i;
		for (i = 0; i < 5; i++) {
			nodes[i] = new ListNode(i + 1);
		}
		for(i = 0; i < 4; i++) {
			nodes[i].next = nodes[i + 1];
		}
		
		printNodes(nodes[0]);
		
		ListNode p = swapPairs(nodes[0]);
		printNodes(p);
	}

}
