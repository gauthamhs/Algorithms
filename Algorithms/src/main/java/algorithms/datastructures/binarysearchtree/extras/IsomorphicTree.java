package algorithms.datastructures.binarysearchtree.extras;

public class IsomorphicTree {
	
	BinaryTreeNode root;
	
	boolean isIsoMorphic(BinaryTreeNode root1, BinaryTreeNode root2) {
		
		if(root1==null && root2==null) {
			return true;
		}

		if(root1==null || root2==null) {
			return false;
		}
		
		if(root1.data!=root2.data) {
			return false;
		}
		

		
		return ((isIsoMorphic(root1.left, root2.left)&&isIsoMorphic(root1.right, root2.right)) ||
				(isIsoMorphic(root1.left, root2.right)&&isIsoMorphic(root1.right, root2.left)));
	}
	
	public static void main(String[] args) {
		IsomorphicTree isomorphicTree1 = new IsomorphicTree();
		isomorphicTree1.root = new BinaryTreeNode(1);
		isomorphicTree1.root.left = new BinaryTreeNode(2);
		isomorphicTree1.root.right = new BinaryTreeNode(3);
		isomorphicTree1.root.left.left = new BinaryTreeNode(4);
		isomorphicTree1.root.left.right = new BinaryTreeNode(5);
		isomorphicTree1.root.left.left.left = new BinaryTreeNode(8);
		isomorphicTree1.root.left.left.right = new BinaryTreeNode(9);
		isomorphicTree1.root.left.right.left = new BinaryTreeNode(6);
		isomorphicTree1.root.left.right.right = new BinaryTreeNode(7);
		
		IsomorphicTree isomorphicTree2 = new IsomorphicTree();
		isomorphicTree2.root = new BinaryTreeNode(1);
		isomorphicTree2.root.left = new BinaryTreeNode(3);
		isomorphicTree2.root.right = new BinaryTreeNode(2);
		isomorphicTree2.root.right.left = new BinaryTreeNode(5);
		isomorphicTree2.root.right.right = new BinaryTreeNode(4);
		isomorphicTree2.root.right.left.left = new BinaryTreeNode(7);
		isomorphicTree2.root.right.left.right = new BinaryTreeNode(6);
		isomorphicTree2.root.right.right.left = new BinaryTreeNode(8);
		isomorphicTree2.root.right.right.right = new BinaryTreeNode(9);
		
		
		boolean isIsomorph = isomorphicTree1.isIsoMorphic(isomorphicTree1.root, isomorphicTree2.root);
		System.out.println(isIsomorph);
		
	}

}
