/**
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

* A subsequence of a string is a new string which is formed from the original string by deleting some 
* (can be none) of the characters without disturbing the relative positions of the remaining characters. 
* (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

* Here is an example:
* S = "rabbbit", T = "rabbit"

* Return 3.
 * @author Chris
 *
 */
public class DistinctSubsequencesTotal {
	
	public static int numDistincts(String S, String T) {
		//table[i][j]为字符串i变换到j的变换方法
		int[][] table = new int[S.length() + 1][T.length() + 1];
	 
		for (int i = 0; i < S.length(); i++) {
			//把任意一个字符串变换为一个空串只有一个方法
			table[i][0] = 1;
		}
	 
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					//如果当前S[i]==T[j]，那么当前这个字母即可以保留也可以抛弃，
					//所以变换方法等于保留这个字母的变换方法加上不用这个字母的变换方法。
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				} else {
					//如果当前字符不等，那么就只能抛弃当前这个字符
					table[i][j] += table[i - 1][j];
				}
			}
		}
		
		for (int i = 0; i <= S.length(); i++) {
			System.out.println();
			for (int j = 0; j <= T.length(); j++) {
				System.out.print("  " + table[i][j]);
			}
		}
		return table[S.length()][T.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numDistincts("rabbbit", "rabbit");
	}

}
