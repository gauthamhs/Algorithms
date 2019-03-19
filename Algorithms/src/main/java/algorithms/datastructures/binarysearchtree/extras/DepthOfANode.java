package algorithms.datastructures.binarysearchtree.extras;

public class DepthOfANode {
	
	BinaryTreeNode root;
	
	public int depthOfANode(BinaryTreeNode root, int val) {
		return depthOfANodeHelper(root, val, 1);
	}
	
	public int depthOfANodeHelper(BinaryTreeNode root, int val, int height) {
		if(root==null) {
			return 0;
		}
		
		if(root.data == val) {
			return height;
		}
		
		return (depthOfANodeHelper(root.left, val, height+1) | depthOfANodeHelper(root.right, val, height+1));
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
		
		DepthOfANode nodeDepth = new DepthOfANode();
		nodeDepth.root = new BinaryTreeNode(1);
		nodeDepth.root.left = new BinaryTreeNode(2);
		nodeDepth.root.right = new BinaryTreeNode(3);
		nodeDepth.root.left.left = new BinaryTreeNode(4);
		nodeDepth.root.left.right = new BinaryTreeNode(5);
		nodeDepth.root.right.left = new BinaryTreeNode(6);
		nodeDepth.root.right.right = new BinaryTreeNode(7);
		nodeDepth.root.left.left.left = new BinaryTreeNode(8);
		nodeDepth.root.left.left.right = new BinaryTreeNode(9);
		nodeDepth.root.left.right.left = new BinaryTreeNode(10);
		nodeDepth.root.left.right.right = new BinaryTreeNode(11);
		nodeDepth.root.right.left.left = new BinaryTreeNode(12);
		nodeDepth.root.right.left.right = new BinaryTreeNode(13);
		nodeDepth.root.right.right.right = new BinaryTreeNode(14);
		nodeDepth.root.right.right.right.left = new BinaryTreeNode(15);
		nodeDepth.root.right.right.right.right = new BinaryTreeNode(16);
		nodeDepth.root.left.left.right.left = new BinaryTreeNode(17);
		nodeDepth.root.left.left.right.right = new BinaryTreeNode(18);
		
		int depth = nodeDepth.depthOfANode(nodeDepth.root, 10);
		System.out.println(depth);
		
	}

}
