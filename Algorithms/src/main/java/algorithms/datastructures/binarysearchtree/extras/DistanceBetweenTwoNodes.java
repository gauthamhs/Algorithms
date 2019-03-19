package algorithms.datastructures.binarysearchtree.extras;

public class DistanceBetweenTwoNodes {
	
	BinaryTreeNode root;
	
	public static int distanceBetweenTwoNodes(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		
		if(node1==null || node2==null) {
			return 0;
		}
		
		BinaryTreeNode lca = LCA(root, node1, node2);
		int nodeDepth1 = nodeDepth(lca, node1, 0);
		int nodeDepth2 = nodeDepth(lca, node2, 0);
		
		return nodeDepth1 + nodeDepth2; 
		
	}
	
	public static int nodeDepth(BinaryTreeNode root,BinaryTreeNode node, int currentDepth) {
		if(root==null) {
			return 0;
		}
		
		if(root.data == node.data) {
			return currentDepth;
		}
		
		return nodeDepth(root.left, node, currentDepth+1) | nodeDepth(root.right, node, currentDepth+1);
	}
	
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
		
		DistanceBetweenTwoNodes distanceBetweenTwoNodes = new DistanceBetweenTwoNodes();
		distanceBetweenTwoNodes.root = new BinaryTreeNode(1);
		distanceBetweenTwoNodes.root.left = new BinaryTreeNode(2);
		distanceBetweenTwoNodes.root.right = new BinaryTreeNode(3);
		distanceBetweenTwoNodes.root.left.left = new BinaryTreeNode(4);
		distanceBetweenTwoNodes.root.left.right = new BinaryTreeNode(5);
		distanceBetweenTwoNodes.root.right.left = new BinaryTreeNode(6);
		distanceBetweenTwoNodes.root.right.right = new BinaryTreeNode(7);
		distanceBetweenTwoNodes.root.left.left.left = new BinaryTreeNode(8);
		distanceBetweenTwoNodes.root.left.left.right = new BinaryTreeNode(9);
		distanceBetweenTwoNodes.root.left.right.left = new BinaryTreeNode(10);
		distanceBetweenTwoNodes.root.left.right.right = new BinaryTreeNode(11);
		distanceBetweenTwoNodes.root.right.left.left = new BinaryTreeNode(12);
		distanceBetweenTwoNodes.root.right.left.right = new BinaryTreeNode(13);
		distanceBetweenTwoNodes.root.right.right.right = new BinaryTreeNode(14);
		distanceBetweenTwoNodes.root.right.right.right.left = new BinaryTreeNode(15);
		distanceBetweenTwoNodes.root.right.right.right.right = new BinaryTreeNode(16);
		distanceBetweenTwoNodes.root.left.left.right.left = new BinaryTreeNode(17);
		distanceBetweenTwoNodes.root.left.left.right.right = new BinaryTreeNode(18);
		
		int distance = distanceBetweenTwoNodes(distanceBetweenTwoNodes.root, new BinaryTreeNode(3), new BinaryTreeNode(9));
		System.out.println(distance);
		
	}

}
