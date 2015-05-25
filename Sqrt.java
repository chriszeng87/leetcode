/**
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * @author Chris
 *
 */
public class Sqrt {
	
    public static int mySqrt(int x) {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            
            long left = Math.min(x, 1);
            long right = Math.max(x, 1);
            while (left < right) {
                long mid = (left + right) >> 1;
                long tmp = mid * mid;
                if (tmp == x) {
                    return (int)mid;
                } else if (tmp > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // return (int)left;        
            long tmp2 = left * left;
            if (tmp2 == x) {
                return (int)left;
            } else if (tmp2 > x) {
                return (int)left - 1;
            } else {
                return (int)left;
            }
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
