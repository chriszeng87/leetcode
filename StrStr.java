/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Update (2014-11-02): The signature of the function had been updated to return
 * the index instead of the pointer. If you still see your function signature
 * returns a char * or String, please click the reload button to reset your code
 * definition.
 * 
 * @author Chris
 * 
 */
public class StrStr {

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}

		if (haystack.length() == 0 && needle.length() == 0) {
			return 0;
		}

		if (haystack.length() == 0) {
			return -1;
		} else if (needle.length() == 0) {
			return 0;
		}

		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length()) {
					return i;
				}

				if (i + j == haystack.length()) {
					return -1;
				}

				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
