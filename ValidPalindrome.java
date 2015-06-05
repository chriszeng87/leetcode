
public class ValidPalindrome {
	
    public boolean isChar(char c) {
        if ((c - 'a' >= 0 && c - 'z' <= 0)
            || (c - 'A' >= 0 && c - 'Z' <= 0)
            || (c - '0' >= 0 && c - '9' <= 0)) {
            return true;        
        } else {
            return false;
        }
    }
    
    public boolean charEquals(char a, char b) {
        StringBuilder str1 = new StringBuilder();
        str1.append(a);
        StringBuilder str2 = new StringBuilder();
        str2.append(b);
        return str1.toString().toLowerCase().equals(str2.toString().toLowerCase());
    }
    
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (isChar(s.charAt(i)) && isChar(s.charAt(j))) {
                if(!charEquals(s.charAt(i),s.charAt(j))) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            } else if(!isChar(s.charAt(i))) {
                i++;
            } else {
                j--;
            }
        }
        
        return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
