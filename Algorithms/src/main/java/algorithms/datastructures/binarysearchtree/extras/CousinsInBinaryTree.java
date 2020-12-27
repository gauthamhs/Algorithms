package algorithms.datastructures.binarysearchtree.extras;

public class CousinsInBinaryTree {
	
	BinaryTreeNode root;
	
	public static boolean isCousins(BinaryTreeNode root, int x, int y) {
		
		return (nodeDepth(root,x,1) == nodeDepth(root,y,1)) && !isSiblings(root, x, y);
		
	}
	
	public static boolean isSiblings(BinaryTreeNode root, int x, int y) {
		if(root==null) {
			return false;
			}
		
		if(root.left!=null && root.right!=null) {
			if((root.left.data==x && root.right.data==y) || (root.left.data==y && root.right.data==x)) {
				return true;
			}
		}
		
		return isSiblings(root.left,x,y) || isSiblings(root.right,x,y);
	}
	
	public static int nodeDepth(BinaryTreeNode root, int val, int height) {
		if(root==null) {
			return 0;
		}
		
		if(root.data==val) {
			return height;
		}

		return nodeDepth(root.left, val, height+1) | nodeDepth(root.right, val , height+1);
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
		
	
		CousinsInBinaryTree cousins = new CousinsInBinaryTree();
		cousins.root = new BinaryTreeNode(1);
		cousins.root.left = new BinaryTreeNode(2);
		cousins.root.right = new BinaryTreeNode(3);
		cousins.root.left.left = new BinaryTreeNode(4);
		cousins.root.left.right = new BinaryTreeNode(5);
		cousins.root.right.left = new BinaryTreeNode(6);
		cousins.root.right.right = new BinaryTreeNode(7);
		cousins.root.left.left.left = new BinaryTreeNode(8);
		cousins.root.left.left.right = new BinaryTreeNode(9);
		cousins.root.left.right.left = new BinaryTreeNode(10);
		cousins.root.left.right.right = new BinaryTreeNode(11);
		cousins.root.right.left.left = new BinaryTreeNode(12);
		cousins.root.right.left.right = new BinaryTreeNode(13);
		cousins.root.right.right.right = new BinaryTreeNode(14);
		cousins.root.right.right.right.left = new BinaryTreeNode(15);
		cousins.root.right.right.right.right = new BinaryTreeNode(16);
		cousins.root.left.left.right.left = new BinaryTreeNode(17);
		cousins.root.left.left.right.right = new BinaryTreeNode(18);
		
		System.out.println(isCousins(cousins.root, 4, 5));
		System.out.println(isCousins(cousins.root,4, 6));
		System.out.println(isCousins(cousins.root, 8, 18));
		
	}

}
