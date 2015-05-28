/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping: 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message
 * containing digits, determine the total number of ways to decode it. For
 * example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L"
 * (12). The number of ways decoding "12" is 2.
 * 
 * @author Chris
 * 
 */
public class DecodeWays {

	/**
	 * 当我们知道了n-2长度的字符串能够解释的数目以及n-1长度的字符串能够解释的数目时，我们可以判读如下两个条件：
	 * 1）若第n个字符在1到9之间，则n长度的字符串能够解释的数目包含n-1长度字符串能够解释的数目。
	 * 2）若第n-1个字符与第n个字符可以解释为一个字母时，则n长度的字符串能够解释的数目包含n-2长度字符串能够解释的数目。
	 * 
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] nums = new int[s.length() + 1];
		nums[0] = 1;
		nums[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') {
				nums[i] = nums[i - 1];
			}

			int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1)
					- '0';
			if (twoDigits >= 10 && twoDigits <= 26) {
				nums[i] += nums[i - 2];
			}
		}
		return nums[s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------numDecodings 222 = " + numDecodings("222"));
	}

}
