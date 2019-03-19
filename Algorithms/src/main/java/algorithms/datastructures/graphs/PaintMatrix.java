package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Coordinate{
	int x;
	int y;
	
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class PaintMatrix {
	
	public static void paintMatrix(int x, int y, int[][] matrix) {
		
		
		int value = matrix[x][y];
		int flipValue = (value==1) ? 0:1;
		matrix[x][y] = flipValue;
		
		Deque<Coordinate> queue = new ArrayDeque<>();
		queue.addLast(new Coordinate(x,y));
		
		while(!queue.isEmpty()) {
			Coordinate element = queue.element();
			int xCoordinate = element.x;
			int yCoordinate = element.y;
			
			Coordinate[] coordinates = {new Coordinate(xCoordinate+1,yCoordinate),
					                    new Coordinate(xCoordinate,yCoordinate+1),
					                    new Coordinate(xCoordinate-1,yCoordinate),
					                    new Coordinate(xCoordinate,yCoordinate-1)};
			
			for(Coordinate nextCoordinate: coordinates) {
				if(nextCoordinate.x>=0 && nextCoordinate.x<matrix.length
				   && nextCoordinate.y>=0 && nextCoordinate.y<matrix.length &&
				   matrix[nextCoordinate.x][nextCoordinate.y]==value) {
					matrix[nextCoordinate.x][nextCoordinate.y]=flipValue;
					queue.add(nextCoordinate);
				}
			}
			
			queue.remove();
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,0,1,0},
				          {0,1,0,0},
				          {0,0,1,0},
				          {0,0,1,0}};
		
		System.out.println(Arrays.deepToString(matrix));
		
		paintMatrix(3,1,matrix);
		
		System.out.println(Arrays.deepToString(matrix));
	}

}
