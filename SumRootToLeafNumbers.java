/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

 * @author Chris
 *
 */
public class SumRootToLeafNumbers {
	
    public void sumNumbers(TreeNode root, StringBuilder sb, long[] sum) {
        StringBuilder newsb = new StringBuilder(sb);
        if(root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            newsb.append(root.val);
            Long current = Long.parseLong(newsb.toString());
            sum[0] += current;
            return;
        }
        
        newsb.append(root.val);
        sumNumbers(root.left, newsb, sum);
        sumNumbers(root.right, newsb, sum);
    }
    
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        long[] sum = new long[1];
        sum[0] = 0;
        sumNumbers(root, sb, sum);
        
        if (sum[0] > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)sum[0];
        }

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
