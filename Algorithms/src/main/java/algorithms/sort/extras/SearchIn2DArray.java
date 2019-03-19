package algorithms.sort.extras;

public class SearchIn2DArray {
	
	public static boolean searchElementIn2dArray(int[][] matrix, int target) {
		
		if(matrix==null || matrix.length==0) {
			return false;
		}
		
		int row = 0;
		int column = matrix[0].length-1;
		
		while(row<matrix.length && column>=0) {
			if(matrix[row][column]==target) {
				return true;
			} else if(matrix[row][column]>target) {
				column--;
			} else {
				row++;
			}
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		//int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[][] matrix = {{1,1}};
		boolean isSearch = searchElementIn2dArray(matrix, 21);
		System.out.println(isSearch);
	}
	
}
