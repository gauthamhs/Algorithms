package algorithms.datastructures.arrays.extras;


/*The algorithm for this is quite simple: 
1) Get maximum height from the left
2) Get maximum height from the right
3) Calculate min(leftHeight, rightHeight) because thats the maximum volume of water it can hold without overflowing. Subtract it with the current elevation.

*/
public class TrappingRainWater {
	
	public static int trappingRainWater(int[] height) {
		
		int N = height.length;
		int maxWater = 0;
		
		int[] leftHeight = new int[N];
		int[] rightHeight = new int[N];
		
		leftHeight[0] = height[0];
		rightHeight[N-1] = height[N-1];
		
		for(int i=1;i<N;i++) {
			leftHeight[i] = Math.max(height[i], leftHeight[i-1]);
		}
		
		for(int j=N-2;j>=0;--j) {
			rightHeight[j] = Math.max(height[j], rightHeight[j+1]);
		}
		
		for(int k=1;k<N-1;k++) {
			maxWater+=Math.min(leftHeight[k],rightHeight[k])-height[k];
		}
		
		return maxWater;
		
	}
	
	public static void main(String[] args) {
		
		//int[] height = {4,2,0,3,2,5};
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int maxWater = trappingRainWater(height);
		System.out.println(maxWater);
	}

}
