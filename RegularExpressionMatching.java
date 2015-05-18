/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 * 
 * @author Chris
 * 
 */
public class RegularExpressionMatching {
	
    public static boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }
        
        if(s.length() == 0 && p.length() == 0) {
            return true;
        } else if (s.length() == 0 && p.length() == 2 && p.charAt(1) == '*') {
        	return true;
        }else if (p.length() == 0) {
            return false;
        }
        
        int i;
        if (p.charAt(0) == '.') {
            if(p.length() > 1) {
                if (p.charAt(1) == '*') {
                    for (i = 0; i < s.length(); i++) {
                        if (isMatch(s.substring(i), p.substring(2))
                        		|| p.substring(2).equals("")) {
                            return true;
                        }
                    }
                    return false;
                } else {
                	if (s.equals("")) {
                		return false;
                	}
                    return isMatch(s.substring(1), p.substring(1));
                }
            } else if(s.length() == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            // if(s.charAt(0) != p.charAt(0)) {
            //     return false;
            // }
            
            if(p.length() > 1) {
                if (p.charAt(1) == '*') {
                    i = 0;
                    while(i < s.length() && s.charAt(i) == p.charAt(0)) {
                        if(isMatch(s.substring(i), p.substring(2))) {// || p.substring(2).equals("")) {
                            return true;
                        }
                        i++;
                    }
                    if (i < s.length()) {
                    	return isMatch(s.substring(i), p.substring(2));
                    }
                    if (p.substring(2).equals("")) {
                    	return true;
                    }
                    if (isMatch(s, p.substring(2))) {
                    	return true;
                    }
                    return false;
                } else {
                    return (s.charAt(0) == p.charAt(0)) && (isMatch(s.substring(1), p.substring(1)));
                }
            } else if (s.length() > 1) {
                return false;
            } else {
            	if (s.length() == 1) {
            		return s.charAt(0) == p.charAt(0);
            	} else {
            		return false;
            	}
            }
        }
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aa","a")); //false;
		System.out.println(isMatch("aa","aa")); //true
		System.out.println(isMatch("aaa","aa")); //false
		System.out.println(isMatch("aa","a*")); //true
		System.out.println(isMatch("aa",".*")); //true
		System.out.println(isMatch("ab",".*"));	//true
//		"aab", "c*a*b"
		System.out.println(isMatch("aaa","ab*ac*a")); //true		
		System.out.println(isMatch("a","ab*"));	 //true
		System.out.println(isMatch("bbab","b*a*"));	//false
		System.out.println(isMatch("","c*c*")); //true
		System.out.println(isMatch("aaa","aaaa")); //true
//		"aabcbcbcaccbcaabc", 
//		".*a*aa*.*b*.c*.*a*"
		System.out.println(isMatch("aabcbcbcaccbcaabc",".*a*aa*.*b*.c*.*a*")); //true
	
	}

}
