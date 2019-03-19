package algorithms.datastructures.binarysearchtree.extras;

public class LowestCommonAncestor {
	
	BinaryTreeNode root;
	
public static BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
		
		if(root==null) {
			return root;
		}
		
		if(root.data==p.data || root.data==q.data) {
			return root;
		}
		
		BinaryTreeNode left = LCA(root.left, p, q);
		BinaryTreeNode right = LCA(root.right, p, q);
		
		if(left!=null && right!=null) {
			return root;
		}
		
		return (left!=null) ? left : right;
		
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
	
	LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
	lowestCommonAncestor.root = new BinaryTreeNode(1);
	lowestCommonAncestor.root.left = new BinaryTreeNode(2);
	lowestCommonAncestor.root.right = new BinaryTreeNode(3);
	lowestCommonAncestor.root.left.left = new BinaryTreeNode(4);
	lowestCommonAncestor.root.left.right = new BinaryTreeNode(5);
	lowestCommonAncestor.root.right.left = new BinaryTreeNode(6);
	lowestCommonAncestor.root.right.right = new BinaryTreeNode(7);
	lowestCommonAncestor.root.left.left.left = new BinaryTreeNode(8);
	lowestCommonAncestor.root.left.left.right = new BinaryTreeNode(9);
	lowestCommonAncestor.root.left.right.left = new BinaryTreeNode(10);
	lowestCommonAncestor.root.left.right.right = new BinaryTreeNode(11);
	lowestCommonAncestor.root.right.left.left = new BinaryTreeNode(12);
	lowestCommonAncestor.root.right.left.right = new BinaryTreeNode(13);
	lowestCommonAncestor.root.right.right.right = new BinaryTreeNode(14);
	lowestCommonAncestor.root.right.right.right.left = new BinaryTreeNode(15);
	lowestCommonAncestor.root.right.right.right.right = new BinaryTreeNode(16);
	lowestCommonAncestor.root.left.left.right.left = new BinaryTreeNode(17);
	lowestCommonAncestor.root.left.left.right.right = new BinaryTreeNode(18);
	
	BinaryTreeNode lca = LCA(lowestCommonAncestor.root, new BinaryTreeNode(11), new BinaryTreeNode(18)) ;
	System.out.println(lca);
	
}
	

}
