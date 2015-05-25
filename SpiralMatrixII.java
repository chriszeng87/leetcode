/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author Chris
 *
 */
public class SpiralMatrixII {
	
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        
        int level = 0; 
        int num = 1;
        while (level < n / 2) {
            int row;
            int col;
            //go right
            for (col = level; col < n - level; col++) {
                matrix[level][col] = num++;
            }
            //go down
            for (row = level + 1; row < n - level; row ++) {
                matrix[row][n - level - 1] = num++;
            }
            //go left
            for ( col = n - level - 2; col >= level; col--) {
                matrix[n - level - 1][col] = num++;
            }
            for (row = n - level - 2; row >level; row--) {
                matrix[row][level] = num++;
            }
            //go top
            level++;
        }
        
        if (n % 2 != 0) {
            matrix[level][level] = num++;
        }
        
        return matrix;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
