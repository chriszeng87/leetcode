import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If nums = [1,2,3], a
 * solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author chriszeng
 * 
 */
public class Subsets {
	
    public static void getSubSet(int[] nums, int curIndex, List<List<Integer>> result, List<Integer> curList) {
        List<Integer> tempList = new ArrayList<Integer>(curList);
        if (curIndex == nums.length) {
            result.add(tempList);
            return;
        }
        
        getSubSet(nums, curIndex + 1, result, curList);
        int i = 0;

        while(i < tempList.size() && nums[curIndex] > tempList.get(i)) {
            i++;
        }
            
        if (i == tempList.size()) {
            tempList.add(nums[curIndex]);
        } else {
            tempList.add(i, nums[curIndex]);
        }

        getSubSet(nums, curIndex + 1, result, tempList);
        return;
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        getSubSet(nums, 0, result, list);
        
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println("-------subsets = " + subsets(nums));
	}

}
