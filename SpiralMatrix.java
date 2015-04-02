import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

* For example, given the following matrix:

* [
*  [ 1, 2, 3 ],
*  [ 4, 5, 6 ],
*  [ 7, 8, 9 ]
* ]
* You should return [1,2,3,6,9,8,7,4,5].
 * 
 * 
 * @author Chris
 *
 */

class Pointer {
	public int row;
	public int col;
	
	public Pointer(int x, int y) {
		this.row = x;
		this.col = y;
	}
	
	public Pointer(Pointer p) {
		this.row = p.row;
		this.col = p.col;
	}

	@Override
	public String toString() {
		return "Pointer [x=" + row + ", y=" + col + "]";
	}
	
	

}

public class SpiralMatrix {
	
	static List<Integer> getSpiralOrder(int[][] array) {
		List<Integer> lists = new ArrayList<Integer>();
		if (array == null) {
			return null;
		}
		int m = array.length;
		int n = array[0].length;
		int left = -1; 
		int right = n;
		int top =  0;
		int down = m;
		
		
		Pointer position = new Pointer(0, 0);
		lists.add(array[position.row][position.col]);
		int nowDirectionIndex = 0;
		Pointer newPosition = new Pointer(0, 0);
		while(true) {
			if (nowDirectionIndex == 0) { // go right
				if (position.col + 1 < right) {
					newPosition = new Pointer(position.row, position.col + 1);
					lists.add(array[newPosition.row][newPosition.col]);
				} else {
					right = right - 1;
					nowDirectionIndex = 1;
				}
			} else if( nowDirectionIndex == 1) { // go down
				if (position.row + 1 < down) {
					newPosition = new Pointer(position.row + 1, position.col);
					lists.add(array[newPosition.row][newPosition.col]);
				} else {
					down = down - 1;
					nowDirectionIndex = 2;
				}				
			} else if( nowDirectionIndex == 2) { // go left
				if (position.col - 1 > left) {
					newPosition = new Pointer(position.row, position.col - 1);
					lists.add(array[newPosition.row][newPosition.col]);
				} else {
					left = left + 1;
					nowDirectionIndex = 3;
				}				
			}  else if( nowDirectionIndex == 3) { // go up
				if (position.row - 1 > top) {
					newPosition = new Pointer(position.row  -1 , position.col);
					lists.add(array[newPosition.row][newPosition.col]);
				} else {
					top = top + 1;
					nowDirectionIndex = 0;
				}				
			}
			
			//update position
			position.row = newPosition.row;
			position.col = newPosition.col;
			
			//break condition
			if (left > n / 2 || top > n /2 || right < n /2 || down < n /2) {
				break;
			}
		}
		
		
		return lists;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = {{ 1, 2, 3 },
					{4, 5, 6 },
					{ 7, 8, 9 }};
		System.out.println(getSpiralOrder(arr));
		
		int[][] arr2 = {{ 1, 2, 3, 4 },
				{5, 6, 7, 8 },
				{ 9, 10, 11, 12 }};
		System.out.println(getSpiralOrder(arr2));
		
		int[][] arr3 = {{ 1, 2, 3, 4 },
				{5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{13, 14, 15, 16}};
		System.out.println(getSpiralOrder(arr3));


	}

}
