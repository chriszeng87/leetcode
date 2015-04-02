/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:

* 1) Integers in each row are sorted from left to right. 
* 2) The first integer of each row is greater than the last integer of the previous row.

* For example, consider the following matrix:

* [
*  [1,   3,  5,  7],
*  [10, 11, 16, 20],
*  [23, 30, 34, 50]
* ]
* Given target = 3, return true.
* 
 * @author Chris
 *
 */
public class Search2DMatrix {
	
	static boolean searchMatrix(int[][] arr, int value) {
		if (arr == null) {
			return false;
		}
		
		int rowLow = 0;
		int rowHigh = arr.length -1 ;

		while (rowLow < rowHigh) {
			int rowMid = (rowLow + rowHigh) / 2;
			if (value > arr[rowMid][0]) {
				rowLow= rowMid + 1;
			} else if (value < arr[rowMid][0]) {
				rowHigh = rowMid - 1;
			} else {
				return true;
			}
		}
		
		if (value < arr[rowLow][0] && rowLow > 0) {
			rowLow = rowLow -1;
		}
		
		int colLow = 0;
		int colHigh = arr[0].length - 1;
		while (colLow <= colHigh) {
			int colMid = (colLow + colHigh) / 2;
			if (value == arr[rowLow][colMid]) {
				return true;
			} else if (value > arr[rowLow][colMid]) {
				colLow = colMid + 1;
			} else {
				colHigh = colMid - 1;
			}
		}
		
		return false;
	}
	
    static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int start = 0;
        int end = m*n-1;
 
        while(start<=end){
            int mid=(start+end)/2;
            int midX=mid/n; //cool
            int midY=mid%n;
 
            if(matrix[midX][midY]==target) 
                return true;
 
            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
 
        return false;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50},
				{51, 52, 53, 54}
		};
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.println(array[i][j] + " in matrix: " + searchMatrix(array, array[i][j]));				
			}
		}
		System.out.println(searchMatrix(array, 100));
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.println(array[i][j] + " in matrix: " + searchMatrix2(array, array[i][j]));				
			}
		}
		System.out.println(searchMatrix(array, 100));

	}

}
