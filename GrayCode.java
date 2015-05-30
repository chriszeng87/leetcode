import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 * @author Chris
 *
 */
public class GrayCode {
    
    public static List<Integer> getGrayCode(String str, int k, List<Integer> path) {
        List<Integer> list = new ArrayList<Integer>();
        if (k == str.length()) {
            if (Integer.parseInt(str, 2) == 0) {
                list.add(0);
                return list;
            }  else {
                return null;
            }
        }
        
        int num = Integer.parseInt(str, 2);
        if ( num == 0) {
            list.add(0);
            return list;
        } 
        
        path.add(num);
        
        for (int j = k; j < str.length(); j++) {
            StringBuilder str1 = new StringBuilder(str);
	        if (str.charAt(j) == '0') {
	            str1.replace(j, j + 1, "1");
	        } else {
	            str1.replace(j, j + 1, "0");
	        }
	        
	        if (!path.contains(Integer.parseInt(str1.toString(), 2))) {
	            list = getGrayCode(str1.toString(), j + 1, path);
	            if (list != null) {
	                list.add(Integer.parseInt(str.toString(), 2));
	                return list;
	            } else {
	                continue;
	            }
	        } else {
	        	continue;
	        }
        }
        
        return null;
        
    }
    
    
    public static List<Integer> grayCode(int n) {
        List<Integer> path = new ArrayList<Integer>();
        String str = Integer.toBinaryString(n);
        List<Integer> ret = getGrayCode(str.toString(), 0, path);
        return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			List<Integer> ret = grayCode(i);
			System.out.println(ret);
		}
	}

}
