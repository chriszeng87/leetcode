import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

 * @author Chris
 *
 */
public class BinaryTreeRightSideView {
	
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lists = new ArrayList<Integer>();
        if(root == null) {
            return lists;
        }
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                if (i == size - 1) {
                    lists.add(node.val);
                }
                if(node.left != null) {
                    nodeQueue.add(node.left);
                }
                if(node.right != null) {
                    nodeQueue.add(node.right);
                }
            }
        }
        
        return lists;
    }
    
    public List<Integer> rightSideView2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
     
        if(root == null) return result;
     
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
     
        while(queue.size() > 0){
            //get size here
            int size = queue.size();
     
            for(int i=0; i<size; i++){
                TreeNode top = queue.remove();
     
                //the first element in the queue (right-most of the tree)
                if(i==0){
                    result.add(top.val);
                }
                //add right first
                if(top.right != null){
                    queue.add(top.right);
                }
                //add left
                if(top.left != null){
                    queue.add(top.left);
                }
            }
        }
     
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
