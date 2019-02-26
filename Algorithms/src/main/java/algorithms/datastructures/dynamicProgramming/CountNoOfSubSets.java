package algorithms.datastructures.dynamicProgramming;

public class CountNoOfSubSets {
	
	public static int countNoOfSubsetsNaive(int[] array, int sum) {
		
		if(array==null || array.length==0) {
			return -1;
		}
		
		return countNoOfSubsetsNaiveHelper(array, sum, array.length-1);
		
	}
	
	public static int countNoOfSubsetsNaiveHelper(int[] array, int sum, int currentIndex) {
		if(sum==0) {
			return 1;
		}
		
		if(currentIndex<0) {
			return 0;
		}
		
		int sumWithoutElement = countNoOfSubsetsNaiveHelper(array, sum, currentIndex-1);
		int sumWithElement = (array[currentIndex]>sum) ? 0 : countNoOfSubsetsNaiveHelper(array, sum - array[currentIndex], currentIndex-1);
		int totalSubsets = sumWithoutElement + sumWithElement;
		
		return totalSubsets;
		
	}
	
	public static int countNoOfSubsetsMemoize(int[] array, int sum) {
		if(array == null || array.length==0) {
			return -1;
		}
		
		Integer[][] memoize = new Integer[array.length][sum + 1];
		
		return countNoOfSubsetsMemoizeHelper(array, sum, memoize, array.length-1);
		
	}
	
	public static int countNoOfSubsetsMemoizeHelper(int[] array, int sum, Integer[][] memoize, int currentIndex) {
		
		if(sum==0) {
			return 1;
		}
		
		if(currentIndex<0) {
			return 0;
		}
		
		if(memoize[currentIndex][sum] == null) {
			int subsetCountWithoutElement = countNoOfSubsetsMemoizeHelper(array, sum, memoize, currentIndex-1);
			int subsetCountWithElement = (array[currentIndex]>sum) ? 0 : 
				countNoOfSubsetsMemoizeHelper(array, sum-array[currentIndex], memoize, currentIndex-1);
			
			memoize[currentIndex][sum] = subsetCountWithElement + subsetCountWithoutElement;
		}
		
		return memoize[currentIndex][sum];
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] array = {4, 3, 2, 3, 5, 2, 1};
		int totalSubsetNaive = countNoOfSubsetsNaive(array, 5);
		System.out.println(totalSubsetNaive);
		
		int totalSubsetMemoize = countNoOfSubsetsMemoize(array, 5);
		System.out.println(totalSubsetMemoize);
	}

}
