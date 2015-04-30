/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 * 
 * @author Chris
 * 
 */
public class ReverseBits {

	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		int ret = 0;
		int count = 0;
		while (count < 32) {
			int cur = (n & 1);
			ret = (ret << 1) + cur;
			n = n >> 1;
			count++;
		}

		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
