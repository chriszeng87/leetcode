/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author Chris
 * 
 */
public class MergeTwoSortedLists2 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		ListNode fakeHead = new ListNode(0);

		ListNode t = fakeHead;
		ListNode p = l1;
		ListNode q = l2;
		while (p != null && q != null) {
			if (p.val < q.val) {
				t.next = p;
				p = p.next;
			} else {
				t.next = q;
				q = q.next;
			}
			t = t.next;
		}

		if (p != null) {
			t.next = p;
		} else if (q != null) {
			t.next = q;
		}

		return fakeHead.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
