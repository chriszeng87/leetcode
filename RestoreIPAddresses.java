import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author Chris
 * 
 */
public class RestoreIPAddresses {

	public static void getPart(String str, int count, int index, List<String> list,
			StringBuilder newStr) {
		if (count == 3) {
			if (index < str.length() && str.length() - index <= 3) {
				if (Integer.parseInt(str.substring(index)) >= 256) {
					return;
				}
				if (str.charAt(index) == '0' && index < str.length() - 1) {
					return;
				}
				newStr.append(str.substring(index));
				list.add(newStr.toString());
			}
			return;
		}
		
		if (index >= str.length() ) {
			return;
		}

		int maxLen = 3;
		if (str.charAt(index) == '0') {
			maxLen = 1;
		}
		for (int i = 1; i <= maxLen; i++) {
            if (index + i > str.length()) {
                continue;
            }
            
			if (Integer.parseInt(str.substring(index, index + i)) >= 256) {
				continue;
			}
			
			StringBuilder tempStr = new StringBuilder(newStr);
			tempStr.append(str.substring(index, index
					+ i));

			tempStr.append('.');
			getPart(str, count + 1, index + i, list, tempStr);
		}
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		if (s == null || s.length() < 4) {
			return list;
		}

		StringBuilder sb = new StringBuilder();
		getPart(s, 0, 0, list, sb);
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ret = restoreIpAddresses("0000");
		System.out.println("------ret = " + ret);
		
		List<String> ret2 = restoreIpAddresses("010010");
		System.out.println("------ret = " + ret2);
		
		List<String> ret3 = restoreIpAddresses("1111");
		System.out.println("------ret = " + ret3);
	}

}
