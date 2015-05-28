/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

 * @author Chris
 *
 */
public class PartitionList2 {
	
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }
        
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode sp = smallHead;
        ListNode bp = bigHead;
        ListNode p = head;
        while(p != null) {
            if(p.val < x) {
                sp.next = p;
                sp = sp.next;
            } else {
                bp.next = p;
                bp = bp.next;
            }
            
            p = p.next;
        }
        
        sp.next = bigHead.next;
        bp.next = null;
        
        return smallHead.next;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
