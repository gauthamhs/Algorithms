package algorithms.datastructures.binarysearchtree.extras;

public class BinaryTreeToDDLInorder {
	
	BinaryTreeNode prev = null;
	BinaryTreeNode head;
	BinaryTreeNode root;
	
	void convertBinaryTreeToLinkedList(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		convertBinaryTreeToLinkedList(root.left);
		
		if(prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		
		convertBinaryTreeToLinkedList(root.right);
		
	}
	
	void printList(BinaryTreeNode node) {
		while(node!=null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeToDDLInorder binaryTreeToDDL = new BinaryTreeToDDLInorder();
		binaryTreeToDDL.root = new BinaryTreeNode(314);
		binaryTreeToDDL.root.left = new BinaryTreeNode(6);
		binaryTreeToDDL.root.right = new BinaryTreeNode(6);
		binaryTreeToDDL.root.left.left = new BinaryTreeNode(271);
		binaryTreeToDDL.root.left.right = new BinaryTreeNode(561);
		binaryTreeToDDL.root.right.left = new BinaryTreeNode(12);
		binaryTreeToDDL.root.right.right = new BinaryTreeNode(0);
		
		binaryTreeToDDL.convertBinaryTreeToLinkedList(binaryTreeToDDL.root);
		binaryTreeToDDL.printList(binaryTreeToDDL.head);
	}

}
