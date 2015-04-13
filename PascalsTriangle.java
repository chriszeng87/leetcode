import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle. For example, given numRows = 5, the result should be:

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author Chris
 *
 */
public class PascalsTriangle {
	
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return lists;
        }      

        List<Integer> topList = new ArrayList<Integer>();
        topList.add(1);
        lists.add(topList);
        if (numRows == 1) {
        	return lists;
        }
        
        List<Integer> secList = new ArrayList<Integer>();
        secList.add(1);
        secList.add(1);
        lists.add(secList);
        if (numRows == 2) {
        	return lists;
        }
        
        for (int i = 2; i < numRows; i++) {
        	List<Integer> list = new ArrayList<Integer>();
        	List<Integer> lastList = lists.get(lists.size() - 1);
        	list.add(1);
        	for (int j = 0; j < lastList.size() - 1; j++) {
        		list.add(lastList.get(j) + lastList.get(j + 1));
        	}
        	list.add(1);
        	lists.add(list);
        }
        
        return lists;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------" + generate(5));

	}

}
