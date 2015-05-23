import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author Chris
 * 
 */
public class CombinationSumII {
	
	public static void combinationSumRecur(int[] candidates, int target, int curIndex,
			List<Integer> list, Set<List<Integer>> lists) {

		if (target == 0) {
			lists.add(list);
			return;
		} else if (curIndex >= candidates.length || target < 0) {
			return;
		}

		for (int i = 0; curIndex >= 0  && 
				target - i * candidates[curIndex] >= 0  & i < 2; i++) {
			List<Integer> newList = new ArrayList<Integer>(list);
			for (int j = 0; j < i; j++) {
				newList.add(candidates[curIndex]);
			}
			combinationSumRecur(candidates, target - i * candidates[curIndex],
					curIndex + 1, newList, lists);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (candidates == null) {
			return lists;
		}

		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSumRecur(candidates, target, 0, list, set);
		for(List<Integer> tmp : set) {
			lists.add(tmp);
		}
		return lists;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> ret = combinationSum(candidates, target);
		System.out.println("--------ret = " + ret);
	}

}
