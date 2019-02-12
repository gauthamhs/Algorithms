package algorithms.datastructures.binarysearchtree.extras;

public class BinaryTreeMirror {
	
	BinaryTreeNode root;
	
	Boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root1==null && root2==null) {
			return true;
		}
		
		if(root1==null || root2==null) {
			return false;
		}
		
		if(root1.data == root2.data) {
			if((isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left))) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		BinaryTreeMirror binaryMirrorTree1 = new BinaryTreeMirror();
		binaryMirrorTree1.root = new BinaryTreeNode(314);
		binaryMirrorTree1.root.left = new BinaryTreeNode(6);
		binaryMirrorTree1.root.right = new BinaryTreeNode(12);
		
		BinaryTreeMirror binaryMirrorTree2 = new BinaryTreeMirror();
		binaryMirrorTree2.root = new BinaryTreeNode(314);
		binaryMirrorTree2.root.left = new BinaryTreeNode(6);
		binaryMirrorTree2.root.right = new BinaryTreeNode(12);
		
		BinaryTreeMirror binaryMirrorTree3 = new BinaryTreeMirror();
		binaryMirrorTree3.root = new BinaryTreeNode(314);
		binaryMirrorTree3.root.left = new BinaryTreeNode(12);
		binaryMirrorTree3.root.right = new BinaryTreeNode(6);
		
		boolean isMirror1 = binaryMirrorTree1.isMirror(binaryMirrorTree1.root, binaryMirrorTree2.root);
		System.out.println(isMirror1);
		
		boolean isMirror2 = binaryMirrorTree1.isMirror(binaryMirrorTree1.root, binaryMirrorTree3.root);
		System.out.println(isMirror2);
		
	}

}
