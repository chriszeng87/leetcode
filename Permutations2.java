import java.util.ArrayList;
import java.util.List;

/**
 * My Submissions Question Solution Given a collection of numbers, return all
 * possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author Chris
 * 
 */
public class Permutations2 {
	
    public List<List<Integer>> permuteCur(int[] nums, int curIndex) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(curIndex == nums.length) {
            return lists;
        }
        
        List<List<Integer>> remainLists = permuteCur(nums, curIndex + 1);
        if (remainLists.size() == 0) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[curIndex]);
            lists.add(temp);
        } else {
            for (List<Integer> remainList: remainLists) {
                for(int i = 0; i <= remainList.size(); i++) {
                    List<Integer> newList = new ArrayList<Integer>(remainList);
                    newList.add(i, nums[curIndex]);
                    lists.add(newList);
                }
            }
        }
        
        return lists;
    }

    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result = permuteCur(nums, 0);
        return result;

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
