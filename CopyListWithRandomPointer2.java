import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 * @author Chris
 *
 */
public class CopyListWithRandomPointer2 {
	
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        
        RandomListNode newHead = new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, newHead);
        RandomListNode p = head;
        while (p != null) {
            if(p.next != null) {
                if (map.get(p.next) == null) { 
                    RandomListNode next = new RandomListNode(p.next.label);
                    map.put(p.next, next);
                    map.get(p).next = next;
                } else {
                    map.get(p).next = map.get(p.next);
                }
            }
            
            if(p.random != null) {
                if (map.get(p.random) == null) {
                    RandomListNode random = new RandomListNode(p.random.label);
                    map.put(p.random, random);
                    map.get(p).random = random;
                } else {
                    map.get(p).random = map.get(p.random);
                }
            }
            
            p = p.next;
        }
        
        return newHead;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
