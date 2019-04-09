package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.List;

public class PrintLeafNodes {
	
	BinaryTreeNode root;
	static List<Integer> leafs = new ArrayList<>();
	void printLeafNodes(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		
		if(root.left==null && root.right==null) {
			leafs.add(root.data);
		}
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		
		
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
		
		PrintLeafNodes printLeafNodes = new PrintLeafNodes();
		printLeafNodes.root = new BinaryTreeNode(1);
		printLeafNodes.root.left = new BinaryTreeNode(2);
		printLeafNodes.root.right = new BinaryTreeNode(3);
		printLeafNodes.root.left.left = new BinaryTreeNode(4);
		printLeafNodes.root.left.right = new BinaryTreeNode(5);
		printLeafNodes.root.right.left = new BinaryTreeNode(6);
		printLeafNodes.root.right.right = new BinaryTreeNode(7);
		printLeafNodes.root.left.left.left = new BinaryTreeNode(8);
		printLeafNodes.root.left.left.right = new BinaryTreeNode(9);
		printLeafNodes.root.left.right.left = new BinaryTreeNode(10);
		printLeafNodes.root.left.right.right = new BinaryTreeNode(11);
		printLeafNodes.root.right.left.left = new BinaryTreeNode(12);
		printLeafNodes.root.right.left.right = new BinaryTreeNode(13);
		printLeafNodes.root.right.right.right = new BinaryTreeNode(14);
		printLeafNodes.root.right.right.right.left = new BinaryTreeNode(15);
		printLeafNodes.root.right.right.right.right = new BinaryTreeNode(16);
		printLeafNodes.root.left.left.right.left = new BinaryTreeNode(17);
		printLeafNodes.root.left.left.right.right = new BinaryTreeNode(18);
		
		printLeafNodes.printLeafNodes(printLeafNodes.root);
		System.out.println(leafs);
		
	}

}
