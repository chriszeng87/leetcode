/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 * @author Chris
 *
 */
public class RemoveDuplicatesFromSortedList {
	
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = head;
        ListNode p = pre.next;
        while(p != null) {
            if(pre.val == p.val) {
                pre.next = p.next;
            } else {
                pre = p;
            }
        
            p = p.next;
        }
        
        return head;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
