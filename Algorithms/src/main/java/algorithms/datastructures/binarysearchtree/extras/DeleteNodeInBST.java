package algorithms.datastructures.binarysearchtree.extras;


// To delete a node in BST, we have to do two things: 
// 1) Find the node that we need to delete
// 2) Check for 4 conditions: null(node not present), leaf node, node with left subtree,
//    node with right subtree, node with both trees
// For nodes with 0, 1 child, its easy to delete them. However, for node with 2 children,
// we have to find the successor(largest of left subtree or smallest of right subtree)
public class DeleteNodeInBST {
	
	BinaryTreeNode root;
	
	BinaryTreeNode deleteNodeInBST(BinaryTreeNode root, int key) {
		if(root==null) {
			return null;
		}
		
		if(key<root.data) {
			root.left  = deleteNodeInBST(root.left, key);
		}
		else if(key>root.data) {
			root.right = deleteNodeInBST(root.right, key);
		}
		else {
			if(root.left==null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			}
			
			BinaryTreeNode successor = findSuccessor(root.right);
			root.data = successor.data;
			root.right = deleteNodeInBST(root.right, root.data);
			
		}
		return root;
		
	}
	
	BinaryTreeNode findSuccessor(BinaryTreeNode node) {
		while(node.left!=null) {
			node = node.left;
		}
		
		return node;
		
	}
	
	public static void main(String[] args) {
		
		DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();
		deleteNodeInBST.root = new BinaryTreeNode(50);
		deleteNodeInBST.root.left = new BinaryTreeNode(30);
	   deleteNodeInBST.root.right = new BinaryTreeNode(70);
		
		BinaryTreeNode deleteNode = deleteNodeInBST.deleteNodeInBST(deleteNodeInBST.root, 50);
		System.out.println(deleteNode);
		
		
	}

}
