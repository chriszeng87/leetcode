import java.math.BigInteger;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * click to show spoilers.
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 * 
 * @author Chris
 * 
 */
public class ReverseInteger {
	
    public static int reverse(int x) {
        boolean isNegative = false;
        if(x < 0) {
            x = -x;
            isNegative = true;
        }
        
        BigInteger ret = BigInteger.ZERO;
        BigInteger remain;
        
        while (x != 0) {
            remain = BigInteger.valueOf(x % 10);
            ret = ret.multiply(BigInteger.TEN).add(remain);
            x = x / 10;
        }
        
        if(isNegative) {
            ret = ret.multiply(BigInteger.valueOf(-1));
        }
        
        if (ret.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0
        		|| ret.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
        	return 0;
        }
        
        return ret.intValue();
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----ret = " + reverse(-123));

	}

}
