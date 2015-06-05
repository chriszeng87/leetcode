import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
 *  adjacent numbers on the row below.

* For example, given the following triangle

* [
*     [2],
*    [3,4],
*   [6,5,7],
*  [4,1,8,3]
* ]
*The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

* Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total 
* number of rows in the triangle.
 * @author Chris
 *
 */
public class Triangle {
	
    private static int min = Integer.MAX_VALUE;
    
    //Time Limit Exceeded
    public static void minimumTotal(List<List<Integer>> triangle, int level, int curMin,
        int curIndex) {
        if(level == triangle.size()) {
            if(curMin < min) {
                min = curMin;
            }
            return;
        }
        
        int lastCur = curMin;
        for (int i = curIndex; i <= curIndex + 1 && i < triangle.get(level).size(); i++) {
            curMin = lastCur + triangle.get(level).get(i);
            minimumTotal(triangle, level + 1, curMin, i);
        }
    }
    
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) {
            return 0;
        }
        
        minimumTotal(triangle, 0, 0, 0);
        return min;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(-5);
		
		triangle.add(list);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		
		int min = minimumTotal(triangle);
		System.out.println("----min = " + min);
		
	}

}
