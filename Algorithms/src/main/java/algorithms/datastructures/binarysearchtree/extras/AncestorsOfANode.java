package algorithms.datastructures.binarysearchtree.extras;

public class AncestorsOfANode {
	
	BinaryTreeNode root;
	
	boolean printAncestorsOfANode(BinaryTreeNode root, int target) {
		if(root==null) {
			return false;
		}
		if(target == root.data) {
			return true;
		}
		
		if(printAncestorsOfANode(root.left, target) || printAncestorsOfANode(root.right, target)) {
			System.out.println(root.data);
			return true;
		}
		return false;
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
		
		AncestorsOfANode ancestorsOfANode = new AncestorsOfANode();
		ancestorsOfANode.root = new BinaryTreeNode(1);
		ancestorsOfANode.root.left = new BinaryTreeNode(2);
		ancestorsOfANode.root.right = new BinaryTreeNode(3);
		ancestorsOfANode.root.left.left = new BinaryTreeNode(4);
		ancestorsOfANode.root.left.right = new BinaryTreeNode(5);
		ancestorsOfANode.root.right.left = new BinaryTreeNode(6);
		ancestorsOfANode.root.right.right = new BinaryTreeNode(7);
		ancestorsOfANode.root.left.left.left = new BinaryTreeNode(8);
		ancestorsOfANode.root.left.left.right = new BinaryTreeNode(9);
		ancestorsOfANode.root.left.right.left = new BinaryTreeNode(10);
		ancestorsOfANode.root.left.right.right = new BinaryTreeNode(11);
		ancestorsOfANode.root.right.left.left = new BinaryTreeNode(12);
		ancestorsOfANode.root.right.left.right = new BinaryTreeNode(13);
		ancestorsOfANode.root.right.right.right = new BinaryTreeNode(14);
		ancestorsOfANode.root.right.right.right.left = new BinaryTreeNode(15);
		ancestorsOfANode.root.right.right.right.right = new BinaryTreeNode(16);
		ancestorsOfANode.root.left.left.right.left = new BinaryTreeNode(17);
		ancestorsOfANode.root.left.left.right.right = new BinaryTreeNode(18);
		
		ancestorsOfANode.printAncestorsOfANode(ancestorsOfANode.root, 17);
		
	}
}
