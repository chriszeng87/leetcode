import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [ 
 * 	[".Q..", // Solution 1    1 3 0 2
 *  "...Q", 
 *  "Q...", 
 *  "..Q."],                  0 1 2 3
 * 
 * 	["..Q.", // Solution 2    2 0 3 1
 *  "Q...", 
 *  "...Q", 
 *  ".Q.."] 
 *  
 *  
 *  .Q..
...Q
..Q.         0 1 2 3
Q...         1 3 2 0
 * ]
 */
public class NQueens {
	
	public static void checkcheck() {
		String[] strArray = {".Q..",
				"...Q",
				"..Q.",//         0 1 2 3
				"Q..." };
		boolean checkValue = check(strArray,3);
		System.out.println("checkValue = " + checkValue);
		
		String[] strArray2 =  {"..Q.", // Solution 2    2 0 3 1
		   	   "Q...", 
		   	   "...Q", 
		   	   ".Q.."}; 
		 checkValue = check(strArray2,3);
			System.out.println("checkValue = " + checkValue);
	}
	
    public static boolean check(String[] strArray, int cur) {
    	if (cur == 0) {
    		return true;
    	}
        int[] arr = new int[cur + 1];
        int i = 0, j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < strArray.length; j++) {
                if (strArray[i].charAt(j) == 'Q') {
                    arr[i] = j;
                }
            }
        }
        
        for (i = 0; i <  arr.length ; i++) {
        	for (j = i + 1; j < arr.length; j++) {
                if((arr[i] == arr[j]) || Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
                    return false;
                }
        	}
        }
        
        return true;
    }
    
    public static void recursive(int cur, List<String[]> lists, int n, String[] strArray) {
        if (cur == n) {
            //copy the array?
            String[] temp = new String[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                temp[i] = new String(strArray[i]);
            }
            lists.add(temp);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int j = 0;
            for (j = 0; j < i; j++) {
                temp.append('.');
            }
            temp.append('Q');
            for (j = i + 1; j < n; j++) {
                temp.append('.');
            }
            strArray[cur] = temp.toString();
            if (check(strArray, cur)) {
                recursive(cur + 1, lists, n , strArray);
            }
        }
    }
    
    public static List<String[]> solveNQueens(int n) {
        List<String[]> lists = new ArrayList<String[]>();
        String[] array = new String[n];
        recursive(0, lists, n, array);
        return lists;
    }
    
    public static void printStringArray(String[] arr) {
    	System.out.println("arr is ");
    	for (String str : arr) {
    		System.out.println(str);
    	}
    	System.out.println();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> lists = solveNQueens(4);
		for (String[] array: lists) {
			printStringArray(array);
		}
//		checkcheck();
	}

}
