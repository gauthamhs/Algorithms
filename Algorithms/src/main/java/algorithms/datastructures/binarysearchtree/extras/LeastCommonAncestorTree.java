package algorithms.datastructures.binarysearchtree.extras;

public class LeastCommonAncestorTree {
	
	BinaryTreeNode root;
	
	BinaryTreeNode leastCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
		
		if(root==null) {
			return null;
		}
		
		if(root == p || root==q) {
			return root;
		}
		
		BinaryTreeNode left = leastCommonAncestor(root.left, p, q);
		BinaryTreeNode right = leastCommonAncestor(root.right, p, q);
		
		if(left!=null && right!=null) {
			return root;
		}
		
		return (left!=null) ? left:right;
		
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
		
		LeastCommonAncestorTree lca = new LeastCommonAncestorTree();
		lca.root = new BinaryTreeNode(1);
		lca.root.left = new BinaryTreeNode(2);
		lca.root.right = new BinaryTreeNode(3);
		lca.root.left.left = new BinaryTreeNode(4);
		lca.root.left.right = new BinaryTreeNode(5);
		lca.root.right.left = new BinaryTreeNode(6);
		lca.root.right.right = new BinaryTreeNode(7);
		lca.root.left.left.left = new BinaryTreeNode(8);
		lca.root.left.left.right = new BinaryTreeNode(9);
		lca.root.left.right.left = new BinaryTreeNode(10);
		lca.root.left.right.right = new BinaryTreeNode(11);
		lca.root.right.left.left = new BinaryTreeNode(12);
		lca.root.right.left.right = new BinaryTreeNode(13);
		lca.root.right.right.right = new BinaryTreeNode(14);
		lca.root.right.right.right.left = new BinaryTreeNode(15);
		lca.root.right.right.right.right = new BinaryTreeNode(16);
		lca.root.left.left.right.left = new BinaryTreeNode(17);
		lca.root.left.left.right.right = new BinaryTreeNode(18);
		
		//LCA of 17 and 10;
		
		BinaryTreeNode lca1 = lca.leastCommonAncestor(lca.root, lca.root.left.left.right.left, lca.root.left.right.left);
		System.out.println(lca1);
		
		// LCA of 13 and 7
		BinaryTreeNode lca2 = lca.leastCommonAncestor(lca.root, lca.root.right.left.right, lca.root.right.right);
		System.out.println(lca2);
		
		// LCA of 8 and 16
		BinaryTreeNode lca3 = lca.leastCommonAncestor(lca.root, lca.root.left.left.left, lca.root.right.right.right.right);
		System.out.println(lca3);
		
		// LCA of 5 and 10
		BinaryTreeNode lca4 = lca.leastCommonAncestor(lca.root, lca.root.left.right.left, lca.root.left.right);
		System.out.println(lca4);
		
		
	
		
		
	}

}
