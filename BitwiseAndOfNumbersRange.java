/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return 
 * the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
 * @author Chris
 *
 */
public class BitwiseAndOfNumbersRange {
	
    public static int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        } else if (m == n - 1) {
            return m & n;
        }
        
        // if n > m, odd and even both exists, so last bit is alwasy 0
        return rangeBitwiseAnd(m / 2, n / 2) << 1;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret = rangeBitwiseAnd(4, 6);
		System.out.println("------ret = " + ret);
	}

}
