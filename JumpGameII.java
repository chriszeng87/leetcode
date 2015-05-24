/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @author Chris
 * 
 */
public class JumpGameII {

	public static int jump(int[] nums) {
		int ret = 0;// 当前跳数
		int last = 0;// 上一跳可达最远距离
		int curr = 0;// 当前一跳可达最远距
		for (int i = 0; i < nums.length; ++i) {
			// 无法向前继跳直接返回
			if (i > curr) {
				return -1;
			}
			// 需要进行下次跳跃，则更新last和当执行的跳数ret
			if (i > last) {
				last = curr;
				++ret;
			}
			// 记录当前可达的最远点
			curr = Math.max(curr, i + nums[i]);
		}

		return ret;
	}
	
    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < nums.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (nums[i] + i > farthest) {
                    farthest = nums[i] + i;
                }
            }
            start = end + 1;
            System.out.println("------start = " + start);
            end = farthest;
            System.out.println("------end = " + end);
        }
        return jumps;

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,1,4,1};
		System.out.println("------ "  + jump2(nums));
		
		//at least one step   1 2 
		//at least two step   3 4
		//at least three stop  5 6 7 8
	}

}
