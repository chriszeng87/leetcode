/**
 * Implement pow(x, n).
 * 
 * @author Chris
 * 
 */
public class MyPow {
	
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return 1 / x * temp * temp;
            }
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(2, 3));
		System.out.println(myPow(2, -2));
	}

}
