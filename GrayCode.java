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
        
		//第n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序的和
        public static List<Integer> grayCode(int n) {
            if(n==0) {  
                List<Integer> result = new ArrayList<Integer>();  
                result.add(0);  
                return result;  
            }  
              
            List<Integer> tmp = grayCode(n-1);  
            int addNumber = 1 << (n-1);  
            ArrayList<Integer> result = new ArrayList<Integer>(tmp);  
            for(int i=tmp.size()-1;i>=0;i--) {  
                result.add(addNumber + tmp.get(i));  
            }  
            return result; 
        }
        
        public static List<Integer> grayCode2(int n) {
        	List<Integer> result = new ArrayList<Integer>();  
            result.add(0);  
            for(int i=0; i<n;i++){  
                int highest = 1<<i;  
                int len = result.size();  
                for(int j=len -1; j>=0; j--){  
                    result.add(highest + result.get(j));  
                }  
            }  
            return result;  
        }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 50; i++) {
			List<Integer> ret = grayCode(2);
			System.out.println(ret);
//		}
			
		//  2   00 01 11 10
		//	    00 10
	}

}
