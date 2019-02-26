package algorithms.datastructures.binarysearchtree.extras;

public class HeightBalancedTree {
	
	BinaryTreeNode root;
	
	boolean isHeightBalanced(BinaryTreeNode root) {
		if(root==null) {
			return true;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		
		if(Math.abs(leftHeight-rightHeight)<=1 && isHeightBalanced(root.left) &&isHeightBalanced(root.right)) {
			return true;
		}
		
		return false;
	}
	
	int height(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		
		return (1 + Math.max(height(root.left), height(root.right)));
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
		
		HeightBalancedTree heightBalancedTree = new HeightBalancedTree();
		heightBalancedTree.root = new BinaryTreeNode(1);
		heightBalancedTree.root.left = new BinaryTreeNode(2);
		heightBalancedTree.root.right = new BinaryTreeNode(3);
		heightBalancedTree.root.left.left = new BinaryTreeNode(4);
		heightBalancedTree.root.left.right = new BinaryTreeNode(5);
		heightBalancedTree.root.right.left = new BinaryTreeNode(6);
		heightBalancedTree.root.right.right = new BinaryTreeNode(7);
		heightBalancedTree.root.left.left.left = new BinaryTreeNode(8);
		heightBalancedTree.root.left.left.right = new BinaryTreeNode(9);
		heightBalancedTree.root.left.right.left = new BinaryTreeNode(10);
		heightBalancedTree.root.left.right.right = new BinaryTreeNode(11);
		heightBalancedTree.root.right.left.left = new BinaryTreeNode(12);
		heightBalancedTree.root.right.left.right = new BinaryTreeNode(13);
		heightBalancedTree.root.right.right.right = new BinaryTreeNode(14);
		heightBalancedTree.root.right.right.right.left = new BinaryTreeNode(15);
		heightBalancedTree.root.right.right.right.right = new BinaryTreeNode(16);
		heightBalancedTree.root.left.left.right.left = new BinaryTreeNode(17);
		heightBalancedTree.root.left.left.right.right = new BinaryTreeNode(18);
		
		boolean isHeightBalanced = heightBalancedTree.isHeightBalanced(heightBalancedTree.root);
		System.out.println(isHeightBalanced);
		
	}

}
