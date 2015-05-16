/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author Chris
 * 
 */
public class Atoi {

	public static int myAtoi(String str) {
		int ret = 0;
		if (str == null || str.length() == 0) {
			return ret;
		}

		int i = 0;
		while (str.charAt(i) == ' ' && i < str.length()) {
			i++;
		}

		boolean isPositive = true;
		if (str.charAt(i) == '-') {
			isPositive = false;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}

		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c - '0' < 0 || '9' - c < 0) {
				break;
			}
			if (ret > Integer.MAX_VALUE / 10
					|| (ret == Integer.MAX_VALUE / 10 && (c - '0' >= 8))) {
				if (isPositive) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
			ret = ret * 10 + (c - '0');

		}

		if (!isPositive) {
			ret = -ret;
		}

		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret = myAtoi("12345");
		System.out.println(ret);

		ret = myAtoi("-12345");
		System.out.println(ret);

		ret = myAtoi("2147483647");
		System.out.println(ret);

		ret = myAtoi(" -1010023630o4");
		System.out.println(ret);
	}

}
