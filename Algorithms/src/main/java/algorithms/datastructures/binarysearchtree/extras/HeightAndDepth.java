package algorithms.datastructures.binarysearchtree.extras;

public class HeightAndDepth {
	
	BinaryTreeNode root;
	
	public static int heightOfTree(BinaryTreeNode root) {
		
		if(root==null ) {
			return 0;
		}
		
		return 1+Math.max(heightOfTree(root.left), heightOfTree(root.right));
		
	}
	
	public static int heightOfNode(BinaryTreeNode node, int val) {
		
		return heightOfNodeHelper(node,val,1);
				
	}
	
	public static int heightOfNodeHelper(BinaryTreeNode node, int val, int height) {
		if(node==null) {
			return 0;
		}
		if(node.data==val) {
			return height;
		}
		
		return heightOfNodeHelper(node.left,val,height+1) | heightOfNodeHelper(node.right, val, height+1);
		
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
		
		HeightAndDepth nodeDepth = new HeightAndDepth();
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
		
		int depth = heightOfTree(nodeDepth.root);
		System.out.println(depth);
		
		int heightNode = heightOfNode(nodeDepth.root, 10);
		System.out.println(heightNode);
		
	}

}
