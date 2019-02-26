package algorithms.datastructures.dynamicProgramming;

public class CoinChangeCombinations {
	
	public static int maximumCombinationsCoinChangeNaive(int[] array, int totalChange) {
		if(array==null || array.length==0) {
			return 0;
		}
		
		return maximumCombinationsCoinChangeNaiveHelper(array, totalChange, array.length-1 );
	}
	
	public static int maximumCombinationsCoinChangeNaiveHelper(int[] array, int totalChange, int currentIndex) {
		if(totalChange==0) {
			return 1;
		}
		
		if(currentIndex<0) {
			return 0;
		}
		
		int excludeCoin = maximumCombinationsCoinChangeNaiveHelper(array, totalChange, currentIndex-1);
		int includeCoin = (array[currentIndex]>totalChange) ? 0: 
			maximumCombinationsCoinChangeNaiveHelper(array, totalChange-array[currentIndex], currentIndex);
		
		return excludeCoin + includeCoin;
	}
	
	public static int maximumCombinationsCoinChangeBottomUp(int[] array, int totalChange) {
		if(array==null || array.length==0 || totalChange==0) {
			return 0;
		}
		
		int[][] bottomUpMatrix = new int[array.length][totalChange+1];
		int n = array.length-1;
		
		
		//This would always be 1 since we would always have an empty set that would make up total change.
		for(int k=0;k<=n;k++) {
		bottomUpMatrix[k][0] = 1;
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=1;j<=totalChange;j++) {
				int excludeElement = 0;
				int includeElement = 0;
				if(i>0) {
				 excludeElement = bottomUpMatrix[i-1][j];	
				}
				 includeElement = (array[i]>j) ? 0 : bottomUpMatrix[i][j-array[i]];
				bottomUpMatrix[i][j] = includeElement + excludeElement;
			}
		}
		
		return bottomUpMatrix[n][totalChange];
		
		
	}
	

	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,20};
		int maxCombo = maximumCombinationsCoinChangeNaive(array, 30);
		System.out.println(maxCombo);
		
		int maxComboBottomUp = maximumCombinationsCoinChangeBottomUp(array, 30);
		System.out.println(maxComboBottomUp);
		
		
	}

}
