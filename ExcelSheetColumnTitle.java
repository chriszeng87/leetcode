/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author Chris
 * 
 */
public class ExcelSheetColumnTitle {
	
	public String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();
		if (n <= 0) {
			return result.toString();
		}

		while (n != 0) {
			n--;
			result.append((char) (n % 26 + 'A'));
			n = n / 26;
		}

		result = result.reverse();
		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
