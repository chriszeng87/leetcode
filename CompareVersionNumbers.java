/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author Chris
 * 
 */
public class CompareVersionNumbers {

	static int compareInt(int num1, int num2) {
		if (num1 == num2) {
			return 0;
		} else if (num1 > num2) {
			return 1;
		} else {
			return -1;
		}
	}

	static int compareVersionNumbers(String s1, String s2) {
		if ((s1 == null || s1.length() == 0)
				|| (s2 == null || s2.length() == 0)) {
			return Integer.MIN_VALUE;
		}
		String[] array1 = s1.split("\\.");
		String[] array2 = s2.split("\\.");

		if (array1.length == 1) {
			if (array2.length == 1) {
				return 0;
			} else {
				if (Integer.parseInt(array2[1]) == 0) {  // 1 and 1.0
					return 0;
				} else {
					return -1;
				}
			}
		} else {
			if (array2.length == 1) {
				if (Integer.parseInt(array1[1]) == 0) {  // 1 and 1.0
					return 0;
				} else {
					return -1;
				}
			} else {
				int n1 = Integer.parseInt(array1[0]);
				int n2 = Integer.parseInt(array2[0]);
				if (n1 == n2) {
					return compareInt(Integer.parseInt(array1[1]),
						Integer.parseInt(array2[1]));
				} else {
					return compareInt(n1,n2);
				}
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "0.1";
		String s2 = "1.1";
		String s3 = "1.2";
		String s4 = "13.37";
		String s5 = "0";
		String s6 = "1.0";
		String s7 = "1";
		System.out.println(compareVersionNumbers(s1, s2));
		System.out.println(compareVersionNumbers(s2, s3));
		System.out.println(compareVersionNumbers(s3, s4));
		System.out.println(compareVersionNumbers(s3, s1));
		System.out.println(compareVersionNumbers(s3, s4));
		System.out.println(compareVersionNumbers(s6, s7));
		System.out.println(compareVersionNumbers(s7, s6));
		System.out.println(compareVersionNumbers(s5, s1));

	}

}
