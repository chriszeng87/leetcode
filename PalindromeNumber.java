/**
 * 
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
 * @author chriszeng
 * 
 */
public class PalindromeNumber {
	
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int factor = 1;
        int temp = x;
        while (temp / 10 != 0) {
            factor = factor * 10;
            temp = temp / 10;
        }
        
        temp = x;
        while (factor != 1 && factor != 0) {
            int left = temp / factor;
            int right = temp % 10;
            if (left != right) {
                return false;
            }
            
            temp = (temp - left * factor) / 10;
            factor = factor / 100;
        }
        
        return true;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------------isPalindrome = " + isPalindrome(23432));
		System.out.println("---------------isPalindrome = " + isPalindrome(2332));
		System.out.println("---------------isPalindrome = " + isPalindrome(2));
		
		System.out.println("---------------isPalindrome = " + isPalindrome(21));
	}

}
