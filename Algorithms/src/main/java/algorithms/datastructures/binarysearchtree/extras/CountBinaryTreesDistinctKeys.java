package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountBinaryTreesDistinctKeys {
	
	BinaryTreeNode node;
	
	int binaryTreeCountDistinctkey(int key) {
		
		List<Integer> binaryTreeCount = new ArrayList<>(Collections.nCopies(key+1, 0));
		binaryTreeCount.set(0, 1);
		binaryTreeCount.set(1, 1);
		int i;
		
		for(i=2;i<=key;i++) {
			for(int j=0;j<i;j++) {
				binaryTreeCount.set(i,  binaryTreeCount.get(i) + (binaryTreeCount.get(j) * binaryTreeCount.get(i-j-1)));
			}
		}
		
		return binaryTreeCount.get(key);
	}
	
	
	public static void main(String[] args) {
		CountBinaryTreesDistinctKeys countBinaryTrees = new CountBinaryTreesDistinctKeys();
		int key = 3;
		int noOfBinaryTrees = countBinaryTrees.binaryTreeCountDistinctkey(key);
		System.out.println(noOfBinaryTrees);
	}

}
