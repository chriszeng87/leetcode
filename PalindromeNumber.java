/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author Chris
 * 
 */
public class PalindromeNumber {
	
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int pow = 1;
        int val = x;
        int high = 0, low = 0;
        while (val / 10 != 0) {
            pow = pow * 10;
            val = val / 10;
            high++;
        }
        
        while (low < high) {
            if (x / pow != x % 10) {
                return false;
            }
            x = (x - (x / pow) * pow) / 10;
            pow = pow / 100;
            low++;
            high--;
        }
        
        return true;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
