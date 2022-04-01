package algorithms.datastructures.binarysearchtree.extras;

import java.util.List;

public class MaximumPathSum {
	
	BinaryTreeNode root;
	static Integer globalMax;
	
	public static Integer maximumPathSum(BinaryTreeNode root) {
		globalMax = Integer.MIN_VALUE;
		
		maximumPathSumHelper(root);
		return globalMax;
	}
	
	public static Integer maximumPathSumHelper(BinaryTreeNode root) {
		
		if(root==null) {
			return 0;
		}
		
		Integer left = maximumPathSumHelper(root.left);
		Integer right = maximumPathSumHelper(root.right);
		
		Integer currentMax = Math.max(root.data, root.data + Math.max(left,right));
		Integer max = Math.max(currentMax, root.data + left + right);
		globalMax = Math.max(globalMax, max);
		
		
		return currentMax;
		
	}
	
	
	public static void main(String[] args) {
		
		MaximumPathSum pathSum = new MaximumPathSum();
		pathSum.root = new BinaryTreeNode(1);
		pathSum.root.left = new BinaryTreeNode(2);
		pathSum.root.right = new BinaryTreeNode(3);
		pathSum.root.left.left = new BinaryTreeNode(4);
		pathSum.root.left.right = new BinaryTreeNode(5);
		pathSum.root.right.left = new BinaryTreeNode(6);
		pathSum.root.right.right = new BinaryTreeNode(7);
		pathSum.root.left.left.left = new BinaryTreeNode(8);
		pathSum.root.left.left.right = new BinaryTreeNode(9);
		pathSum.root.left.right.left = new BinaryTreeNode(10);
		pathSum.root.left.right.right = new BinaryTreeNode(11);
		pathSum.root.right.left.left = new BinaryTreeNode(12);
		pathSum.root.right.left.right = new BinaryTreeNode(13);
		pathSum.root.right.right.right = new BinaryTreeNode(14);
		pathSum.root.right.right.right.left = new BinaryTreeNode(15);
		pathSum.root.right.right.right.right = new BinaryTreeNode(16);
		pathSum.root.left.left.right.left = new BinaryTreeNode(17);
		pathSum.root.left.left.right.right = new BinaryTreeNode(18);
		
		System.out.println(maximumPathSum(pathSum.root));
		
	}

}
