import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author Chris
 * 
 */
public class MergeKSortedLists2 {
	
    public ListNode mergeKLists(ListNode[] lists) {
     	if(lists == null || lists.length == 0) {
    		return null;
    	}
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return 1;
				} else if (o1.val < o2.val) {
					return -1;
				} else {
					return 0;
				}
			}
    		
    	});
    	for (ListNode node: lists) {
    		if(node != null) {
    			queue.add(node);
    		}
    	}
    	
    	ListNode fakeHead = new ListNode(0);
    	ListNode p = fakeHead;
    	while(!queue.isEmpty()) {
    		ListNode newNode = queue.poll();
    		p.next = newNode;
    		p = p.next;
    		if(newNode.next != null) {
    			queue.add(newNode.next);
    		}
    	}
    	p.next = null;
        return fakeHead.next;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
