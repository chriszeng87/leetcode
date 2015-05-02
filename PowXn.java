
public class PowXn {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1.0/x;
        } else {
            double result = 1;
            if (n % 2 != 0) {
                if (n > 0) {
                    result = x;
                } else  {
                    result = 1.0/x;
                }
            }
            double mid = myPow(x, n/2);
            return result * mid * mid;
        }
    }
}
