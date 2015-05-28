
public class ReverseList {
	
	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while( head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		return prev;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] lists = new ListNode[5];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new ListNode(i);
			if ( i > 0) {
				lists[i - 1].next = lists[i];
			}
		}
		
		Utils.printNode(lists[0]);
		
		ListNode newHead = reverse(lists[0]);
		Utils.printNode(newHead);
		
	}

}
