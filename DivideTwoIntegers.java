/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author Chris
 * 
 */
public class DivideTwoIntegers {

	public static int helper(long dividend, long divisor) {
		if (dividend < divisor) {
			return 0;
		}

		int numShift = 0;
		long tmp = divisor;
		while (tmp <= dividend) {
			tmp = tmp << 1;
			numShift++;
		}

		return numShift;
	}

	public static int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		} else if (divisor == Integer.MIN_VALUE) {
			if (dividend == Integer.MIN_VALUE) {
				return 1;
			} else {
				return 0;
			}
		} else if (dividend == Integer.MIN_VALUE) {
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
		} else if (Math.abs(dividend) < Math.abs(divisor)) {
			return 0;
		}

		long ret = 0;
		int flag = 1;
		if (dividend > 0 && divisor < 0) {
			flag = -1;
		} else if (dividend < 0 && divisor > 0) {
			flag = -1;
		}
		long dividendL = Math.abs((long)dividend);
		long divisorL = Math.abs((long)divisor);

		int tmpShift = 0;
		while ((tmpShift = helper(dividendL, divisorL)) != 0) {
			ret = ret + (long)(1 << (tmpShift - 1));
			dividendL = dividendL - (divisorL << (tmpShift - 1));
		}

		return flag * (int) ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------- " + divide(10, 3));
		System.out.println("-------- " + divide(10, 2));
		System.out.println("-------- " + divide(10, 5));
		System.out.println("-------- " + divide(10, 10));
		System.out.println("-------- " + divide(-2147483648, -1));


	}

}
