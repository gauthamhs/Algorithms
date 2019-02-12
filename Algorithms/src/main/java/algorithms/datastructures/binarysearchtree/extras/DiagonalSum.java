package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalSum {
	
	BinaryTreeNode root;
	
	void printDiagonalElements(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		nodeQueue.add(null);
		List<Integer> nodeList = new ArrayList<>();
		while(!nodeQueue.isEmpty()) {
			BinaryTreeNode node = nodeQueue.poll();
			if(node==null) {
				for (Integer integer : nodeList) {
					System.out.print(integer + " ");
				}
				System.out.println();
				
				nodeList = new LinkedList<>();
				nodeQueue.add(null);
				node = nodeQueue.poll();
				if(node==null) {
					break;
				}
			} 
			
			while(node!=null) {
				nodeList.add(node.data);
				if(node.left!=null) {
					nodeQueue.add(node.left);
				}
					
					node = node.right;
				}
			}
		}
		
	
	
	void printDiagonalSum(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		
		Queue<BinaryTreeNode> queueNode = new LinkedList<>();
		queueNode.add(root);
		queueNode.add(null);
		
		int sum = 0;
		
		while(!queueNode.isEmpty()) {
			BinaryTreeNode node = queueNode.poll();
			if(node==null) {
				System.out.println("Sum: " + sum);
				sum = 0;
				queueNode.add(null);
				node = queueNode.poll();
				if(node==null) {
					break;
				}
			}
			
			 
			while(node!=null) {
				sum += node.data;
				if(node.left!=null) {
					queueNode.add(node.left);
				}
				node = node.right;
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*               1
		/*            /     \
		 *          2          3
		 *        /  \        /  \
		 *       4    5      6    7 
		 *     /  \  / \    / \   \
		 *    8   9 10 11  12 13  14
		 *       / \              / \
		 *      17  18           15  16
		 *        
		 */
		
		DiagonalSum diagonalSum = new DiagonalSum();
		diagonalSum.root = new BinaryTreeNode(1);
		diagonalSum.root.left = new BinaryTreeNode(2);
		diagonalSum.root.right = new BinaryTreeNode(3);
		diagonalSum.root.left.left = new BinaryTreeNode(4);
		diagonalSum.root.left.right = new BinaryTreeNode(5);
		diagonalSum.root.right.left = new BinaryTreeNode(6);
		diagonalSum.root.right.right = new BinaryTreeNode(7);
		diagonalSum.root.left.left.left = new BinaryTreeNode(8);
		diagonalSum.root.left.left.right = new BinaryTreeNode(9);
		diagonalSum.root.left.right.left = new BinaryTreeNode(10);
		diagonalSum.root.left.right.right = new BinaryTreeNode(11);
		diagonalSum.root.right.left.left = new BinaryTreeNode(12);
		diagonalSum.root.right.left.right = new BinaryTreeNode(13);
		diagonalSum.root.right.right.right = new BinaryTreeNode(14);
		diagonalSum.root.right.right.right.left = new BinaryTreeNode(15);
		diagonalSum.root.right.right.right.right = new BinaryTreeNode(16);
		diagonalSum.root.left.left.right.left = new BinaryTreeNode(17);
		diagonalSum.root.left.left.right.right = new BinaryTreeNode(18);
		
		diagonalSum.printDiagonalSum(diagonalSum.root);
		diagonalSum.printDiagonalElements(diagonalSum.root);
		
	}

}
