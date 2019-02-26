package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class StaircaseProblem {
	
	public static int totalWaysToReachStairCaseNaive(int finalStep, List<Integer> stepsWeCanTake) {
		if(finalStep==0 || finalStep==1) {
			return 1;
		}
		
		int totalWays = 0;
		
		for(Integer step : stepsWeCanTake) {
			
			if(finalStep-step>=0) {
			totalWays += totalWaysToReachStairCaseNaive(finalStep - step , stepsWeCanTake);
			}
		}
		return totalWays;
	}
	
	public static int totalWaystoReachStairsMemoize(int finalStep,List<Integer> stepsWeCanTake) {
		int[] memoize = new int[finalStep+1];
		return totalWaystoReachStairsMemoizeHelper(finalStep, stepsWeCanTake, memoize);
	}
	
	public static int  totalWaystoReachStairsMemoizeHelper(int finalStep, List<Integer> stepsWeCanTake, int[] memoize) {
		
		if(finalStep==0 || finalStep==1) {
			return 1;
		}
		
		if(memoize[finalStep]==0) {
		
		for(Integer step : stepsWeCanTake) {
			
			if(finalStep-step>=0) {
			memoize[finalStep] += totalWaysToReachStairCaseNaive(finalStep - step , stepsWeCanTake);
			}
		}
		}
		return memoize[finalStep];
		
		 
	}
	
	public static int totalWaysToReachStairsBottomUp(int finalStep,List<Integer> stepsWeCanTake) {
		int[] bottomUpMatrix = new int[finalStep+1];
		bottomUpMatrix[0]=1;
		bottomUpMatrix[1]=1;
		
		for(int i=2;i<=finalStep;i++) {
			for(int j: stepsWeCanTake) {
				bottomUpMatrix[i] += (i-j<0) ? 0 : bottomUpMatrix[i-j];
			}
			}
		
		return bottomUpMatrix[finalStep];
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3};
		List<Integer> stepsWeCanTake = Arrays.asList(arr);
		int totalWaysNaive = totalWaysToReachStairCaseNaive(4, stepsWeCanTake);
		System.out.println(totalWaysNaive);
		
		int totalWaysMemoize = totalWaystoReachStairsMemoize(4, stepsWeCanTake);
		System.out.println(totalWaysMemoize);
		
		int totalWaysBottomUp = totalWaysToReachStairsBottomUp(4, stepsWeCanTake);
		System.out.println(totalWaysBottomUp);
	}

}
