import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If nums = [1,2,2], a
 * solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author chriszeng
 * 
 */
public class SubsetsII {
	
    public static void getSubSet(int[] nums, int curIndex, Set<List<Integer>> resultSet, List<Integer> curList) {
        List<Integer> tempList = new ArrayList<Integer>(curList);
        if (curIndex == nums.length) {
        	resultSet.add(tempList);
            return;
        }
        
        getSubSet(nums, curIndex + 1, resultSet, curList);
        int i = 0;

        while(i < tempList.size() && nums[curIndex] > tempList.get(i)) {
            i++;
        }
            
        if (i == tempList.size()) {
            tempList.add(nums[curIndex]);
        } else {
            tempList.add(i, nums[curIndex]);
        }

        getSubSet(nums, curIndex + 1, resultSet, tempList);
        return;
    }
	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        getSubSet(nums, 0, resultSet, list);
        
        result = new ArrayList<List<Integer>>(resultSet);
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,2,3};
		System.out.println("-------subsets = " + subsetsWithDup(nums));

	}

}
