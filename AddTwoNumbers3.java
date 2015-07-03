/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author Chris
 * 
 */
public class AddTwoNumbers3 {
	
	   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           if(l1 == null) {
               return l2;
           } else if(l2 == null) {
               return l1;
           }
           
           ListNode p = l1;
           ListNode q = l2;
           ListNode fakeHead = new ListNode(0);
           ListNode t = fakeHead;
           int carry = 0;
           while (p != null && q != null) {
               int tempResult = p.val + q.val + carry;
               ListNode newNode = new ListNode(tempResult % 10);
               t.next = newNode;
               t = t.next;
               if (tempResult >= 10) {
                   carry = 1;
               } else {
                   carry = 0;
               }
               
               p = p.next;
               q = q.next;
           }
           
           while (p != null) {
               int tempResult2 = p.val + carry;
               ListNode remainNode = new ListNode(tempResult2 % 10);
               t.next = remainNode;
               if (tempResult2 >= 10) {
                   carry = 1;
               } else {
                   carry = 0;
               }
               t = t.next;
               p = p.next;
           }
           
           while (q != null) {
               int tempResult3 = q.val + carry;
               ListNode remainNode2 = new ListNode(tempResult3 % 10);
               t.next = remainNode2;
               if (tempResult3 >= 10) {
                   carry = 1;
               } else {
                   carry = 0;
               }
               t = t.next;
               q = q.next;
           }
           
           if (carry == 1) {
               t.next = new ListNode(1);
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
