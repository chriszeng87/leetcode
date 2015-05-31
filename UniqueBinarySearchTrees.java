import java.util.Arrays;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 * @author Chris
 *
 */
public class UniqueBinarySearchTrees {
	
    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        int[] dp  = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
            for (int j = 2; j <= i - 1; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 5; i++)
			System.out.println("----------" + numTrees(i));
		
		
//		Arrays.fil
	}
	


}
