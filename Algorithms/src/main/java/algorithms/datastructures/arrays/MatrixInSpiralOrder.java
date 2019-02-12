package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class MatrixInSpiralOrder {
	
	public static List<Integer> getMatrixElementsInSpiralOrder(List<List<Integer>> matrix){
		List<Integer> matrixInSpiral = new ArrayList<>();
		int x = 0, y=0, direction = 0;
		int[][] SHIFT = {{0,1},{1,0},{0,-1},{-1,0}};
		
		for(int i=0;i<(matrix.size() * matrix.size());i++) {
			matrixInSpiral.add(matrix.get(x).get(y));
			matrix.get(x).set(y, 0);
			
			int nextX = x + SHIFT[direction][0];
			int nextY = y + SHIFT[direction][1];
			
			if(nextX<0 || nextX>=matrix.size() || nextY<0 || nextY>=matrix.size() || matrix.get(nextX).get(nextY)==0) {
				direction = (direction+1)%4;
				nextX = x + SHIFT[direction][0];
				nextY = y + SHIFT[direction][1];
			}
			x = nextX;
			y = nextY;
		}
		return matrixInSpiral;
		
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		list3.add(7);
		list3.add(8);
		list3.add(9);
		
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(list1);
		matrix.add(list2);
		matrix.add(list3);
		
		List<Integer> matrixInSpiral = getMatrixElementsInSpiralOrder(matrix);
		System.out.println(printArray(matrixInSpiral));
			
	}
	
	public static String printArray(List<Integer> arrayOfIntegers){

		StringBuilder sb = new StringBuilder("");
		for(int i = 0;i<=arrayOfIntegers.size()-1;i++){
		sb.append(arrayOfIntegers.get(i));
		if(i<arrayOfIntegers.size() - 1){
		sb.append(", ");
		}
		}
		return sb.toString();

		}


}
