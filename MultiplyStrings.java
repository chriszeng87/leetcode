/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author Chris
 * 
 */
public class MultiplyStrings {

	public static String multiply(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		if (len1 == 0 || len2 == 0) {
			return "0";
		}

		int[] newNum = new int[len1 + len2];

		for (int i = 0; i < len1; i++) {
			int carry = 0;
			int n1 = (int) (num1.charAt(len1 - i - 1) - '0'); // calculate from
																// the rightmost
																// to left
			for (int j = 0; j < len2; j++) {
				int n2 = num2.charAt(len2 - j - 1) - '0';
				int sum = n1 * n2 + newNum[i + j] + carry;
				carry = sum / 10;
				newNum[i + j] = sum % 10;
			}
			if (carry > 0) {
				newNum[i + len2] += carry;
			}
		}

		int start = len1 + len2 - 1;
		while (newNum[start] == 0) {
			start--;
		}

		if (start == -1) {
			return "0";
		}

		StringBuilder s = new StringBuilder();
		for (int i = start; i >= 0; i--) {
			s.append(newNum[i]);
		}
		return s.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------" + multiply("250", "120"));
		System.out.println(123 * 46 + "");
	}

}
