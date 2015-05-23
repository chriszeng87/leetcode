/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author Chris
 * 
 */
public class LongestValidParentheses {
	
	//http://blog.csdn.net/cfc1243570631/article/details/9304525
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) {
            return 0;
        }
        //dp[i]表示以s.charAt(i)开始的有效括号对
        int[] dp = new int[s.length()];
        int i = 0;
        while (i < dp.length) {
            dp[i] = 0;
            i++;
        }
        
        int maxLen = 0;
        i = dp.length - 2;
        while (i >= 0) {
            if(s.charAt(i) == '(') {
                int j = i + 1 + dp[i + 1];
                if(j < dp.length && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    //j + 1在范围之内，还要加上以j+1开始的有效括号对的长度
                    if(j + 1 < dp.length) {
                        dp[i] += dp[j + 1];
                    }
                }
                if(dp[i] > maxLen) {
                    maxLen = dp[i];
                }
            }
            i--;
        }
        
        return maxLen;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
