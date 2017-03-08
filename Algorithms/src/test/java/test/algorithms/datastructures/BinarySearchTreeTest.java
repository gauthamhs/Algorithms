package test.algorithms.datastructures;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import algorithms.datastructures.binarysearchtree.BinarySearchTreeImpl;

public class BinarySearchTreeTest {

	@Test
	public void breadthFirstSearch(){
		
		BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
		binarySearchTree.insertNode(50);
		binarySearchTree.insertNode(60);
		binarySearchTree.insertNode(24);
		
		boolean breadthFirstSearch = binarySearchTree.breadthFirstSearch(binarySearchTree.getRoot(), 50);
		assertThat(breadthFirstSearch).isEqualTo(true);
	}
}
