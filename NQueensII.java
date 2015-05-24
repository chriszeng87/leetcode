import java.util.ArrayList;
import java.util.List;


public class NQueensII {
	
    public static boolean check(String[] strArray, int cur) {
	if (cur == 0) {
		return true;
	}
    int[] arr = new int[cur + 1];
    int i = 0, j = 0;
    for (i = 0; i < arr.length; i++) {
        for (j = 0; j < strArray.length; j++) {
            if (strArray[i].charAt(j) == 'Q') {
                arr[i] = j;
            }
        }
    }
    
    for (i = 0; i <  arr.length ; i++) {
    	for (j = i + 1; j < arr.length; j++) {
            if((arr[i] == arr[j]) || Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
                return false;
            }
    	}
    }
    
    return true;
}

public static void recursive(int cur, List<String[]> lists, int n, String[] strArray) {
    if (cur == n) {
        //copy the array?
        String[] temp = new String[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            temp[i] = new String(strArray[i]);
        }
        lists.add(temp);
        return;
    }
    
    for (int i = 0; i < n; i++) {
        StringBuilder temp = new StringBuilder();
        int j = 0;
        for (j = 0; j < i; j++) {
            temp.append('.');
        }
        temp.append('Q');
        for (j = i + 1; j < n; j++) {
            temp.append('.');
        }
        strArray[cur] = temp.toString();
        if (check(strArray, cur)) {
            recursive(cur + 1, lists, n , strArray);
        }
    }
}

public int totalNQueens(int n) {
            List<String[]> lists = new ArrayList<String[]>();
    String[] array = new String[n];
    recursive(0, lists, n, array);
    return lists.size();
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
