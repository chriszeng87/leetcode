/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * 
 *  of the first two lists.
 *  
 * @author Chris
 *
 */
public class MergeTwoSortedLists {
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode newList = new ListNode(0);
        ListNode newNode = newList;
        
        ListNode p = l1;
        ListNode q = l2;
        
        while (p != null && q != null) {
        	if(p.val <= q.val) {
        		newNode.next = p;
        		p = p.next;
        	} else {
        		newNode.next = q;
        		q = q.next;
        	}
        	newNode = newNode.next;
        }
        
        if (p != null) {
        	newNode.next = p;
        } else if (q != null) {
        	newNode.next = q;
        }
        
        return newList.next;
    }
    
    public static void printNode(ListNode head) {
    	ListNode p = head;
    	System.out.print("node: ");
    	while (p != null) {
    		System.out.print(p.val + "   ");
    		p = p.next;
    	}
    	System.out.println();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1= new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode newList = mergeTwoLists(l1, l2);
		printNode(newList);

	}

}
