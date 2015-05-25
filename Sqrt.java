/**
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * @author Chris
 *
 */
public class Sqrt {
	
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        int left = Math.min(x, 1);
        int right = Math.max(x, 1);
        while (left < right) {
            int mid = (left + right) >> 1;
            int tmp = mid * mid;
            if (tmp == x) {
                return mid;
            } else if (tmp > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        int tmp2 = left * left;
        if (tmp2 == x) {
            return left;
        } else if (tmp2 > x) {
            return left - 1;
        } else {
            return left;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret = mySqrt(100);
		System.out.println("-----ret = " + ret);
	}

}
