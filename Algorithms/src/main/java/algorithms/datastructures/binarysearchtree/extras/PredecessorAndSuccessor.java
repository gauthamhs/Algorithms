package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PredecessorAndSuccessor {
	
	 static int successor;
	static int predecessor;
	 BinaryTreeNode root;
	
	 List<Integer> predecessorSuccessor(BinaryTreeNode root, int val, List<Integer> ps) {
		if(root==null) {
			return null;
		}
		
		// If root.data is the given value, Find predecessor and successor
		// To find the predecessor, Go to the left node of the root and 
		// find maximum value by traversing to right node.
		// To find the successor, Go to the right node of the root and 
		// find minimum value by traversing to left node. 
		
		if(root.data == val) {
			if(root.left!=null) {
				BinaryTreeNode leftNode = root.left;
				while(leftNode.right!=null) {
					leftNode = leftNode.right;
				}
				predecessor = leftNode.data;
			}
			
			if(root.right!=null) {
				BinaryTreeNode rightNode = root.right;
				while(rightNode.left!=null) {
					rightNode = rightNode.left;
				}
				successor = rightNode.data;
			}
			
			ps.add(predecessor);
			ps.add(successor);
			
		// If value is greater than root data, set root as predecessor 
		// if we are unable to find predecessor if leftSubTree is null
		} else if(val>root.data) {
			predecessor = root.data;
			predecessorSuccessor(root.right, val, ps);
			
			// If value is lesser than root data, set root as successor 
			// if we are unable to find successor if rightSubTree is null
		} else if(val<root.data) {
			successor = root.data;
			predecessorSuccessor(root.left, val, ps);
		}
		return ps;
	}
	
	public static void main(String[] args) {
		
		PredecessorAndSuccessor predecessorSuccessor = new PredecessorAndSuccessor();
		predecessorSuccessor.root = new BinaryTreeNode(50);
		predecessorSuccessor.root.left = new BinaryTreeNode(10);
		predecessorSuccessor.root.right = new BinaryTreeNode(100);
		predecessorSuccessor.root.left.left = new BinaryTreeNode(2);
		predecessorSuccessor.root.left.right = new BinaryTreeNode(35);
		predecessorSuccessor.root.right.left = new BinaryTreeNode(90);
		predecessorSuccessor.root.right.right = new BinaryTreeNode(120);
		
		List<Integer> ps = predecessorSuccessor.predecessorSuccessor(predecessorSuccessor.root,120, new ArrayList<>());
		System.out.println("Successor: " + ps.get(1) + ", Predecessor: " + ps.get(0));
	}

}
