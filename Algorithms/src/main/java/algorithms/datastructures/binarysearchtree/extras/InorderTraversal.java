package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.Deque;



public class InorderTraversal {
	
	
	
/*	InOrder Traversal prints the tree in the following order: 
		
	1) Print left Child;
	2) Print root;
	3) Print right Child;
	
	        314
	      /     \
	    6        6
	  /  \     /   \
	271 561   12   0 
	
	Prints 271 6 561 314 12 6 0 
	*/
	
	 BinaryTreeNode root;
	 
	void inOrderTraversalIterativeUsingStack(BinaryTreeNode root) {
		Deque<BinaryTreeNode> nodeStack = new ArrayDeque<>();
		while(root!=null  || !nodeStack.isEmpty()) {
			while(root != null) {
				nodeStack.addFirst(root);
				root = root.left;
			}
			
		root = nodeStack.removeFirst();
		System.out.print(root.data + " ");
		
		root = root.right;
		
		}
	}
	
	void inOrderTraversalRecursive(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		inOrderTraversalRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderTraversalRecursive(root.right);
	}
	
	public static void main(String[] args) {
		
		InorderTraversal inOrderTraversal = new InorderTraversal();
		inOrderTraversal.root = new BinaryTreeNode(314);
		inOrderTraversal.root.left = new BinaryTreeNode(6);
		inOrderTraversal.root.right = new BinaryTreeNode(6);
		inOrderTraversal.root.left.left = new BinaryTreeNode(271);
		inOrderTraversal.root.left.right = new BinaryTreeNode(561);
		inOrderTraversal.root.right.left = new BinaryTreeNode(12);
		inOrderTraversal.root.right.right = new BinaryTreeNode(0);
		
		
		inOrderTraversal.inOrderTraversalRecursive(inOrderTraversal.root);
		System.out.println();
		inOrderTraversal.inOrderTraversalIterativeUsingStack(inOrderTraversal.root);
		
	}
	


}
