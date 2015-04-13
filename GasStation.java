/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to 

its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 * @author Chris
 *
 */
public class GasStation {
	
	static int getStartIndexOfGasStation(int[] gas, int[] cost) {
		
		int remain = 0;
		for (int start = 0; start < gas.length; start++) {
			if (gas[start] >= cost[start]) {
				remain = gas[start] - cost[start];
				int i = (start + 1) % gas.length;
				while(i != start) {
					if (remain + gas[i] >= cost[i]) {
						remain = remain + gas[i] - cost[i];
						i = (i + 1) % gas.length;
					} else {
						break;
					}
				}
				if (i == start) {
					return start;
				}
			}
			
		}
		
		return -1;
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int sumRemaining = 0; // track current remaining
		int total = 0; // track total remaining
		int start = 0; 
	 
		for (int i = 0; i < gas.length; i++) {
			int remaining = gas[i] - cost[i];
	 
			//if sum remaining of (i-1) >= 0, continue 
			if (sumRemaining >= 0) { 
				sumRemaining += remaining;
			//otherwise, reset start index to be current
			} else {
				sumRemaining = remaining;
				start = i;
			}
			total += remaining;
		}
	 
		if (total >= 0){
			return start;
		}else{
			return -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {1, 3, 2, 4, 5};
		
		System.out.println(getStartIndexOfGasStation(gas, cost));
		System.out.println(canCompleteCircuit(gas, cost));		

	}

}
