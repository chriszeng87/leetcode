import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 * 
 * @author Chris
 * 
 */
public class CombinationSumS2 {

	public static void combinationSumRecur(int[] candidates, int target, int curIndex,
			List<Integer> list, List<List<Integer>> lists) {

		if (target == 0) {
			lists.add(list);
			return;
		} else if (curIndex >= candidates.length || target < 0) {
			return;
		}

		for (int i = 0; curIndex >= 0  && 
				target - i * candidates[curIndex] >= 0; i++) {
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

		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSumRecur(candidates, target, 0, list, lists);
		return lists;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> ret = combinationSum(candidates, target);
		System.out.println("--------ret = " + ret);
	}

}
