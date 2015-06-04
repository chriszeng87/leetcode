/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
 * @author Chris
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
	
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode leftEnd = root;
        while (leftEnd != null) {
            TreeLinkNode cur = leftEnd;
            while(cur != null) {
                if(cur.left != null) {
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        TreeLinkNode next = cur.next;
                        while(next != null) {
                            if(next.left != null) {
                                cur.left.next = next.left;
                                break;
                            } else if (next.right != null) {
                                cur.left.next = next.right;
                                break;
                            }
                            next = next.next;
                        }
                    }
                }
                
                if(cur.right != null) {
                    TreeLinkNode next = cur.next;
                    while(next != null) {
                        if(next.left != null) {
                            cur.right.next = next.left;
                            break;
                        } else if (next.right != null) {
                            cur.right.next = next.right;
                            break;
                        }
                        next = next.next;
                    }
                }
                cur = cur.next;
            }
            
            TreeLinkNode nextLevelFirstParent = leftEnd;
            while (nextLevelFirstParent != null && nextLevelFirstParent.left == null && nextLevelFirstParent.right == null) {
                nextLevelFirstParent = nextLevelFirstParent.next;
            }
            
            if (nextLevelFirstParent == null) {
                break;
            } else if (nextLevelFirstParent.left != null) {
                leftEnd = nextLevelFirstParent.left;
            } else if (nextLevelFirstParent.right != null) {
                leftEnd = nextLevelFirstParent.right;
            }
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
