package algorithms.sort.extras;

public class SquareRoot {
	
	public static int squareRoot(int k) {
		int low = 0;
		int high = k;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			int midSquared = mid*mid;
			
			if(midSquared==k) {
				return mid;
			} else if(midSquared<k) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		return (int)low-1;
	}
	
	public static void main(String[] args) {
		int squareRoot = squareRoot(300);
		System.out.println(squareRoot);
	}

}
