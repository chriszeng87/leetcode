/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    
 * @author Chris
 *
 */
public class PopulatingNextRightPointersInEachNode {
	
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode leftEnd = root;
        while (leftEnd != null && leftEnd.left != null) {
            TreeLinkNode cur = leftEnd;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null: cur.next.left;
                
                cur = cur.next;
            }
            
            leftEnd = leftEnd.left;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode[] nodes = new TreeLinkNode[7];
		for (int i = 0; i < 7; i++) {
			nodes[i] = new TreeLinkNode(i + 1);
		}
		
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		nodes[1].left = nodes[3];
		nodes[1].right = nodes[4];
		nodes[2].left = nodes[5];
		nodes[2].right = nodes[6];
		connect(nodes[0]);
		System.out.println();
	}

}
