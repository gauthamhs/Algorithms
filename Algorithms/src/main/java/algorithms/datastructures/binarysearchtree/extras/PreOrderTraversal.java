package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderTraversal {
	
	
	/*	PreOrder Traversal prints the tree in the following order: 
	
	1) Print root
	2) Print left Child
	3) Print right Child
	
	        314
	      /     \
	    6        6
	  /  \     /   \
	271 561   12   0 
	
	Prints 314 6 271 561 6 12 0 
	*/
	
	BinaryTreeNode root;
	
	void preOrderTraversalIterativeUsingStack(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		
		Deque<BinaryTreeNode> nodeStack = new ArrayDeque<>();
		
		while(root!=null || !nodeStack.isEmpty()) {
			while(root!=null) {
				System.out.print(root.data + " ");
				nodeStack.addFirst(root);
				root = root.left;
			}
			
		   root = nodeStack.removeFirst();
		   
		   root = root.right;
		}
	}
	
	void preOrderTraversalRecursive(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrderTraversalRecursive(root.left);
		preOrderTraversalRecursive(root.right);
		
	}
	
	public static void main(String[] args) {
		
		PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
		preOrderTraversal.root = new BinaryTreeNode(314);
		preOrderTraversal.root.left = new BinaryTreeNode(6);
		preOrderTraversal.root.right = new BinaryTreeNode(6);
		preOrderTraversal.root.left.left = new BinaryTreeNode(271);
		preOrderTraversal.root.left.right = new BinaryTreeNode(561);
		preOrderTraversal.root.right.left = new BinaryTreeNode(12);
		preOrderTraversal.root.right.right = new BinaryTreeNode(0);
		
		
		preOrderTraversal.preOrderTraversalRecursive(preOrderTraversal.root);
		System.out.println();
		preOrderTraversal.preOrderTraversalIterativeUsingStack(preOrderTraversal.root);
		
	}
	

}
