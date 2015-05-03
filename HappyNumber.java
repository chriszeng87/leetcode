import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 * 
 * @author Chris
 * 
 */
public class HappyNumber {

	public int getNewNum(int n) {
		int newNum = 0;
		int temp = n;
		while (temp != 0) {
			int remain = temp % 10;
			newNum = newNum + remain * remain;
			temp = temp / 10;
		}
		return newNum;
	}

	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}

		Set<Integer> set = new HashSet<Integer>();

		while (!set.contains(n)) {
			set.add(n);
			n = getNewNum(n);
			if (n == 1) {
				return true;
			}
		}

		return false;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
