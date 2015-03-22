import java.util.ArrayList;
import java.util.List;

/*
 * 给一个String, 比如abc, 列出所有字母的combination,比如a,b,c,ab,ac,bc,abc,bac,
 * bca,cab,cba,请用递归实现
 */


public class GetAllCombination {
	
	static List<String> getAllCombinations(String s, int index) {
		if (s == null) {
			return null;
		}
		List<String> allCombinations = new ArrayList<String>();
		if (index == s.length()) {
			return allCombinations;
		}
		
		String insertChar = s.substring(index, index +1);
		allCombinations.add(insertChar);
		List<String> remainCombinations = getAllCombinations(s, index + 1);
		if (remainCombinations.size() > 0) {
			allCombinations.addAll(remainCombinations);
			for (String temp: remainCombinations) {
				allCombinations.add(insertChar + temp);
				allCombinations.add(temp + insertChar);
				if (temp.length() >= 2) {
					for (int i = 0; i < temp.length() -1; i++) {
						String temp2 = temp.substring(0, i + 1) + insertChar +
								temp.substring(i+1, temp.length());
						allCombinations.add(temp2);
					}
				}
			}
		}
		
		return allCombinations;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abc";
		List<String> combinations = getAllCombinations(s,0);
		System.out.println(combinations);

	}

}
