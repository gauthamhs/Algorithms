package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.List;

public class PrintNodesWithKLeaves {
	
	BinaryTreeNode root;
	
	int leftCount = 0 ;
	int rightCount = 0;
	int totalLeafCount = 0;
	
	int printNodesWithKLeaves(BinaryTreeNode root, int k){
		
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		
		leftCount = printNodesWithKLeaves(root.left, k);
		rightCount = printNodesWithKLeaves(root.right, k);
		
		totalLeafCount = leftCount + rightCount;
		
		if(totalLeafCount == k) {
			System.out.print(root + " ");
		}
		
		return totalLeafCount;
		
	}
	
	public static void main(String[] args) {
		int k = 3;
		PrintNodesWithKLeaves kLeaves = new PrintNodesWithKLeaves();
		kLeaves.root = new BinaryTreeNode(1);
		kLeaves.root.left = new BinaryTreeNode(2);
		kLeaves.root.right = new BinaryTreeNode(3);
		kLeaves.root.left.left = new BinaryTreeNode(4);
		kLeaves.root.left.right = new BinaryTreeNode(5);
		kLeaves.root.right.left = new BinaryTreeNode(6);
		kLeaves.root.right.right = new BinaryTreeNode(7);
		kLeaves.root.left.left.left = new BinaryTreeNode(8);
		kLeaves.root.left.left.right = new BinaryTreeNode(9);
		kLeaves.root.left.left.left.left = new BinaryTreeNode(10);
		kLeaves.printNodesWithKLeaves(kLeaves.root, k);
		
		
	}

}
