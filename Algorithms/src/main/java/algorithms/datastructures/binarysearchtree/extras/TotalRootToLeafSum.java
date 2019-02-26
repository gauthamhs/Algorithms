package algorithms.datastructures.binarysearchtree.extras;

public class TotalRootToLeafSum {
	
	BinaryTreeNode root;
	
	int totalSumRootToLeaf(BinaryTreeNode root) {
		return totalSumRootToLeafHelper(root, 0);
		}
	
	int totalSumRootToLeafHelper(BinaryTreeNode root, int sum){
		if(root==null) {
			return 0;
		}
		
		sum = sum*10 + root.data;
		if(root.left==null&&root.right==null) {
			return sum;
		}
		
		return totalSumRootToLeafHelper(root.left, sum) + totalSumRootToLeafHelper(root.right, sum);
		
	}
	
	public boolean checkIfTreeHasSum(BinaryTreeNode root, int target) {
		if(root==null) {
			return false;
		}
		
		if(root.left == null && root.right == null) {
			return target == root.data;
		}
		
		return checkIfTreeHasSum(root.left, target-root.data) || checkIfTreeHasSum(root.right, target-root.data);
	}
	
	public static void main(String[] args) {
		/*               1
		/*            /     \
		 *          2          3
		 *        /  \        /  \
		 *       4    5      6    7 
		 *        
		 */
		
		TotalRootToLeafSum totalRootToLeafSum = new TotalRootToLeafSum();
		totalRootToLeafSum.root = new BinaryTreeNode(1);
		totalRootToLeafSum.root.left = new BinaryTreeNode(2);
		totalRootToLeafSum.root.right = new BinaryTreeNode(3);
		totalRootToLeafSum.root.left.left = new BinaryTreeNode(4);
		totalRootToLeafSum.root.left.right = new BinaryTreeNode(5);
		totalRootToLeafSum.root.right.left = new BinaryTreeNode(6);
		totalRootToLeafSum.root.right.right = new BinaryTreeNode(7);
		
		int sum = totalRootToLeafSum.totalSumRootToLeaf(totalRootToLeafSum.root);
		System.out.println(sum);
		
		boolean checkSum = totalRootToLeafSum.checkIfTreeHasSum(totalRootToLeafSum.root, 11);
		System.out.println(checkSum);
	}

}
