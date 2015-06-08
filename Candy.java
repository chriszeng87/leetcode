import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

 * @author Chris
 *
 */
public class Candy {
	
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        int i;
        for (i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        
        for (i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i -1]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1); 
            }
        }
        
        int sum = 0;
        for (i = 0; i < ratings.length; i++) {
            sum += candies[i];
        }
        
        return sum;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
