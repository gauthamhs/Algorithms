package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;

public class TraverseNDArray {
	
	public static int totalWaysToTraverseArray(int m, int n) {
		int[][] memoize = new int[m][n];
		for(int[] mem : memoize) {
			Arrays.fill(mem, -1);
		}
		return totalWaysToTraverseArrayHelper(m, n, m-1, n-1, memoize);
	}
	
	public static int totalWaysToTraverseArrayHelper(int m, int n, int mPos, int nPos, int[][] memoize) {
		
		if(mPos==0 && nPos == 0) {
			return 1;
		}
		
		if(memoize[mPos][nPos]==-1) {
			int totalWaystoBottom = (mPos==0) ? 0 : totalWaysToTraverseArrayHelper(m, n, mPos-1, nPos, memoize);
			int totalWaysToRight = (nPos==0) ? 0 :totalWaysToTraverseArrayHelper(totalWaystoBottom, n, mPos, nPos-1, memoize);
			memoize[mPos][nPos] = totalWaystoBottom + totalWaysToRight;
		}
		
		return memoize[mPos][nPos];
	}
	
	public static boolean traverse2DArrayWithObstacles(int[][] twoArray) {
		
		int xLength=twoArray.length;
		int yLength = twoArray[0].length;
		
		if(twoArray==null || twoArray.length==0) {
			return false;
		}
		
		if(twoArray[0][0]==-1) {
			return false;
		}
		
		twoArray[0][0] = 1;
		
		for(int i=1;i<twoArray.length;i++) {
			twoArray[i][0] = (twoArray[i][0] != -1) ? twoArray[i-1][0] : 0;
		}
		
		for(int i=1;i<twoArray[0].length;i++) {
			twoArray[0][i] = (twoArray[0][i]!=-1) ? twoArray[0][i-1] : 0;
		}
		
		for(int i=1;i<twoArray.length;i++) {
			for(int j=1;j<twoArray.length;j++) {
				twoArray[i][j] = (twoArray[i][j] == -1) ? 0 : Math.max(twoArray[i][j-1], twoArray[i-1][j]);
			}
		}
		
		return twoArray[xLength-1][yLength-1]==1;
		
	}
	
	public static int traverse2DArrayWithObstaclesTotalWays(int[][] twoArray) {
		
		int xLength=twoArray.length;
		int yLength = twoArray[0].length;
		
		if(twoArray==null || twoArray.length==0) {
			return 0;
		}
		
		if(twoArray[0][0]==-1) {
			return 0;
		}
		
		twoArray[0][0] = 1;
		
		for(int i=1;i<twoArray.length;i++) {
			twoArray[i][0] = (twoArray[i][0] != -1) ? twoArray[i-1][0] : 0;
		}
		
		for(int i=1;i<twoArray[0].length;i++) {
			twoArray[0][i] = (twoArray[0][i]!=-1) ? twoArray[0][i-1] : 0;
		}
		
		int totalWays = 0;
		
		for(int i=1;i<twoArray.length;i++) {
			for(int j=1;j<twoArray.length;j++) {
				int xWays = (twoArray[i][j]==-1) ? 0: twoArray[i-1][j];
				int yWays = (twoArray[i][j]==-1) ? 0: twoArray[i][j-1];
				totalWays = xWays+yWays;
			}
		}
		
		return totalWays;
		
	}
	
	public static void main(String[] args) {
		
		int totalWays = totalWaysToTraverseArray(5, 5);
		System.out.println(totalWays);
		
		int[][] twoArray = new int[][] {{0,0,0,-1},{0,-1,-1,0},{0,0,0,0},{0,-1,0,0}};
		boolean isWayWithObstacles = traverse2DArrayWithObstacles(twoArray);
		System.out.println(isWayWithObstacles);
		
		int totalWaysWithObstacles =traverse2DArrayWithObstaclesTotalWays(twoArray);
		System.out.println(totalWaysWithObstacles);
		
		
	}

}
