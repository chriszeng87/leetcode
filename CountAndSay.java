/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author Chris
 * 
 */
public class CountAndSay {
	
	//1211        
    public static String helper(long n) {
        StringBuilder ret = new StringBuilder();
        if(n <= 0) {
            return ret.toString();
        }
        
        int pow = 1;
        long tmp = n;
        while(tmp / 10 != 0) { 
        	pow = pow * 10;  
        	tmp = tmp / 10; 
        }
        int lastDigit = -1;
        int lastDup = 0;
        while(n != 0) {
            int m = (int)n / pow;  //1 2 1 1
            if(lastDigit == -1 || m == lastDigit) {
                lastDup++; //1 2
            } else {
                ret = ret.append(lastDup).append(lastDigit); // 1112
                lastDup = 1;
            }
            lastDigit = m; //1  2 1
            n = n % pow; // 211  11 1
            pow = pow / 10; //100 10 1
        }
        ret = ret.append(lastDup).append(lastDigit);
        
        return ret.toString();
        
    }
    
    public static String countAndSay(int n) {
    	if(n == 1) {
    		return "1";
    	} else {
    		return helper(Long.parseLong(countAndSay(n - 1)));
    	}
    }
    
    public static String countAndSay2(int n) {
        String oldString = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char [] oldChars = oldString.toCharArray();

            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i+1) < oldChars.length && oldChars[i] == oldChars[i+1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            oldString = sb.toString();
        }

        return oldString;
    }
    
    public String countAndSay3(int n) {
    	String oldString = "1";
    	while(--n > 0) {
    	    StringBuilder sb = new StringBuilder();
    	    char[] array = oldString.toCharArray();
    	    char lastChar = array[0];
    	    int lastCount = 1;
    	    for (int i = 1; i < array.length; i++) {
    	        if(array[i] == lastChar) {
    	            lastCount++;
    	        } else {
    	            sb.append(lastCount).append(lastChar);
    	            lastChar = array[i];
    	            lastCount = 1;
    	        }
    	    }
    	    sb.append(lastCount).append(lastChar);
    	    oldString = sb.toString();
    	}
    	return oldString.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 11; i++) {
//			if (!countAndSay(i).equals(countAndSay2(i))) {
				System.out.println("i = " + i);
				System.out.println("-------" + countAndSay(i));
				System.out.println("+++++++" + countAndSay2(i));
//				System.out.println();
//			}
		}
		System.out.println("+++++++" + Long.MAX_VALUE);
//		System.out.println(countAndSay2(7));
	}

}
