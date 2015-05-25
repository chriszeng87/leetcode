/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author Chris
 * 
 */
public class MinimumPathSum {
	
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int row = 0; 
        int col = 0;
        int[][] dp = new int[m][n];
        int sum = 0;
        while (row < m) {
            sum += grid[row][0];
            dp[row][0] = sum;
            row++;
        }
        
        sum = 0;
        while(col < n) {
            sum += grid[0][col];
            dp[0][col] = sum;
            col++;
        }
        
        for (row = 1; row < m; row++) {
            for (col = 1; col < n; col++) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1])
                                + grid[row][col];
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
