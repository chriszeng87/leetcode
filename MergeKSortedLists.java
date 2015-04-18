import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author Chris
 *
 */
public class MergeKSortedLists {
	
	public int checkFirstIndexValid(ListNode[] indexs) {
		if(indexs == null) {
			return -1;
		}
		for (int i = 0; i < indexs.length; i++) {
			if(indexs[i] != null) {
				return i;
			}
		}
		return -1;
	}
	
	public int getMinNode(ListNode[] indexs, int firstValid) {
		int  minNode = firstValid;
		for (int i = firstValid + 1; i < indexs.length; i++) {
			if(indexs[i] != null && indexs[i].val < indexs[minNode].val) {
				minNode = i;
			}
		}
		return minNode;
	}
	
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
        	return null;
        }
        
        ListNode fakeHeader = new ListNode(0);
        ListNode p = fakeHeader;
        
        ListNode[] indexs = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
        	indexs[i] = lists.get(i);
        }
        
        int firstValid;
        while((firstValid = checkFirstIndexValid(indexs)) != -1) {
        	int min = getMinNode(indexs, firstValid);
        	p.next = indexs[min];
        	indexs[min] = indexs[min].next;
        	p = p.next;
        }
        
        return fakeHeader.next;
        
    }
    
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
		if (lists.size() == 0)
			return null;
 
		//PriorityQueue is a sorted queue
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if(a.val == b.val)
							return 0;
						else 
							return -1;
					}
				});
 
		//add first node of each list to the queue
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);
		}
 
		ListNode head = new ListNode(0);
		ListNode p = head; // serve as a pointer/cursor
 
		while (q.size() > 0) {
			ListNode temp = q.poll();
			//poll() retrieves and removes the head of the queue - q. 
			p.next = temp;
 
			//keep adding next element of each list
			if (temp.next != null)
				q.add(temp.next);
 
			p = p.next;
		}
 
		return head.next;
	}
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
