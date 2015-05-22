/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Chris
 * 
 */
public class RomanToInteger {

	public static int romanToInt(String s) {
		int ret = 0;
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int i = 0;
		while (i < s.length()) {
			for (int j = 0; j < value.length; j++) {
				while (i + symbol[j].length() <= s.length()
						&& s.substring(i, i + symbol[j].length()).equals(
								symbol[j])) {
					ret = ret + value[j];
					i = i + symbol[j].length();
				}
			}
		}

		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = romanToInt("MMMCMXCIX");
		System.out.println("----num = " + num);
	}

}
