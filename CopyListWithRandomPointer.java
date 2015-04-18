import java.util.ArrayList;
import java.util.List;

/**
 * A linked list is given such that each node contains an additional random pointer which could point 
 * 
 * to any node in the list or null.

 * Return a deep copy of the list.
 * 
 * @author Chris
 *
 */

/**
 * Definition for singly-linked list with a random pointer. */
  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };


public class CopyListWithRandomPointer {
	
	public static int getRandomIndex(RandomListNode random, RandomListNode head) {
		int index = -1;
		if (random == null) {
			return index;
		}
		RandomListNode p = head;
		index = 0;
		while (p != random && p != null) {
			p = p.next;
			index++;
		}
		if (p == random) {
			return index;
		} else {
			return -1;
		}
	}
	
    public static RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode newHead = null;
        if (head == null) {
        	return null;
        } else if (head.next == null) {
        	newHead = new RandomListNode(head.label);
        	if (head.random == head) {
        	    newHead.random = newHead;
        	}
        	return newHead;
        }
        
        RandomListNode p = head;
        int num = 0;
        List<Integer> indexOfRandom = new ArrayList<Integer>();
        while (p != null) {
        	num++;
        	indexOfRandom.add(getRandomIndex(p.random, head));
        	p = p.next;
        }
        RandomListNode[] newNodes = new RandomListNode[num];
        p = head;
        int i = 0;
        while(p != null) {
        	newNodes[i] = new RandomListNode(p.label); 
        	p = p.next;
        	i++;
        }
        p = head;
        i = 0;
        while(p != null) {
        	int indexOfRandomNode = indexOfRandom.get(i);
        	if (indexOfRandomNode != -1) {
        		newNodes[i].random = newNodes[indexOfRandomNode];
        	}
        	p = p.next;
        	if (p != null) {
        		newNodes[i].next = newNodes[i + 1];
        	}
        	i++;
        }
        
        newHead = newNodes[0];
        return newHead;
    }
    
    public static void printRandomList(RandomListNode head) {
    	RandomListNode p = head;
    	System.out.print("------The list is: ");
    	while(p != null) {
    		System.out.print(p.label + " ");
    		if (p.random != null) {
    			System.out.print("[" + p.random.label + "]" + "   ");
    		}
    		p = p.next;
    	}
    	System.out.println();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomListNode[] lists = new RandomListNode[5];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new RandomListNode(i);
		}
		for (int i = 0; i < lists.length - 1; i++) {
			lists[i].next = lists[i + 1];
		}
		lists[0].random = lists[3];
		lists[2].random = lists[4];
		lists[3].random = lists[0];
		lists[4].random = lists[2];
		
		printRandomList(lists[0]);
		RandomListNode newHeader = copyRandomList(lists[0]);
		printRandomList(newHeader);

	}

}
