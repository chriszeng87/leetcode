import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].

public class PermutationsII {
	public Set<List<Integer>> permuteCur(int[] nums, int curIndex) {
		Set<List<Integer>> lists = new HashSet<List<Integer>>();
		if (curIndex == nums.length) {
			return lists;
		}

		Set<List<Integer>> remainLists = permuteCur(nums, curIndex + 1);
		if (remainLists.size() == 0) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(nums[curIndex]);
			lists.add(temp);
		} else {
			for (List<Integer> remainList : remainLists) {
				for (int i = 0; i <= remainList.size(); i++) {
					List<Integer> newList = new ArrayList<Integer>(remainList);
					newList.add(i, nums[curIndex]);
					lists.add(newList);
				}
			}
		}

		return lists;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Set<List<Integer>> set = permuteCur(nums, 0);
		for (List<Integer> list: set) {
			result.add(list);
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
