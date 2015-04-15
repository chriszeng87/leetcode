import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * @author Chris
 *
 */
public class RepeatedDNASequences {
	
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> ret = new ArrayList<String>();
        if (s == null || s.length() < 10) {
        	return ret;
        }
        
        Set<String> temp = new HashSet<String>();
    	Set<String> added = new HashSet<String>();
        for (int i = 0; i < s.length() - 10; i++) {
        	String str = s.substring(i, i + 10);
        	if (temp.contains(str) && !added.contains(str)) {
        		ret.add(str);
        		added.add(str);
        	} else{
        		temp.add(str);
        	}
        }
        return ret;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = new String("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.println("return array = " + findRepeatedDnaSequences(s));

	}

}
