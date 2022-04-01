package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementsBST {
	private BinaryTreeNode root;
	
	public static List<Integer> kthLargestElements(BinaryTreeNode root, Integer k){
		List<Integer> result = new ArrayList<>();
		kthLargestElementHelper(root, result, k);
		return result;
	}
	
	public static void kthLargestElementHelper(BinaryTreeNode root, List<Integer> result, Integer k) {
		if(root==null || result.size()==k) {
			return;
		}
		
		kthLargestElementHelper(root.right, result, k);
		
		if(result.size()<k) result.add(root.data);
		
		kthLargestElementHelper(root.left, result, k);
		
		
	}
	
	public static void main(String[] args) {
		KthLargestElementsBST kthLargestElement = new KthLargestElementsBST();
		kthLargestElement.root = new BinaryTreeNode(50);
		kthLargestElement.root.left = new BinaryTreeNode(10);
		kthLargestElement.root.right = new BinaryTreeNode(100);
		kthLargestElement.root.left.left = new BinaryTreeNode(5);
		kthLargestElement.root.left.right = new BinaryTreeNode(15);
		kthLargestElement.root.right.left = new BinaryTreeNode(6);
		kthLargestElement.root.right.right = new BinaryTreeNode(35);

		System.out.println(kthLargestElements(kthLargestElement.root, 3));
	}

}
