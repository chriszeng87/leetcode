import java.util.Stack;


//----------WRONG!!
public class BSTIterator {
	
    private TreeNode curNode;
    private Stack<TreeNode> parentList;

    public BSTIterator(TreeNode root) {
        curNode = root;
        parentList = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (curNode == null) {
            return false;
        }
        if(curNode.right != null || !parentList.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }

    /** @return the next smallest number */
    public int next() {
        if(curNode == null) {
            return Integer.MAX_VALUE;
        }
        if(curNode.right != null) {
            parentList.push(curNode);
            curNode = curNode.right;
            
            while(curNode.left != null) {
                parentList.push(curNode);
                curNode = curNode.left;
            }
            return curNode.val;
        } else if(!parentList.isEmpty()) {
        		while(!parentList.isEmpty()) {
        			TreeNode p = parentList.pop();
        			if(curNode == p.left) {
        				curNode = p;
        				return curNode.val;
        			} else {
        				curNode = p;
        			}
        		}
                return Integer.MAX_VALUE;
        } else {
            return Integer.MAX_VALUE;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.right = right;
		
		  BSTIterator i = new BSTIterator(root);
		  while (i.hasNext()) {
			  System.out.println(i.next());
		  }

	}

}
