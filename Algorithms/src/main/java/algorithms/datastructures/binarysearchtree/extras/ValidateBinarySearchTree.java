package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.Deque;

/* In this algorithm, we are checking to see if a binary search tree is valid. 
 Binary Search Tree has the following properties: 
	 
1) Left subtree of the node has keys lesser than the nodes value 
2) Right subtree of the node has keys greater than the nodes value
3) Left and Right Subtree are also a binary Search Tree


Time Complexity: O(n). We are going through all the nodes in a DFS Way to check if they form a valid BST or not 
Space Complexity: O(n). We are storing the values in the recursive stack based on how many nodes are present.


Questions to ask the interviewer: 

1) What would be the type of data/value for the nodes in the BST
2) Could I use a recursive stack ?

*/

class BstStructure{
	
	Integer min;
	Integer max;
	BinaryTreeNode node;
	
	public BstStructure(BinaryTreeNode node, Integer min, Integer max) {
		this.node = node;
		this.max = max;
		this.min = min;
	}
}

public class ValidateBinarySearchTree {
	
	 public static boolean isValidBST(BinaryTreeNode root) {
	        
	        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	    
	    private static boolean isValidBSTHelper(BinaryTreeNode root, Integer min, Integer max){
	    	
	    	// Base case: A null tree is a valid BST
	         if(root==null){
	            return true;
	        }
	         
	         // If root has left/right nodes, Check the current node value with lower and upper bounds
	         // and recurse through left and right subtree if true
	        
	         if(root.data>min && root.data<max) {
	        return isValidBSTHelper(root.left, min, root.data) 
	            && isValidBSTHelper(root.right, root.data ,max);
	    }
	         //Return false if none of the conditions are satisfied
	    return false;
	    }
	    
	    
	    public static boolean isValidBSTIterative(BinaryTreeNode node) {
	    	
	    	if(node==null) {
	    		return true;
	    	}
	    	
	    	Deque<BstStructure> stack = new ArrayDeque<>();
	    	Integer min = Integer.MIN_VALUE;
	    	Integer max = Integer.MAX_VALUE;
	    	
	    	stack.add(new BstStructure(node, min, max));
	    	
	    	while(!stack.isEmpty()) {
	    		
	    		BstStructure currentNode = stack.pop();

	    		 min = currentNode.min;
	    		 max = currentNode.max;
	    		 node = currentNode.node;
	    		 
	    		 if(node.data>max || node.data<min) {
	    			 return false;
	    		 }	
	    		 
	    		 if(node.left!=null)  stack.add(new BstStructure(node.left,min,node.data));
	    		 if(node.right!=null) stack.add(new BstStructure(node.right,node.data,max));

	    	}
	    	
	    	return true;
	    	
	    }
	
	public static void main(String[] args) {
		
		
		BinaryTreeNode root = new BinaryTreeNode(5);
		root.left = new BinaryTreeNode(4);
		root.right = new BinaryTreeNode(6);
		System.out.println(ValidateBinarySearchTree.isValidBST(root));
		System.out.println(ValidateBinarySearchTree.isValidBSTIterative(root));
		
		BinaryTreeNode root1 = new BinaryTreeNode(5);
		root1.left = new BinaryTreeNode(4);
		root1.right = new BinaryTreeNode(6);
		root1.right.left = new BinaryTreeNode(2);
		System.out.println(ValidateBinarySearchTree.isValidBST(root1));
		System.out.println(ValidateBinarySearchTree.isValidBSTIterative(root1));

		
	}

}
