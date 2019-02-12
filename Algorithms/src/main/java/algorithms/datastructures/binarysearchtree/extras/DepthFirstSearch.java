package algorithms.datastructures.binarysearchtree.extras;

public class DepthFirstSearch {
	
	BinaryTreeNode root;
	void depthFirstSearch(BinaryTreeNode root) {
			System.out.print(root.data + " ");
			if(root.left!=null) {
				depthFirstSearch(root.left);
			}
			if(root.right!=null) {
				depthFirstSearch(root.right);
			}
		
	}

	
	public static void main(String[] args) {
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		depthFirstSearch.root = new BinaryTreeNode(314);
		depthFirstSearch.root.left = new BinaryTreeNode(6);
		depthFirstSearch.root.right = new BinaryTreeNode(6);
		depthFirstSearch.root.left.left = new BinaryTreeNode(271);
		depthFirstSearch.root.left.right = new BinaryTreeNode(561);
		depthFirstSearch.root.right.left = new BinaryTreeNode(12);
		depthFirstSearch.root.right.right = new BinaryTreeNode(0);
		
		depthFirstSearch.depthFirstSearch(depthFirstSearch.root);
		System.out.println();
	}

}
