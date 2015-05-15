import java.math.BigInteger;


public class AddTwoNumbers2 {
	
    private static BigInteger getNumOfNode(ListNode node) {
        BigInteger num = BigInteger.ZERO;
        if (node == null) {
            return num;
        }
        
        ListNode p = node;
        BigInteger pow = BigInteger.ONE;
        while(p != null) {
            num = num.add(pow.multiply(BigInteger.valueOf(p.val)));
            pow = pow.multiply(BigInteger.TEN);
            p = p.next;
        }
        return num;
    }
    
    private static ListNode getNodeOfNum(BigInteger num) {
        ListNode head = new ListNode(0);
        if (num.equals(BigInteger.ZERO)) {
            return head;
        }
        
        ListNode pre = head;
        BigInteger m = num.mod(BigInteger.TEN);
        while(num.compareTo(BigInteger.ZERO) > 0) {   	
            m = num.mod(BigInteger.TEN);
            ListNode newNode = new ListNode(m.intValue());
            pre.next = newNode;
            pre = newNode;
            num = num.divide(BigInteger.TEN);

        }
        return head.next;
    }

	
	   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        BigInteger totalSum = getNumOfNode(l1).add(getNumOfNode(l2));
	        return getNodeOfNum(totalSum);
	   }
	   
	   public static void printNode(ListNode node) {
		   if (node == null) {
			   return;
		   }
		   
		   System.out.print("node is :");
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
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		l11.next = l12;
		l12.next = l13;
		printNode(l11);
		
		ListNode l21 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);
		l21.next = l22;
		l22.next = l23;
		printNode(l21);
		
		ListNode node = addTwoNumbers(l11, l21);
		printNode(node);
	}

}
