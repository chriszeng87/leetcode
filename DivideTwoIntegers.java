/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author Chris
 * 
 */
public class DivideTwoIntegers {
	
    public static int helper(int dividend, int divisor) {
        if(dividend < divisor) {
            return 0;
        }
        
        long newdividend = (long)dividend;
        int numShift = 0;
        long tmp = divisor;
        while(tmp <= newdividend) {
            tmp = tmp << 1;
            numShift++;
        }
        
        return numShift;
    }
    
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else if(divisor == Integer.MIN_VALUE) {
         	if(dividend == Integer.MIN_VALUE) {
         		return 1;
         	} else {
         		return 0;
         	}
        } else if (dividend == Integer.MIN_VALUE) {
        	dividend = Integer.MIN_VALUE + 1;
        } else if(Math.abs(dividend) < Math.abs(divisor)) {       
            return 0;
        }
        
        long ret = 0;
        int flag = 1;
        if (dividend > 0 && divisor < 0) {
            divisor = - divisor;
            flag = -1;
        } else if(dividend < 0 && divisor > 0) {
            dividend = - dividend;
            flag = -1;
        } else if(dividend < 0 && divisor < 0) {
        	dividend = - dividend;
        	divisor = - divisor;
        }
        
        
        int tmpShift = 0;
        while ((tmpShift = helper(dividend, divisor)) != 0) {
            ret = ret + (1 << (tmpShift - 1));
            dividend = dividend - (divisor << (tmpShift - 1));
        }
        
        return flag * (int)ret;
    }
	
	// Time Limit Exceeded
    public int divide2(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else if (Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }
        
        int flag = 1;
        if (dividend > 0 && divisor < 0) {
            divisor = - divisor;
            flag = -1;
        } else if(dividend < 0 && divisor > 0) {
            dividend = - dividend;
            flag = -1;
        }
        
        int tempSum = 0;
        int ret = 0;
        while(tempSum <= dividend) {
            tempSum += divisor;
            ret++;
        }
        
        return flag * ret;
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
		
		System.out.println(Integer.MAX_VALUE);

	}

}
