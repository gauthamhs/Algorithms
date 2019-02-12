package algorithms.datastructures.binarysearchtree.extras;

public class NodeAtDistanceK {
	
	BinaryTreeNode root;
	
	void printNodesAtDistanceK(BinaryTreeNode root, int k) {
		if(root==null) {
			return;
		}
		
		if(k==0) {
			System.out.print(root.data + " ");
		} else {
			printNodesAtDistanceK(root.left, k-1);
			printNodesAtDistanceK(root.right, k-1);
		}
		
		
		
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
		
		NodeAtDistanceK nodeAtDistanceK = new NodeAtDistanceK();
		nodeAtDistanceK.root = new BinaryTreeNode(1);
		nodeAtDistanceK.root.left = new BinaryTreeNode(2);
		nodeAtDistanceK.root.right = new BinaryTreeNode(3);
		nodeAtDistanceK.root.left.left = new BinaryTreeNode(4);
		nodeAtDistanceK.root.left.right = new BinaryTreeNode(5);
		nodeAtDistanceK.root.right.left = new BinaryTreeNode(6);
		nodeAtDistanceK.root.right.right = new BinaryTreeNode(7);
		nodeAtDistanceK.root.left.left.left = new BinaryTreeNode(8);
		nodeAtDistanceK.root.left.left.right = new BinaryTreeNode(9);
		nodeAtDistanceK.root.left.right.left = new BinaryTreeNode(10);
		nodeAtDistanceK.root.left.right.right = new BinaryTreeNode(11);
		nodeAtDistanceK.root.right.left.left = new BinaryTreeNode(12);
		nodeAtDistanceK.root.right.left.right = new BinaryTreeNode(13);
		nodeAtDistanceK.root.right.right.right = new BinaryTreeNode(14);
		nodeAtDistanceK.root.right.right.right.left = new BinaryTreeNode(15);
		nodeAtDistanceK.root.right.right.right.right = new BinaryTreeNode(16);
		nodeAtDistanceK.root.left.left.right.left = new BinaryTreeNode(17);
		nodeAtDistanceK.root.left.left.right.right = new BinaryTreeNode(18);
		
		nodeAtDistanceK.printNodesAtDistanceK(nodeAtDistanceK.root, 4);
		
	}

}
