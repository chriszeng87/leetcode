/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * @author Chris
 *
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        } else if (a.length() == 0 || b.length() == 0) {
            return a + b;
        }
        
        StringBuilder ret = new StringBuilder();
        int m = a.length(), n = b.length();
        int i = m - 1, j = n - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int cur = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            if(cur <= 1) {
                ret.append(cur);
                carry = 0;
            } else {
                ret.append(cur % 2);
                carry = 1;
            }
            i--;
            j--;
        }
        
        
        while( i >= 0 ) {
            int cur = carry + (a.charAt(i) - '0');
            if(cur == 2) {
                ret.append('0');
                carry = 1;
            } else {
                ret.append(cur);
                carry = 0;
            }
            i--;
        }

        
        while( j >= 0 ) {
            int cur = carry + (b.charAt(j) - '0');
            if(cur == 2) {
                ret.append('0');
                carry = 1;
            } else {
                ret.append(cur);
                carry = 0;
            }
            j--;
        }
        
        if (carry == 1) {
            ret.append(carry);
        }
        
        return ret.reverse().toString();
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
