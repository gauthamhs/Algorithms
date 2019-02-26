package algorithms.datastructures.dynamicProgramming;

public class HouseThief {
	
	public static int maximizeProfitFromStealing(int[] houses) {
		return maximizeProfitFromStealingHelper(houses, 0);
	}
	
	public static int maximizeProfitFromStealingHelper(int[] houses, int currentIndex) {
		if(currentIndex>=houses.length) {
			return 0;
		}
		
		int excludeHouse = maximizeProfitFromStealingHelper(houses, currentIndex+1);
		int includeHouse = maximizeProfitFromStealingHelper(houses, currentIndex+2) + houses[currentIndex];
		
		return Math.max(excludeHouse, includeHouse);
	}
	
	public static int maximizeProfitFromStealingBottomUp(int[] houses) {
		
		if(houses==null || houses.length == 0) {
			return 0;
		}
		
		if(houses.length<=2) {
			return (houses.length==1) ? houses[0] : Math.max(houses[0], houses[1]);
		}
		
		int[] bottomUpMatrix = new int[houses.length];
		bottomUpMatrix[0] = houses[0];
		bottomUpMatrix[1] = Math.max(houses[0], houses[1]);
	
		for(int i=2;i<houses.length;i++) {
			bottomUpMatrix[i] = Math.max(bottomUpMatrix[i-1], bottomUpMatrix[i-2] + houses[i]);
		}
		
		return bottomUpMatrix[houses.length-1];
	}
	
	public static void main(String[] args) {
		
		int[] array = {2, 5, 1, 3, 6, 2, 4};
		int profitNaive = maximizeProfitFromStealing(array);
		System.out.println(profitNaive);
		
		int profitBottomUp = maximizeProfitFromStealingBottomUp(array);
		System.out.println(profitBottomUp);
	}

}
