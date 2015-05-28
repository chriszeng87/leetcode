import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

 * @author Chris
 *
 */
public class RemoveDuplicatesFromSortedListII {
	
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode p = head;
        while(p != null) {
            if(map.containsKey(p.val)) {
                int count = map.get(p.val);
                map.put(p.val, count + 1);
            } else {
                map.put(p.val, 1);
            }
            p = p.next;
        }
        
        ListNode fakeHead = new ListNode(0);
        ListNode q = fakeHead;
        p = head;
        while (p != null) {
            if(map.get(p.val) <= 1) {
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
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		ListNode newHead = deleteDuplicates(node1);
		Utils.printNode(newHead);
	}

}
