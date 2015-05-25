/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author Chris
 * 
 */
public class UniquePaths {
	
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        int row = 0, col = 0;
        for ( ; row < m; row++) {
            dp[row][0] = 1;
        }
        for (; col < n; col++) {
            dp[0][col] = 1;
        }
        
        for (row = 1; row < m; row++) {
            for (col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
