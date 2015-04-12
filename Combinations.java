import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 * For example, if n = 4 and k = 2, a solution is:

 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 * @author Chris
 *
 */
public class Combinations {
	
	static ArrayList<int[]> getAllCombinations(int n, int k) {
		int[] tmpSolution = new int[k];
		ArrayList<int[]> ret = new ArrayList<int[]>();
		getAllCombinations(n, k , 1, 0, tmpSolution, ret);
		return ret;
		
	}
	
	static void getAllCombinations(int n, int k, int start, int index, int[] tempSolution,
			ArrayList<int[]> result) {
		if (index == k) {
			int[] solution = Arrays.copyOf(tempSolution, tempSolution.length);
			result.add(solution);
			return;
		}
		
		for (int i = start; i <= n; i++) {
			tempSolution[index] = i;
			getAllCombinations(n, k, i + 1, index + 1, tempSolution, result);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<int[]> ret = getAllCombinations(4, 2);
		for (int[] solution: ret) {
			System.out.print("\nsolution: ");
			for (int i = 0; i < solution.length; i++) {
				System.out.print(solution[i] + "  ");
			}
		}

	}

}
