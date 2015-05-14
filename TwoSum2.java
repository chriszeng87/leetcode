import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum2 {
    
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        if (nums == null || nums.length == 0) {
            return index;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
        	map.put(nums[i], i + 1);
        }
    
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int num1 = 0, num2 = 0;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                num1 = nums[i];
                num2 = nums[j];
                break;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        
        index[0] = map.get(num1);
        index[1] = map.get(num2); 
        
        if (index[0] > index[1]) {
            int tmp = index[0];
            index[0] = index[1];
            index[1] = tmp;
        }
        
        return index;
        
    }
    
    public int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        if (nums == null || nums.length == 0) {
            return index;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i ++) {
        	if (map.containsKey(target - nums[i])) {
        		index[0] = map.get(target - nums[i]) + 1;
        		index[1] = i + 1;
                return index;
        	} else {
        		map.put(nums[i],i);
        	}
        }
        
        return index;
        
    }
	
	public static void print(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		System.out.print("array = ");
		for (int i = 0; i <= array.length - 1; i++) {
			System.out.print("  " + array[i]);
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tmp = {2, 7, 11, 15};//{3,2,4};
		int[] result = twoSum(tmp, 9);
		
		print(tmp);
		print(result);
	}

}
