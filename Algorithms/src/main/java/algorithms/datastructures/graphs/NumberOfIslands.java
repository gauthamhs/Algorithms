package algorithms.datastructures.graphs;

public class NumberOfIslands {
	
    public static int numIslands(char[][] grid) {
    	
    	if(grid==null || grid.length==0) {
    		return 0;
    	}
    
        int islands = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        
        for(int i=0;i<rows;i++) {
        	for(int j=0;j<columns;j++) {
        		if(grid[i][j]=='1') {
        			++islands;
        			dfs(i,j,grid);
        		}
        	}
        }
        
        return islands;
    }
    
    public static void dfs(int row, int column, char[][] grid) {
    	
    	if(row<0 || row>=grid.length || column<0 || column>=grid[0].length || grid[row][column]=='0') {
    		return;
    	}
    	
    	grid[row][column] = '0';
    	
    	dfs(row-1,column,grid);
    	dfs(row+1,column,grid);
    	dfs(row,column-1,grid);
    	dfs(row,column+1,grid);	
    }
	
	public static void main(String[] args) {
		
		char[][] grid = {{'1','1','1','1','0'},
				         {'1','1','0','1','0'},
				         {'1','1','0','0','0'},
				         {'0','0','0','0','0'}};
		
		int islands = numIslands(grid);
		System.out.println(islands);
		
	}

}
