import java.util.Arrays;


public class TwoSum2 {
	
    public static int findIndex(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == val) {
                return mid;
            } else if (nums[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        if (nums == null || nums.length == 0) {
            return index;
        }
        int[] numsclone = nums.clone();
    
        Arrays.sort(numsclone);
        int i = 0, j = numsclone.length - 1;
        int num1 = 0, num2 = 0;
        while (i < j) {
            if (numsclone[i] + numsclone[j] == target) {
                num1 = numsclone[i];
                num2 = numsclone[j];
                break;
            } else if (numsclone[i] + numsclone[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        
        index[0] = findIndex(nums, num1) + 1;
        index[1] = findIndex(nums, num2) + 1; 
        
        if (index[0] > index[1]) {
            int tmp = index[0];
            index[0] = index[1];
            index[1] = tmp;
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
