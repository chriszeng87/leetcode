import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * 
 * @author Chris
 * 
 */
public class PathSumII {

	public void getAllPath(TreeNode root, int sum, List<Integer> path,
			List<List<Integer>> lists) {
		if (root != null) {
			List<Integer> tempPath = new ArrayList<Integer>(path);
			tempPath.add(root.val);

			if (root.left == null && root.right == null) {
				if (root.val == sum) {
					lists.add(tempPath);
				}
				return;
			} else {
				sum = sum - root.val;
				getAllPath(root.left, sum, tempPath, lists);
				getAllPath(root.right, sum, tempPath, lists);
			}
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		getAllPath(root, sum, path, paths);
		return paths;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
