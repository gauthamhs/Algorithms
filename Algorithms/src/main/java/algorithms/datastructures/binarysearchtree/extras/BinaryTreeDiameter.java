package algorithms.datastructures.binarysearchtree.extras;

// Binary tree Diameter is the longest length between any two nodes that may or may not pass through the root
// If it passes through the root, we can just calculate max height of left and right subtrees
// if it doesn't we need to calculate max(left,right diameter)
// The resultant diameter will be max of these two
public class BinaryTreeDiameter {
	
	BinaryTreeNode root;
	
	int binaryTreeDiameter(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		int leftDiameter = binaryTreeDiameter(root.left);
		int rightDiameter = binaryTreeDiameter(root.right);
		
		int diameter = Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
		return diameter;
		
		
	}
	
	int treeHeight(BinaryTreeNode root) {
		if (root==null) {
			return 0;
		}
		
		return (1+ Math.max(treeHeight(root.left), treeHeight(root.right)));
		
	}
	
	public static void main(String[] args) {
		
		BinaryTreeDiameter diameterRoot = new BinaryTreeDiameter();
		
		diameterRoot.root = new BinaryTreeNode(1);
		diameterRoot.root.left = new BinaryTreeNode(2);
		diameterRoot.root.right = new BinaryTreeNode(3);
		diameterRoot.root.left.left = new BinaryTreeNode(4);
		diameterRoot.root.left.right = new BinaryTreeNode(5);
		diameterRoot.root.left.right.left = new BinaryTreeNode(6);
		diameterRoot.root.left.right.right = new BinaryTreeNode(7);
		diameterRoot.root.right.right = new BinaryTreeNode(8);
		diameterRoot.root.right.right.right = new BinaryTreeNode(9);
		diameterRoot.root.right.right.right.left = new BinaryTreeNode(10);
		diameterRoot.root.right.right.right.right = new BinaryTreeNode(11);
		diameterRoot.root.right.right.right.left.left = new BinaryTreeNode(12);
		diameterRoot.root.right.right.right.left.right = new BinaryTreeNode(13);
		
		int diameterWithRootVal = diameterRoot.binaryTreeDiameter(diameterRoot.root);
		System.out.println(diameterWithRootVal);
		
		BinaryTreeDiameter diameterWithoutRoot = new BinaryTreeDiameter();
		
		diameterWithoutRoot.root = new BinaryTreeNode(1);
		diameterWithoutRoot.root.left = new BinaryTreeNode(2);
		diameterWithoutRoot.root.right = new BinaryTreeNode(3);
		diameterWithoutRoot.root.right.right = new BinaryTreeNode(4);
		diameterWithoutRoot.root.left.left = new BinaryTreeNode(5);
		diameterWithoutRoot.root.left.right = new BinaryTreeNode(6);
		diameterWithoutRoot.root.left.left.left = new BinaryTreeNode(7);
		diameterWithoutRoot.root.left.left.right = new BinaryTreeNode(8);
		diameterWithoutRoot.root.left.left.right.left = new BinaryTreeNode(9);
		diameterWithoutRoot.root.left.left.right.left.left = new BinaryTreeNode(10);
		diameterWithoutRoot.root.left.left.right.left.right = new BinaryTreeNode(11);
		diameterWithoutRoot.root.left.right.right = new BinaryTreeNode(12);
		diameterWithoutRoot.root.left.right.right.left = new BinaryTreeNode(13);
		diameterWithoutRoot.root.left.right.right.right = new BinaryTreeNode(14);
		diameterWithoutRoot.root.left.right.right.right.right = new BinaryTreeNode(15);
		
		int diameterWithoutRootVal = diameterRoot.binaryTreeDiameter(diameterWithoutRoot.root);
		System.out.println(diameterWithoutRootVal);
		
		
		
		
		
		
		
	}

}
