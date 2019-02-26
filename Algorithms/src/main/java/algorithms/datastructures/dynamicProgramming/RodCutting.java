package algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

class Rod{
	int length;
	int value;
	
	public Rod(int length, int value) {
		this.length = length;
		this.value = value;
	}
	
}

public class RodCutting {
	
	public static int maximizeProfitFromRodCuttingNaive(List<Rod> rods, int totalRodLength) {
		
		if(rods == null || rods.size()==0 || totalRodLength==0) {
			return 0;
		}
		
		return maximizeProfitFromRodCuttingNaiveHelper(rods, totalRodLength, rods.size()-1);
		
	}
	
	public static int maximizeProfitFromRodCuttingNaiveHelper(List<Rod> rods, int totalRodLength, int currentIndex) {
		if(currentIndex<0) {
			return 0;
		}
		
		int excludeElement = maximizeProfitFromRodCuttingNaiveHelper(rods, totalRodLength, currentIndex-1);
		int includeElement = (rods.get(currentIndex).length>totalRodLength) ? 0 : rods.get(currentIndex).value + 
				maximizeProfitFromRodCuttingNaiveHelper(rods, totalRodLength - rods.get(currentIndex).length, currentIndex);
		
		return Math.max(includeElement, excludeElement);
	}
	
	public static int maximumProfitFromRodCuttingMemoize(List<Rod> rods, int totalRodLength) {
		if(rods == null || rods.size()==0 || totalRodLength==0) {
			return 0;
		}
		
		Integer[][] memoize = new Integer[rods.size()][totalRodLength + 1];
		
		return maximumProfitFromRodCuttingMemoizeHelper(rods, totalRodLength, rods.size() -1, memoize );
		
	}
	
	public static int maximumProfitFromRodCuttingMemoizeHelper(List<Rod> rods, int totalRodLength, int currentIndex, Integer[][] memoize) {
		if(currentIndex<0) {
			return 0;
		}
		
		if(memoize[currentIndex][totalRodLength] == null) {
			int excludeElement = maximumProfitFromRodCuttingMemoizeHelper(rods, totalRodLength, currentIndex-1, memoize);
			int includeElement = (rods.get(currentIndex).length>totalRodLength) ? 0 : 
				rods.get(currentIndex).value + 
				maximumProfitFromRodCuttingMemoizeHelper(rods, totalRodLength - rods.get(currentIndex).length, currentIndex, memoize);
			memoize[currentIndex][totalRodLength] = Math.max(includeElement, excludeElement);
		}
		
		return memoize[currentIndex][totalRodLength];
	}
	
	public static int maximumProfitRodCuttingBottomUpApproach(List<Rod> rods, int totalRodLength) {
		
		if(rods == null || rods.size()==0 || totalRodLength==0) {
			return 0;
		}
		
		int[][] bottomUpMatrix = new int[rods.size()][totalRodLength+1];
		
			for(int k=0;k<rods.size();k++) {
				bottomUpMatrix[k][0] = 0;
			}
		
		int n = rods.size()-1;
		
		for(int i=0;i<=n;i++) {
			for(int r=1;r<=totalRodLength;r++) {
				int excludeElement = 0;
				int includeElement = 0;
				
				if(i>0) {
				 excludeElement = bottomUpMatrix[i-1][r];
				}
				
				 includeElement = (rods.get(i).length>r) ? 0 : rods.get(i).value + bottomUpMatrix[i][r - rods.get(i).length]; 
				bottomUpMatrix[i][r] = Math.max(excludeElement, includeElement);
			}
		}
		
		return bottomUpMatrix[n][totalRodLength];
	}
	
	public static void main(String[] args) {
		
		Rod rod1 = new Rod(1, 2);
		Rod rod2 = new Rod(2, 6);
		Rod rod3 = new Rod(3, 7);
		Rod rod4 = new Rod(4, 10);
		Rod rod5 = new Rod(5, 13);
		
		List<Rod> rods = new ArrayList<>();
		rods.add(rod1);
		rods.add(rod2);
		rods.add(rod3);
		rods.add(rod4);
		rods.add(rod5);
		
		int maximumProfitNaive = maximizeProfitFromRodCuttingNaive(rods, 5);
		System.out.println(maximumProfitNaive);
		
		int maximumProfitMemoize = maximumProfitFromRodCuttingMemoize(rods, 5);
		System.out.println(maximumProfitMemoize);
		
     	int maximumProfitBottomUp = maximumProfitRodCuttingBottomUpApproach(rods, 5);
		System.out.println(maximumProfitBottomUp);
	}

}
