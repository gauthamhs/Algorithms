package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class EnclosedRegions {
	
	public static void enclosedRegions(char[][] board) {
		
		// do a column boundary marking.
		for(int i=0;i<board.length;i++) {
			markBoundary(i,0, board);
			markBoundary(i,board[0].length-1, board);
		}
		
		// do a row boundary marking
		for(int j=0;j<board[0].length;j++) {
			markBoundary(0,j, board);
			markBoundary(board.length-1,j, board);
		}
		
		// transform all the cells which are non-boundary related/not connected to boundaries.
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = (board[i][j]!='T') ? 'X':'O';
			}
		}
	
	}
	
	public static void markBoundary(int i, int j, char[][] board) {
		
		Deque<Coordinate> queue = new ArrayDeque<>();
		
		queue.add(new Coordinate(i,j));
		
		while(!queue.isEmpty()) {
			Coordinate currentCoordinate = queue.poll();
			
			if(currentCoordinate.x>=0 && currentCoordinate.x<board.length && 
			   currentCoordinate.y>=0 && currentCoordinate.y<board[0].length &&
			   board[currentCoordinate.x][currentCoordinate.y]=='O') {
				board[currentCoordinate.x][currentCoordinate.y]='T';
				queue.add(new Coordinate(currentCoordinate.x+1,currentCoordinate.y));
				queue.add(new Coordinate(currentCoordinate.x,currentCoordinate.y+1));
				queue.add(new Coordinate(currentCoordinate.x-1,currentCoordinate.y));
				queue.add(new Coordinate(currentCoordinate.x,currentCoordinate.y-1));
			}
				
		}
		
	}
	
	public static void main(String[] args) {
/*		char[][] board = { {'X','X','X','X'},
				           {'X','O','O','X'},
				           {'X','X','O','X'},
				           {'X','O','X','X'}};*/
		
		char[][] board = { {'O','O','O'},
		           {'O','O','O'},
		           {'O','O','O'},
		           {'O','O','O'}};
		
		System.out.println(Arrays.deepToString(board));
		
		enclosedRegions(board);
		
		System.out.println(Arrays.deepToString(board));
	}

}
