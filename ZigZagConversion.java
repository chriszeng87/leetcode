/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * @author Chris
 * 
 */
public class ZigZagConversion {
	
    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        int i = 0, j = 0;
        for (; i < numRows; i++) {
        	res[i] = new StringBuilder();
        }
        
        i = 0;
        while (i < s.length()) {
            j = 0;
            while(j < numRows && i < s.length()) {
                res[j] = res[j].append(s.charAt(i));
                j++;
                i++;
            }
            j = numRows - 2;
            while (j > 0 && i < s.length()) {
                res[j] = res[j].append(s.charAt(i));
                j--;
                i++;
            }
        }
        
        StringBuilder ret = new StringBuilder();
        for (j = 0; j < numRows; j++) {
            ret.append(res[j]);
        }
        
        return ret.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = convert("ABC", 2);
		System.out.println(s);

	}

}
