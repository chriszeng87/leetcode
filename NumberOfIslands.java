/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 * @author Chris
 *
 */
public class NumberOfIslands {
	
    private void explore(char[][] grid, boolean[][] exist, int row, int col) {
        if(row < 0 || row >= grid.length
            || col < 0 || col >= grid[0].length) {
                return;
        }
        if (grid[row][col] == '1' && !exist[row][col]) {
            exist[row][col] = true;
            explore(grid, exist, row + 1, col);
            explore(grid, exist, row - 1, col);
            explore(grid, exist, row, col - 1);
            explore(grid, exist, row, col + 1);
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 
            || grid[0].length == 0) {
            return 0;        
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] exist = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1' && !exist[row][col]) {
                    explore(grid, exist, row, col);
                    count++;
                }
            }
        }
        
        return count;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
