package algorithms.datastructures.binarysearchtree.extras;


// A BST is similar to a Doubly linked list in the sense that both have two children. left-right and prev-next.
// In this case, we can just use a DDL as a BST. The algorithm to convert BST to DLL is as follows:

// We need to sort them in ascending order. Therefore we need to perform an inorder traversal
// We need to first check if we are at the first node(prev=null). If yes, then make currentNode = root(head node)
// If not, Then we need to set prev and next pointers in place.
// In both cases move prev pointer to root.
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
