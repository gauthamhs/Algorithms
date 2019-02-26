package algorithms.datastructures.dynamicProgramming;

public class SubSetSum {
	
	// This is almost similar to the equal partition subset problem except that we are already given a sum, 
	// and need to check if a subset matches the given sum.
	
	public static Boolean canPartitionNaive(int[] array, int sum) {
		if(array == null || array.length==0) {
			return false;
		}
		return canPartitionNaiveHelper(array, sum, array.length-1);
	}
	
	public static boolean canPartitionNaiveHelper(int[] array, int sum, int currentIndex) {
		if(sum==0) {
			return true;
		}
		
		if(currentIndex<0) {
			return false;
		}
		
		Boolean excludeElement = canPartitionNaiveHelper(array, sum, currentIndex-1);
		Boolean includeElement = (array[currentIndex]>sum) 
				? false : canPartitionNaiveHelper(array, sum - array[currentIndex], currentIndex-1);
		
		Boolean canPartition = excludeElement || includeElement;
		return canPartition;
	}
	
	//Memoize
	
	public static Boolean canPartitionMemoize(int[] array, int sum) {
		if(array==null || array.length == 0) {
			return false;
		}
		
		Boolean[][] memoize = new Boolean[array.length][sum+1];
		
		return canPartitionMemoizeHelper(array, sum, array.length-1, memoize);
		
	}
	
	public static Boolean canPartitionMemoizeHelper(int[] array, int sum, int currentIndex, Boolean[][] memoize) {
		if(sum==0) {
			return true;
		}
		
		if(currentIndex<0) {
			return false;
		}
		
		if(memoize[currentIndex][sum]==null) {
			
			Boolean excludeElement = canPartitionMemoizeHelper(array, sum, currentIndex-1, memoize);
			Boolean includeElement = (array[currentIndex]>sum) ? false : 
				canPartitionMemoizeHelper(array, sum-array[currentIndex], currentIndex-1, memoize);
			memoize[currentIndex][sum] = includeElement || excludeElement;
			
		}
		
		return memoize[currentIndex][sum];
	
	}
	
	public static Boolean canPartitionBottomUp(int[] array, int sum) {
		if(array==null || array.length==0) {
			return false;
		}
		
		if(sum==0) {
			return true;
		}
		
		Boolean[] bottomUpMatrix = new Boolean[sum+1];
		bottomUpMatrix[0] = true;
		
		for(int i=1;i<=sum;i++) {
			bottomUpMatrix[i] = (array[0] == i) ? true : false;
		}
		
		int n = array.length-1;
		
		for(int k=0;k<=n;k++) {
			for(int s = sum; s>=0;s--) {
				Boolean excludeElement = bottomUpMatrix[s];
				Boolean includeElement = (array[k]>s) ? false : bottomUpMatrix[s-array[k]];
				bottomUpMatrix[s] = includeElement || excludeElement;
			}
		}
		
		return bottomUpMatrix[sum];
	}
	
	public static void main(String[] args) {
		int[] array = {10,1,4,5};
		
		Boolean canPartitionNaive1 = canPartitionNaive(array, 15);
		Boolean canPartitionNaive2 = canPartitionNaive(array, 17);
		System.out.println("Naive Recursion 1: " + canPartitionNaive1);
		System.out.println("Naive Recursion 2: " +canPartitionNaive2);
		
		Boolean canPartitionMemoize = canPartitionMemoize(array, 15);
		Boolean canPartitionMemoize2 = canPartitionMemoize(array, 17);
		System.out.println("Memoize 1 : " + canPartitionMemoize);
		System.out.println("Memoize 2 : " + canPartitionMemoize2);
		
		Boolean canPartitionBottomUp = canPartitionBottomUp(array, 15);
		Boolean canPartitionBottomUp2 = canPartitionBottomUp(array, 17);
		System.out.println("Bottom Up1: " + canPartitionBottomUp);
		System.out.println("Bottom Up2: " + canPartitionBottomUp2);
	}

}
