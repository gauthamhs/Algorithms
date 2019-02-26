package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;

public class MinimumNoOfCoins {
	
	public static int minCoinsNeededNaive(int[] array, int totalChange) {
		return minCoinsNeededNaiveHelper(array, totalChange, array.length-1) == Integer.MAX_VALUE ? -1 : 
			minCoinsNeededNaiveHelper(array, totalChange, array.length-1);
	}
	
	public static int minCoinsNeededNaiveHelper(int[] array, int totalChange, int currentIndex) {
		
		if(totalChange==0) {
			return 0;
		}
		
		if(currentIndex<0) {
			return Integer.MAX_VALUE;
		}
		
		int excludeElement = minCoinsNeededNaiveHelper(array, totalChange, currentIndex-1);
		int includeElement = (array[currentIndex]>totalChange) ? Integer.MAX_VALUE : minCoinsNeededNaiveHelper(array, totalChange-array[currentIndex], currentIndex);
		if(includeElement!=Integer.MAX_VALUE) {
			includeElement += 1;
		}
				
	    int minCoinsNeeded = Math.min(excludeElement, includeElement);
	    
	    return minCoinsNeeded;
	}
	
	public static int minCoinsNeededBottomUp(int[] array, int totalChange) {
		if(array==null || array.length==0 || totalChange==0) {
			return -1;
		}
		
		int[][] bottomUpMatrix = new int[array.length][totalChange+1];
		for(int[] i : bottomUpMatrix) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		
		int n =array.length-1;
		
		for(int k=0;k<=n;k++) {
			bottomUpMatrix[k][0] = 0;
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=1;j<=totalChange;j++) {
				int excludeCoin = Integer.MAX_VALUE;
				int includeCoin = Integer.MAX_VALUE;
				
				if(i>0) {
				 excludeCoin = bottomUpMatrix[i-1][j];
				}
				
				 includeCoin = (array[i]>j) ? Integer.MAX_VALUE : bottomUpMatrix[i][j-array[i]];
				if(includeCoin!=Integer.MAX_VALUE) {
					includeCoin += 1;
				}
				bottomUpMatrix[i][j] = Math.min(includeCoin,excludeCoin);
			}
		}
		
		return bottomUpMatrix[n][totalChange] == Integer.MAX_VALUE ? -1 : bottomUpMatrix[n][totalChange];
		
		
		}
	
	public static void main(String[] args) {
		int[] array = {1,2,3};
		int minCoinsNeeded1 = minCoinsNeededNaive(array, 11);
		System.out.println(minCoinsNeeded1);
		
		int minCoinsNeeded2 = minCoinsNeededBottomUp(array, 11);
		System.out.println(minCoinsNeeded2);
		
		
	}

}
