package algorithms.datastructures.binarysearchtree.extras;

public class BinaryTreeHeight {
	
	int left = 0;
	int right = 0;
	int height = 0;
	BinaryTreeNode root;
	
	int binaryTreeHeightSimple(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return (1 + Math.max(binaryTreeHeightSimple(root.left), binaryTreeHeightSimple(root.right)));
	}
	
	int binaryTreeHeight(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		
		left = binaryTreeHeight(root.left);
		right = binaryTreeHeight(root.right);
		
		if(left>right) {
			height = 1 + left;
		} else{
			height = 1 + right;
		}
		
		return height;
	}
	
	public static void main(String[] args) {
		BinaryTreeHeight treeHeight = new BinaryTreeHeight();
		treeHeight.root = new BinaryTreeNode(314);
		treeHeight.root.left = new BinaryTreeNode(6);
		treeHeight.root.right = new BinaryTreeNode(6);
		treeHeight.root.left.left = new BinaryTreeNode(271);
		treeHeight.root.left.right = new BinaryTreeNode(561);
		treeHeight.root.right.left = new BinaryTreeNode(12);
		treeHeight.root.right.right = new BinaryTreeNode(0);
		treeHeight.root.right.right.right = new BinaryTreeNode(0);
		treeHeight.root.right.right.right.right = new BinaryTreeNode(0);
		
		
		int height = treeHeight.binaryTreeHeight(treeHeight.root);
		int height2 = treeHeight.binaryTreeHeightSimple(treeHeight.root);
		
		System.out.println(height);
		System.out.println(height2);
	
	}

}
