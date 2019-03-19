package algorithms.sort.extras;

public class GameOfComway {
	
	public static int[][] gameOfComway(int[][] grid) {
				
		if(grid==null || grid.length==0) {
			return new int[0][0];
		}
		
		int rows = grid.length;
		int columns = grid[0].length;
		
		
		
		int[][] nextGenerationGrid = new int[rows][columns];
		
		for(int i=1;i<rows-1;i++) {
			for(int j=1;j<columns-1;j++) {
				
				int aliveNeighbors = 0;
				
				for(int k=-1;k<=1;k++) {
					for(int l=-1;l<=1;l++) {
						
						//Count all alive neighbors;
						aliveNeighbors += grid[i+k][j+l];
					}
				}
						
						// Exclude the cell that we are looking at since we are only interested in neighbors;
						aliveNeighbors -= grid[i][j];
						
						//Check for dead/alive conditions;
						
						if(grid[i][j]==1 && aliveNeighbors<2) { // Underpopulation
							nextGenerationGrid[i][j] = 0;
						} else if(grid[i][j]==1 && aliveNeighbors>3) { // Overpopulation
							nextGenerationGrid[i][j] = 0;
						} else if(grid[i][j]==0 && aliveNeighbors==3) {
							nextGenerationGrid[i][j] = 1; // Reproduction
						} else {
							nextGenerationGrid[i][j] = grid[i][j]; // Everything stays the same, stasis.
						}
						
					}
				}
		
		return nextGenerationGrid;
		
	}
	
	public static void main(String[] args) {
		
        // Initializing the grid. 
        int[][] grid = new int[][]{{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
                                   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }}; 
        
         System.out.println("Old generation");
         for(int i=0;i<grid.length;i++) {
        	 for(int j=0;j<grid[0].length;j++) {
        		 if(grid[i][j]==0) {
        			 System.out.print(".");
        		 }else {
        			 System.out.print("*");
        		 }
        	 }
        	 System.out.println();
         }
        
        int[][] nextState = gameOfComway(grid);
        System.out.println();
        System.out.println("New generation");
        for(int i=0;i<nextState.length;i++) {
       	 for(int j=0;j<nextState[0].length;j++) {
    		 if(nextState[i][j]==0) {
    			 System.out.print(".");
    		 }else {
    			 System.out.print("*");
    		 }
    	 }
    	 System.out.println();
       		 
       	 }
        }
	}


