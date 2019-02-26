package algorithms.datastructures.dynamicProgramming;

public class EqualPartitionSubsetSum {
	
	
	// For this method, we see if an array that can be partitioned into two subsets will be equal to its
	// second counterpart. We first check if the sum is even. If not, there cannot be two equal subsets due
	// to which we return false. Second we pass the sum/2 and check if one of the subset is equal to sum/2.
	// If so, we return true because on of the subset matches the sum/2 and other counterpart will also be 
	// equal to sum/2.
	
	// Naive recursion. In this method, we perform a naive recursion by including and excluding the current element.
	
	public static boolean canPartitionNaive(int[] array) {

		if(array == null || array.length==0 ) {
			return false;
		}
		int sum = 0;
		for(int i : array) {
			sum +=  i;	
		}
		
		if(sum%2!=0) {
			return false;
		}
		
		return canPartitionSubsetHelper(array, sum/2, array.length-1);
	}
	
	public static boolean canPartitionSubsetHelper(int[] array, int sum, int currentIndex) {
		
		if(sum==0) {
			return true;
		}
		
		if(currentIndex<0) {
			return false;
		}
		
		// Exclude element at currentIndex
		boolean excludeElement = canPartitionSubsetHelper(array, sum, currentIndex-1);
		// Include element at currentIndex
		boolean includeElement = (array[currentIndex]>sum) ? false : canPartitionSubsetHelper(array, sum-array[currentIndex], currentIndex-1);
		
		return excludeElement || includeElement;
		
	}
	
	//Method 2: Memoization
	public static boolean canPartitionMemoize(int[] array) {
		if(array==null || array.length==0) {
			return false;
		}
		
		int sum = 0;
		for(int i: array) {
			sum += i;
		}
		
		if(sum%2!=0) {
			return false;
		}
		
		Boolean[][] memoize = new Boolean[array.length][sum/2 + 1];
		
		return canPartitionMemoizeHelper(array, sum/2, memoize, array.length-1);
	}
	
	public static boolean canPartitionMemoizeHelper(int[] array, int sum, Boolean[][] memoize, int currentIndex) {
		
		if(sum==0) {
			return true;
		}
		if(currentIndex<0) {
			return false;
		}
		
		if(memoize[currentIndex][sum]==null) {
			Boolean excludeElement = canPartitionMemoizeHelper(array, sum, memoize, currentIndex-1);
			Boolean includeElement = (array[currentIndex]>sum) ? false : canPartitionMemoizeHelper(array, sum-array[currentIndex], memoize, currentIndex-1);
			memoize[currentIndex][sum] = excludeElement || includeElement;
			 
		}
		
		return memoize[currentIndex][sum];
	}
	
	// Method 3: BottomDown Approach
	
	public static boolean canPartitionBottomDownApproach(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum+=i;
		}
		if(sum%2!=0) {
			return false;
		}
		
		sum /= 2;
		int n = array.length-1;
		
		Boolean[][] bottomUpMatrix = new Boolean[array.length][sum + 1];
		
		
		// Any number can be used to make sum 0.
		for(int i=0;i<=n;i++) {
			bottomUpMatrix[i][0] = true;
		}
		
		for(int j=0;j<=sum;j++) {
			bottomUpMatrix[0][j] = (array[0]==j) ? true : false;
		}
		
		for(int k=1;k<=n;k++) {
			for(int l=1;l<=sum;l++) {
				Boolean excludeItem = bottomUpMatrix[k-1][l];
				Boolean includeItem = (array[k]>l) ? false : bottomUpMatrix[k-1][l-array[k]];
				
				bottomUpMatrix[k][l] = excludeItem || includeItem;
			}
		}
		
		return bottomUpMatrix[n][sum];
	}
	
	public static Boolean canPartitionBottomDownEfficient(int[] array) {
		
		if(array==null || array.length == 0) {
			return false; 
		}
		
		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		
		if(sum%2!=0) {
			return false; 
		}
		
		sum /= 2;
		int n = array.length-1;
		
		Boolean[] bottomUpMatrix = new Boolean[sum + 1];
		
		bottomUpMatrix[0] = true;
		for(int i = 1;i<=sum;i++) {
			bottomUpMatrix[i] = (array[0]==i) ? true : false;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=sum;j>=0;j--) {
				Boolean excludeElement = bottomUpMatrix[j];
				Boolean includeElement = (array[i]>j) ? false : bottomUpMatrix[j-array[i]];
				bottomUpMatrix[j] = excludeElement || includeElement;
			}
		}
		return bottomUpMatrix[sum];
	}
	
	
	public static void main(String[] args) {
		int[] array1 = {1,1,5,7};
		int[] array2 = {1,2,3,8};
		
		boolean canPartition = canPartitionNaive(array1);
		boolean canPartition2 = canPartitionNaive(array2);
		System.out.println("Naive Recursion1: " + canPartition);
		System.out.println("Naive Recursion2: " + canPartition2);
		
		boolean canPartitionMemoize = canPartitionMemoize(array1);
		boolean canPartition2Memoize = canPartitionMemoize(array2);
		System.out.println("Memoize 1: " + canPartitionMemoize);
		System.out.println("Memoize 2: " + canPartition2Memoize);
		
		boolean canPartitionBottomDown = canPartitionBottomDownApproach(array1);
		boolean canPartition2BottomDown = canPartitionBottomDownApproach(array2);
		System.out.println("BottomDown1: " + canPartitionBottomDown);
		System.out.println("BottomDown2: " + canPartition2BottomDown);	
		
		boolean canPartitionBottomDownEfficient = canPartitionBottomDownEfficient(array1);
		boolean canPartition2BottomDownEfficient = canPartitionBottomDownEfficient(array2);
		System.out.println("BottomDownEfficient 1: " + canPartitionBottomDownEfficient);
		System.out.println("BottomDownEfficient 2: " + canPartition2BottomDownEfficient);	
		
		
	}

}
