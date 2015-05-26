/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

 * @author Chris
 *
 */
public class EditDistance {
	
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int i = 0, j = 0;
        while (i < word1.length() + 1) {
            dp[i][0] = i;
            i++;
        }
        
        while ( j < word2.length() + 1) {
            dp[0][j] = j;
            j++;
        }
        
        
        for (i = 1; i <= word1.length(); i++) {
            for (j = 1; j <= word2.length(); j++) {
                int tempMin = Integer.MAX_VALUE;
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    tempMin = dp[i - 1][j - 1];
                } else {
                    tempMin = dp[i - 1][j - 1] + 1;
                }
                
                tempMin = Math.min(tempMin, Math.min(dp[i - 1][j] + 1,
                                                dp[i][j - 1] + 1));
                dp[i][j] = tempMin;
            }
        }
        
        return dp[word1.length()][word2.length()];
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
