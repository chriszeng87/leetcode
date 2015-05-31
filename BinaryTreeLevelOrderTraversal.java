import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 * @author Chris
 *
 */
public class BinaryTreeLevelOrderTraversal {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Queue<Integer> levelQueue = new LinkedList<Integer>();
        levelQueue.add(1);
        
        int curLevel = 0;
        List<Integer> curList = new ArrayList<Integer>();
        curList.add(root.val);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levelQueue.poll();
            if(level != curLevel) {
                List<Integer> newList = new ArrayList<Integer>(curList);
                lists.add(newList);
                curList.clear();
                curLevel = level;
            }
            
            if(node.left != null) {
                queue.add(node.left);
                levelQueue.add(level + 1);
                curList.add(node.left.val);
            }
            
            if(node.right != null) {
                queue.add(node.right);
                levelQueue.add(level + 1);              
                curList.add(node.right.val);
            }
        }
        
        return lists;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
