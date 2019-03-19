package algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Attempts{
	
	public Integer x;
	public Integer y;
	public Integer offset;
	
	public Attempts(Integer x, Integer y, Integer offset) {
		this.x = x;
		this.y = y;
		this.offset = offset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offset == null) ? 0 : offset.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attempts other = (Attempts) obj;
		if (offset == null) {
			if (other.offset != null)
				return false;
		} else if (!offset.equals(other.offset))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
}

public class FindSequenceIn2DArray {
	
	public static boolean findSequencein2dArray(List<List<Integer>> grid, List<Integer> pattern) {
		for(int i=0;i<grid.size();i++) {
			for(int j=0;j<grid.get(i).size();j++) {
				if(doesContainPatternInGrid(grid, pattern, i, j, 0, new HashSet<>())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean doesContainPatternInGrid(List<List<Integer>> grid, List<Integer> pattern, 
			                                      int x, int y, int offset, Set<Attempts> previousAttempts) {
		
		if(offset==pattern.size()) {
			return true;
		}
		
		// Check for Boundary Cases.
		if(x<0 || x>=grid.size() || y<0 || y>=grid.get(x).size() || 
		 previousAttempts.contains(new Attempts(x, y, offset)) || !grid.get(x).get(y).equals(pattern.get(offset)) ) {
			return false;
		}
		
		// Traverse in all directions to find the pattern.
		if(doesContainPatternInGrid(grid, pattern, x+1, y, offset+1, previousAttempts) ||
		   doesContainPatternInGrid(grid, pattern, x, y+1, offset+1, previousAttempts) ||
		   doesContainPatternInGrid(grid, pattern, x-1, y, offset+1, previousAttempts) ||
		   doesContainPatternInGrid(grid, pattern, x, y-1, offset+1, previousAttempts)) {
			return true;
		}
		
		// if not found, add it to previous attempt.
		previousAttempts.add(new Attempts(x,y,offset));
		return false;
		
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(Arrays.asList(new Integer[] {1,2,3}));
		grid.add(Arrays.asList(new Integer[] {3,4,5}));
		grid.add(Arrays.asList(new Integer[] {5,6,7}));
		
		List<Integer> pattern = new ArrayList<>();
		pattern.addAll(Arrays.asList(new Integer[] {1,3,4,6,5}));
		
		boolean isPatternFound = findSequencein2dArray(grid, pattern);
		System.out.println(isPatternFound);
	}
	
	

}
