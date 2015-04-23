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
                curNode = parentList.pop();
                return curNode.val;
        } else {
            return Integer.MAX_VALUE;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
