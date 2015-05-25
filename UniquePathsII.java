/**
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
 * @author Chris
 *
 */
public class UniquePathsII {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0
            || obstacleGrid[0].length == 0) {
                return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int row = 0, col = 0;
        boolean noRoute = false;
        while (row < m) {
            if (obstacleGrid[row][0] == 0 && !noRoute) {
                dp[row][0] = 1;
            } else {
                dp[row][0] = 0;
                noRoute = true;
            }
            row++;
        }
        
        noRoute = false;
        while (col < n) {
            if (obstacleGrid[0][col] == 0 && !noRoute) {
                dp[0][col] = 1;
            } else {
                dp[0][col] = 0;
                noRoute = true;
            }
            col++;
        }
        
        for (row = 1; row < m; row++) {
            for (col = 1; col < n; col++) {
                if(obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
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
