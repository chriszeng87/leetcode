import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

 * @author Chris
 *
 */
public class PascalTriangleII {
	
    public List<Integer> getRow(int rowIndex) {
        List<Integer> firstList = new ArrayList<Integer>();
        firstList.add(1);
        if (rowIndex == 0) {
            return firstList;
        }
        
        List<Integer> secondList = new ArrayList<Integer>();
        for (int level = 1; level <= rowIndex; level++ ) {
            firstList.clear();
            firstList.addAll(secondList);
            secondList.clear();
            secondList.add(1);
            for (int j = 0; j < firstList.size() - 1; j++) {
                secondList.add(firstList.get(j) + firstList.get(j + 1));
            }
            secondList.add(1);
        }
        
        return secondList;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
