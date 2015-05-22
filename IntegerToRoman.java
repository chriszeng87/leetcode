/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Chris
 * 
 */
public class IntegerToRoman {
	
    public String intToRoman(int num) {
        StringBuilder ret = new StringBuilder();
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40,  10,  9,  5,   4, 1};
        String[] symbol = {"M", "CM","D",  "CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i = 0; num != 0; i++) {
            while(num >= value[i]) {
                num = num - value[i];
                ret.append(symbol[i]);
            }
        }
        return ret.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
