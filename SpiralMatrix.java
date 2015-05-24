import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 * 
 * @author Chris
 * 
 */
public class SpiralMatrix {
	
    public static  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        
        if (matrix.length == 1) {
        	for (int i = 0; i < matrix[0].length; i++) {
        		list.add(matrix[0][i]);
        	}
        	return list;
        } else if (matrix[0].length == 1) {
        	for (int i = 0; i < matrix.length; i++) {
        		list.add(matrix[i][0]);
        	}
        	return list;
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        int level = 0;
        while(level <= m / 2 - 1 && level <= n / 2 - 1) {
            int row, col;
            // left to right
            for (col = level; col < n - level; col++) {
                list.add(matrix[level][col]);
            }
            
            //right to down
            for (row = level + 1; row < m - level; row++) {
                list.add(matrix[row][n - level - 1]);
            }
            
            for (col = n - level - 2; col >= level; col--) {
                list.add(matrix[m - level - 1][col]);
            }
            
            for (row = m - 2 - level; row >= level + 1; row--) {
                list.add(matrix[row][level]);
            }
            level++;
        }
        if (m % 2 != 0 && m <= n) {
        	for (int i = m / 2; i <= Math.max(m / 2, n /2); i++) {
        		list.add(matrix[m / 2][i]);
        	}
        } else if (n % 2 != 0 && n < m) {
        	for (int i = n / 2; i <= Math.max(m / 2, n /2); i++) {
        		list.add(matrix[i][n / 2]);
        	}
        }
        
        return list;
        
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{ 1, 2, 3 }, 
				          { 4, 5, 6 }, 
				          { 7, 8, 9 }};
		List<Integer> ret = spiralOrder(matrix);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix2 = {{ 1, 2, 3, 4, 5 }, 
		          		   { 6, 7, 8, 9, 10}, 
		          		   { 11,12,13,14,15},
		          		   { 16,17,18,19,20}};
		ret = spiralOrder(matrix2);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix3 = {{ 1, 2, 3, 4, 5 }, 
       		   			   { 6, 7, 8, 9, 10}, 
       		   			   { 11,12,13,14,15},
       		   			   { 16,17,18,19,20},
       		   			   { 21,22,23,24,25}};
		ret = spiralOrder(matrix3);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix4 = {{ 1, 2, 3, 4, 5 ,6 }, 
	   			   		   { 7, 8, 9,10,11,12 },
	   			   		   {13,14,15,16,17,18 },
	   			   		   {19,20,21,22,23,24 },
	   			   		   {25,26,27,28,29,30 },
	   			   		   {31,32,33,34,35,36 }};

		ret = spiralOrder(matrix4);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix5 = {{ 1, 2, 3}};
		ret = spiralOrder(matrix5);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix6 = {{2,5},{8,4},{0,-1}};
		ret = spiralOrder(matrix6);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix7 = {{1, 2, 3}, {4, 5, 6}};
		ret = spiralOrder(matrix7);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix8 = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
		ret = spiralOrder(matrix8);
		System.out.println("-------ret = " + ret);
		
		int[][] matrix9 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		ret = spiralOrder(matrix9);
		System.out.println("-------ret = " + ret);
	}

}
