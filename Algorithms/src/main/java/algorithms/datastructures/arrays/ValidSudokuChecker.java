package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// The idea of Sudoku checker is to check three things

// Check rows
// Check Columns
// Check regions or subarray

// Within these rows or columns, we need to check if the values are between 1-9 and there are no duplicates.

public class ValidSudokuChecker {
	
	public static boolean CheckIfSudokuIsValid(List<List<Integer>> sudokuArray) {
		
		int sudokuArraySize = sudokuArray.size();
		
		//Check Row Constraints
		for(int i=0;i<sudokuArraySize;++i) {
			if(hasDuplicates(sudokuArray, i, i+1, 0, sudokuArray.size())) {
				return false;
			}
		}
		
		//Check Column Constraints
			for(int j=0;j<sudokuArraySize;++j) {
				if(hasDuplicates(sudokuArray, 0, sudokuArraySize, j, j+1)) {
					return false;
				}
		}
			
		//Check Region Constraints
		int regionSize = (int) Math.sqrt(sudokuArraySize);
		for(int I=0;I<regionSize;++I) {
			for(int J=0;J<regionSize;++J) {
				if(hasDuplicates(sudokuArray, I*regionSize, (I+1)*regionSize, J*regionSize, (J+1)*regionSize)) {
					return false;
				}
			}
		}
	
		return true;
		
	}
	
	public static boolean hasDuplicates(List<List<Integer>> sudokuArray, int startRow, int endRow,
			int startColumn, int endColumn) {
		List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(sudokuArray.size() + 1, false));
		Set<Integer> sudokuSet = new HashSet<>();
		sudokuSet.add(1); sudokuSet.add(2); sudokuSet.add(3); sudokuSet.add(4);
		sudokuSet.add(5); sudokuSet.add(6); sudokuSet.add(7); sudokuSet.add(8); sudokuSet.add(9);
		for(int i=startRow;i<endRow;++i) {
			for(int j=startRow;j<endRow;++j) {
				if(!sudokuSet.contains(sudokuArray.get(i).get(j)) && isPresent.get(sudokuArray.get(i).get(j))) {
					return true;
				}
				isPresent.set(sudokuArray.get(i).get(j), true);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);

		List<List<Integer>> sudokuArray = new ArrayList<>();
		sudokuArray.add(list);
		sudokuArray.add(list);
		sudokuArray.add(list);
		sudokuArray.add(list);
		sudokuArray.add(list);
		sudokuArray.add(list);
		sudokuArray.add(list);
		sudokuArray.add(list);
		sudokuArray.add(list);
		
		boolean sudokuCheck = CheckIfSudokuIsValid(sudokuArray);
		System.out.println(sudokuCheck);
		
	}

}
