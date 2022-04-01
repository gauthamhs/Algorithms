package algorithms.sort.extras;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

public static int[] sortedSquaresStack(int[] A) {
	Deque<Integer> stack = new ArrayDeque<>();
	int[] result = new int[A.length];
	
	int i=0;
	while(A[i]<0) {
		stack.addFirst(A[i]);
		i++;
	}
	int k=0;
	while(i<A.length) {
		if(stack.isEmpty() || Math.abs(stack.peek())>A[i]) {
			result[k++] = A[i]*A[i];
			i++;
		}else {
			Integer element = stack.removeFirst();
			result[k++] = element*element;
		}
	}
	
	return result;
}
	
	public static void main(String[] args) {
		int[] array = {-9,-6,5,12,14};
		int[] squaredArray = sortedSquares(array);
		System.out.println(Arrays.toString(squaredArray));
		System.out.println(Arrays.toString(sortedSquaresStack(array)));
	}

}
