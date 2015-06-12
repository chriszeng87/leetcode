import java.util.Arrays;
import java.util.Comparator;


class NumComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		long l1 = Long.parseLong(s1 + s2);
		long l2 = Long.parseLong(s2 + s1);
		if (l1 > l2) {
			return -1;
		} else if (l1 < l2) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

public class LargestNumber2 {
	

	
    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums == null) {
            return sb.toString();
        }       

        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	strArray[i] = nums[i] + "";
        }
        Arrays.sort(strArray, new NumComparator());
        
        for (String num: strArray) {
            sb.append(num);
        }
        
        return sb.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {121, 12};
		String ret = largestNumber(nums);
		System.out.println("------ret = " + ret);
	}

}
