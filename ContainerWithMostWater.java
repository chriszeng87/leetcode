/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author Chris
 * 
 */
public class ContainerWithMostWater {

	// 直观的解释是：容积即面积，它受长和高的影响，当长度减小时候，
	//高必须增长才有可能提升面积，所以我们从长度最长时开始递减，然后寻找更高的线来更新候补；
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}

		int maxArea = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			maxArea = Math.max((j - i) * Math.min(height[j], height[i]),
					maxArea);
			if (height[j] > height[i]) {
				i++;
			} else {
				j--;
			}
		}

		return maxArea;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
