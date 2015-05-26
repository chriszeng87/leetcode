import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author Chris
 *
 */
public class Combinations2 {
	
    public static void getCombineList(int n, int k, int cur, List<Integer> list, List<List<Integer>> lists) {
        if(list.size() == k) {
            List<Integer> tempList = new ArrayList<Integer>();
            tempList.addAll(list);
            lists.add(tempList);
            return;
        }
        
        for(int i = cur; i <=n; i++) {
        	list.add(i);
            getCombineList(n, k, i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
    
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(n == 0 || k == 0 || k > n) {
            return lists;
        }
        
        getCombineList(n, k , 1, list, lists);
        
        return lists;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> ret = combine(4, 2);
		System.out.println(ret);
	}

}
