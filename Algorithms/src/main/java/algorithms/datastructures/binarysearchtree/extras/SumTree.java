package algorithms.datastructures.binarysearchtree.extras;

public class SumTree {
	
	BinaryTreeNode root;
	
	boolean isSumTree(BinaryTreeNode root) {
		if(root==null) {
			return true;
		}
		
		if(root.left==null && root.right==null) {
			return true;
		}
		
		int leftSum = sumTree(root.left);
		int rightSum = sumTree(root.right);
		int totalSum = leftSum + rightSum;
		
		if(totalSum == root.data) {
			if(isSumTree(root.left) && isSumTree(root.right)) {
				return true;
			}
		}
		
		return false;
	}
	
	public int sumTree(BinaryTreeNode root) {
		
		if(root==null) {
			return 0;
		}
		
		int sum = root.data + sumTree(root.left) + sumTree(root.right);
		
		return sum;
		
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
		
		SumTree sumTree = new SumTree();
		sumTree.root = new BinaryTreeNode(1);
		sumTree.root.left = new BinaryTreeNode(2);
		sumTree.root.right = new BinaryTreeNode(3);
		sumTree.root.left.left = new BinaryTreeNode(4);
		sumTree.root.left.right = new BinaryTreeNode(5);
		sumTree.root.right.left = new BinaryTreeNode(6);
		sumTree.root.right.right = new BinaryTreeNode(7);
		sumTree.root.left.left.left = new BinaryTreeNode(8);
		sumTree.root.left.left.right = new BinaryTreeNode(9);
		sumTree.root.left.right.left = new BinaryTreeNode(10);
		sumTree.root.left.right.right = new BinaryTreeNode(11);
		sumTree.root.right.left.left = new BinaryTreeNode(12);
		sumTree.root.right.left.right = new BinaryTreeNode(13);
		sumTree.root.right.right.right = new BinaryTreeNode(14);
		sumTree.root.right.right.right.left = new BinaryTreeNode(15);
		sumTree.root.right.right.right.right = new BinaryTreeNode(16);
		sumTree.root.left.left.right.left = new BinaryTreeNode(17);
		sumTree.root.left.left.right.right = new BinaryTreeNode(18);
		
		int sum = sumTree.sumTree(sumTree.root);
		System.out.println(sum);
		
		SumTree sumTree2 = new SumTree();
		sumTree2.root = new BinaryTreeNode(314);
		sumTree2.root.left = new BinaryTreeNode(200);
		sumTree2.root.right = new BinaryTreeNode(114);
		
		boolean isSumTree = sumTree.isSumTree(sumTree2.root);
		System.out.println(isSumTree);
	}

}
