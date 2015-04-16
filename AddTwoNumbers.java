import java.math.BigInteger;

/**
 * The problem:

You are given two linked lists representing two non-negative numbers. The digits are stored in 
reverse order and each of their nodes contain a single digit. Add the two numbers and return it 
as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

342 + 465 = 807

 * @author Chris
 *
 */

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class AddTwoNumbers {
	
	   public static BigInteger getNumOfNode(ListNode node) {
		   BigInteger sum = BigInteger.ZERO;
			if (node == null) {
				return sum;
			}
			BigInteger times = BigInteger.ONE;
			while(node != null) {
				sum = sum.add(BigInteger.valueOf(node.val).multiply(times));
				node = node.next;
				times = times.multiply(BigInteger.valueOf(10));
			}
			return sum;
	   }
	   
	   public static ListNode getNodeOfNum(BigInteger num) {
		   ListNode start = new ListNode(0);
		   if (num.equals(BigInteger.ZERO)) {
			   return start;
		   }
		   int remain = num.mod(BigInteger.TEN).intValue();
		   start.val = remain; 
		   ListNode p = start;
		   while(!num.equals(BigInteger.ZERO)) {
			   num = num.divide(BigInteger.TEN);      
			   if (!num.equals(BigInteger.ZERO)) {
				   remain = num.mod(BigInteger.TEN).intValue();    
				   ListNode q = new ListNode(remain);
				   p.next = q;
				   p = q;
			   }
		   }
		   
		   return start;
	   }
	
	   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        BigInteger totalSum = getNumOfNode(l1).add(getNumOfNode(l2));
	        return getNodeOfNum(totalSum);
	   }
	   
	   public static void printNode(ListNode node) {
		   if (node == null) {
			   return;
		   }
		   
		   System.out.print("node : ");
		   ListNode p = node;
		   while(p != null) {
			   System.out.print(" " + p.val);
			   p = p.next;
		   }
		   System.out.println();
	   }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node11 = new ListNode(2);
		ListNode node12 = new ListNode(4);
		ListNode node13 = new ListNode(3);
		node11.next = node12;
		node12.next = node13;
		
		ListNode node21 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node23 = new ListNode(4);
		node21.next = node22;
		node22.next = node23;
		
		printNode(addTwoNumbers(node11, node21));
		

	}

}
