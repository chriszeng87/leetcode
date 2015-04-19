/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Write a program to find the node at which the intersection of two singly linked lists begins.

 * @author Chris
 *
 */
public class IntersectionOfTwoLinkedLists {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        int lenA = 0;
        ListNode p = headA;
        while(p != null) {
            lenA++;
            p = p.next;
        }
        p = headA;
        
        int lenB = 0;
        ListNode q = headB;
        while(q != null) {
            lenB++;
            q = q.next;
        }
        q = headB;
        
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while(diff > 0) {
                p = p.next;
                diff--;
            }
        } else if(lenA < lenB) {
            int diff = lenB - lenA;
            while(diff > 0) {
                q = q.next;
                diff--;
            }
        }
        
        while(p != null && q != null) {
            if(p == q) {
                return p;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        
        return null;        
    }   


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
