package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeToDDLBreadth {
		
		BinaryTreeNode prev = null;
		BinaryTreeNode head;
		BinaryTreeNode root;
		
		void convertBinaryTreeToLinkedList(BinaryTreeNode root) {
			Deque<BinaryTreeNode> nodeQueue = new ArrayDeque<>();
			nodeQueue.add(root);
			while(!nodeQueue.isEmpty()) {
				
				 root = nodeQueue.removeFirst();
				
				if(root.left!=null) {
					nodeQueue.add(root.left);
				}
				if(root.right!=null) {
					nodeQueue.add(root.right);
				}
				
				if(prev==null) {
					head = root;
				} else {
					root.left = prev;
					prev.right = root;
				}
				
				prev = root;
				
			}
		}
		
		void printList(BinaryTreeNode node) {
			while(node!=null) {
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
		
		public static void main(String[] args) {
			BinaryTreeToDDLBreadth binaryTreeToDDL = new BinaryTreeToDDLBreadth();
			binaryTreeToDDL.root = new BinaryTreeNode(314);
			binaryTreeToDDL.root.left = new BinaryTreeNode(6);
			binaryTreeToDDL.root.right = new BinaryTreeNode(6);
			binaryTreeToDDL.root.left.left = new BinaryTreeNode(271);
			binaryTreeToDDL.root.left.right = new BinaryTreeNode(561);
			binaryTreeToDDL.root.right.left = new BinaryTreeNode(12);
			binaryTreeToDDL.root.right.right = new BinaryTreeNode(0);
			binaryTreeToDDL.root.right.right.left= new BinaryTreeNode(45);
			binaryTreeToDDL.root.right.right.right= new BinaryTreeNode(100);
			
			binaryTreeToDDL.convertBinaryTreeToLinkedList(binaryTreeToDDL.root);
			binaryTreeToDDL.printList(binaryTreeToDDL.head);
		}

	}



