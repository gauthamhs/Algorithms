package algorithms.datastructures.dynamicProgramming;

public class StaircaseProblemMinFee {
	
	public static int minFeeClimbingCost(int[] cost) {
		
		int previousTwoCost = cost[0]; // If you climb one or two steps, you have to pay the fee.
		int previousOneCost = cost[1];
		
		int currentCost = 0;
		
		for(int i=2;i<cost.length;i++) {
			currentCost = cost[i] + Math.min(previousOneCost, previousTwoCost);
			previousTwoCost = previousOneCost;
			previousOneCost = currentCost;
		}
		
		return Math.min(previousOneCost,previousTwoCost);
		
	}
	
	public static void main(String[] args) {
		
		int[] fee = {10,15,20};
		int minFee = minFeeClimbingCost(fee);
		System.out.println(minFee);
		int[] fee2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int minFee2 = minFeeClimbingCost(fee2);
		System.out.println(minFee2);
	}

}
