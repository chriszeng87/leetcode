/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author Chris
 * 
 */
public class PlusOne {
	
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        
        int len = digits.length;
        boolean needMoreDigit = true;
        int i = 0;
        while (i < len) {
            if(digits[i] != 9) {
                needMoreDigit = false;
            }
            i++;
        }
        
        if (needMoreDigit) {
            len = len + 1;
        }
        int[] newDigits = new int[len];
        
        int carry = 1;
        for (i = len - 1; i > 0; i--) {
        	int j = i;
        	if (needMoreDigit) {
        		j = i - 1;
        	}
            if (digits[j] == 9 && carry == 1) {
                newDigits[i] = 0;
                carry = 1;
            } else {
                newDigits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        
        if (needMoreDigit) {
        	newDigits[0] = 1;
        } else {
        	newDigits[0] = digits[0] + carry;
        }
        
        return newDigits;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = {1,8,9};
		int[] newDigits = plusOne(digits);
//		System.out.println();
		for (int i = 0; i < newDigits.length; i++) {
			System.out.print(" " + newDigits[i]);
		}
	}

}
