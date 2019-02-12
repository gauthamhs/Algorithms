package algorithms.datastructures.binarysearchtree.extras;

public class BoundaryTraversal {
	
	BinaryTreeNode root;
	
	void printLeftBoundary(BinaryTreeNode root) {
		
		if(root == null) {
			return;
		}
		
		if(root!=null) {
			if(root.left!=null) {
				System.out.print(root.data + " ");
				printLeftBoundary(root.left);
			} else if(root.right!=null) {
				System.out.print(root.data + " ");
				printLeftBoundary(root.right);
			}
		}
		
	}
	
	void printRightBoundary(BinaryTreeNode root) {
		
		if(root == null) {
			return;
		}
		
		if(root!=null) {
			if(root.right!=null) {
				printRightBoundary(root.right);
				System.out.print(root.data + " ");
			} else if(root.left!=null) {
				printRightBoundary(root.left);
				System.out.print(root.data + " ");
			}
		}
		
	}
	
	void printLeaves(BinaryTreeNode root) {
		
		if(root==null) {
			return;
		}
		
		if(root.left==null && root.right == null) {
			System.out.print(root.data + " ");
		} else {
			if(root.left!=null) {
				printLeaves(root.left);
			}
			
			if(root.right!=null) {
				printLeaves(root.right);
			}
		}
		
	}
	
	void printBoundary(BinaryTreeNode root) {
		
		if(root==null) {
			return;
		}
		
		System.out.print(root.data +  " ");
		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);
		
		
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
		
		BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
		boundaryTraversal.root = new BinaryTreeNode(1);
		boundaryTraversal.root.left = new BinaryTreeNode(2);
		boundaryTraversal.root.right = new BinaryTreeNode(3);
		boundaryTraversal.root.left.left = new BinaryTreeNode(4);
		boundaryTraversal.root.left.right = new BinaryTreeNode(5);
		boundaryTraversal.root.right.left = new BinaryTreeNode(6);
		boundaryTraversal.root.right.right = new BinaryTreeNode(7);
		boundaryTraversal.root.left.left.left = new BinaryTreeNode(8);
		boundaryTraversal.root.left.left.right = new BinaryTreeNode(9);
		boundaryTraversal.root.left.right.left = new BinaryTreeNode(10);
		boundaryTraversal.root.left.right.right = new BinaryTreeNode(11);
		boundaryTraversal.root.right.left.left = new BinaryTreeNode(12);
		boundaryTraversal.root.right.left.right = new BinaryTreeNode(13);
		boundaryTraversal.root.right.right.right = new BinaryTreeNode(14);
		boundaryTraversal.root.right.right.right.left = new BinaryTreeNode(15);
		boundaryTraversal.root.right.right.right.right = new BinaryTreeNode(16);
		boundaryTraversal.root.left.left.right.left = new BinaryTreeNode(17);
		boundaryTraversal.root.left.left.right.right = new BinaryTreeNode(18);
		
		boundaryTraversal.printBoundary(boundaryTraversal.root);
		
	}

}
