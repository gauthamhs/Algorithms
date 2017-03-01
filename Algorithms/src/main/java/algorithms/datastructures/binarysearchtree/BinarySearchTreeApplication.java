package algorithms.datastructures.binarysearchtree;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTreeApplication {
	
	public static void main(String[] args) {
/*		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insertNodeIterative(52);
		binarySearchTree.insertNodeIterative(33);
		binarySearchTree.insertNodeIterative(65);
		binarySearchTree.printInOrder(binarySearchTree.getRoot());
		System.out.println();
		System.out.println(binarySearchTree.findDataIterative(70));

		System.out.println(binarySearchTree.findDataIterative(90));
		//binarySearchTree.deleteNode(52);
		binarySearchTree.printInOrder(binarySearchTree.getRoot());
		System.out.println();*/
		
		BinarySearchTree binarySearchTree2 = new BinarySearchTree();
		binarySearchTree2.insertNodeRecursive(50);
		binarySearchTree2.insertNodeRecursive(62);
		binarySearchTree2.insertNodeRecursive(57);
		binarySearchTree2.insertNodeRecursive(54);
		binarySearchTree2.insertNodeRecursive(58);
		binarySearchTree2.insertNodeRecursive(90);
		binarySearchTree2.insertNodeRecursive(74);
		binarySearchTree2.insertNodeRecursive(100);
		binarySearchTree2.insertNodeRecursive(68);
		binarySearchTree2.insertNodeRecursive(88);
		binarySearchTree2.insertNodeRecursive(64);
		binarySearchTree2.insertNodeRecursive(72);
		binarySearchTree2.printInOrder(binarySearchTree2.getRoot());
		System.out.println();
		//binarySearchTree2.deleteNode(binarySearchTree2, 50);
		//binarySearchTree2.deleteNode(binarySearchTree2, 62);
		binarySearchTree2.printCompleteTree(binarySearchTree2.getRoot());
		System.out.println();
		//binarySearchTree2.printLevel(binarySearchTree2.getRoot(), 3);
		System.out.println();
		//System.out.println(binarySearchTree2.treeHeight(binarySearchTree2.getRoot()));
		System.out.println(binarySearchTree2.getSmallest());
		System.out.println(binarySearchTree2.getLargest());
		
		System.out.println(binarySearchTree2.leastCommonAncestor(binarySearchTree2.getRoot(), 54, 100));		
	}
	
	

}


