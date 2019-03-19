package algorithms.sort.extras;

import java.util.Arrays;

public class SquareOfSortedArrays {
	
public static int[] sortedSquares(int[] A) {
        
        int i=0;
        int j=A.length-1;
        
        int[] B = new int[A.length];
        
        for(int k=A.length-1;k>=0;k--){
            
             if(Math.abs(A[i])>Math.abs(A[j])){
                B[k] = A[i]*A[i];
                i++;
            } else{
                 B[k] = A[j]*A[j];
                j--;
            }
            
        }
        
        return B;
        
    }
	
	public static void main(String[] args) {
		int[] array = {-7,-3,2,3,11};
		int[] squaredArray = sortedSquares(array);
		System.out.println(Arrays.toString(squaredArray));
	}

}
