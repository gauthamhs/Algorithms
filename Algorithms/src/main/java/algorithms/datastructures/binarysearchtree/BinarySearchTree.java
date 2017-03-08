package algorithms.datastructures.binarysearchtree;

import java.util.List;

public interface BinarySearchTree {
	
	/*Ancillary Operations*/
	void sortedListfromBinarySearchTree(TreeNode root, List<TreeNode> treeList);
	
	/*Search Operations*/
	
	//In Breadth First Search, We use queues because we need to access the level elements first.
	//Complexity:- Best Case: O(1), Worst Case: O(n)
	
	boolean breadthFirstSearch(TreeNode root, int element);
	
	//In Depth First Search, We use stacks to assess the sub trees first.
	boolean depthFirstSearch(TreeNode root, int element);
	
	//Returns the kth smallest element in the Binary Search Tree
	//Complexity:- O(n)
	TreeNode KthSmallestElement(TreeNode root, int k);
	
	//Returns the kth largest element in Binary Search Tree
	TreeNode KthLargestElement(TreeNode root, int k);
	
	//Returns the smallest element in the tree.
	//Complexity: - O(H) where h is the height of the left sub tree.
	TreeNode getSmallest();
	
	//Returns the largest element in the tree.
	//Complexity: - O(H) where h is the height of the right sub tree.
	TreeNode getLargest();
	
	//Find the element in Binary Search Tree.
	//Complexity: O(log(n))
	TreeNode findData(int data);
	TreeNode findDataRecursive(int data);
	
	/*Insert Operations*/
	
	//Insert the nodes in the binary search tree
	//Complexity: O(h) where h is the height of the tree.
	void insertNode(int data);
	void insertNodeRecursive(int data);
	
	/*Delete Operations*/
	
	//Delete the node from the Binary Search Tree
	void deleteNode(BinarySearchTreeImpl binarySearchTree, int data);
	
	/*Print Operations*/
	
	//Prints the binary search tree, Left-->Root-->Right. Gives you a sorted Binary Tree
	//in ascending order
	
	//Complexity:O(n) as all the nodes in the tree are traversed atleast once.
	void printInOrder(TreeNode treeNode);
	
	//Prints the binary search tree, Root-->Left-->Right.
	void printPreOrder(TreeNode treeNode);
	
	//Prints the binary search tree, Left-->Right-->Root.
	void printPostOrder(TreeNode treeNode);
	
	//Prints the Complete Binary Search Tree Level by Level.
	void printCompleteTree(TreeNode root);
	
	//Prints the Complete Binary Search Tree in Spiral Form
	void printSpiralBinaryTree(TreeNode root);
	
	//Prints the Complete Binary Search Tree in Spiral Form - More Efficient.
	void printCompleteSpiralBinaryTreeUsingStacks(TreeNode root);
	
	//Prints the level of the Binary Search Tree for a given Height.
	void printLevel(TreeNode root, int height);
	
	/*Miscellaneous Operations*/
	
	// Gets the Height of the tree iteratively.
	//Complexity:- O(h)
	int treeHeight(TreeNode root);
	
	//Gets the Height of the tree recursively.
	int treeHeightRecursion(TreeNode root);
	
	//Gets the Least Common Ancestor of the tree iteratively.
	//Complexity:O(H) where H is the height of the tree.
	TreeNode leastCommonAncestor(TreeNode root, int n1, int n2);
	
	//Gets the Least Common Ancestor of the tree recursively.
	TreeNode leastCommonAncestorRecursion(TreeNode root, int n1, int n2);
	
}