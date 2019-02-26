package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseLevelOrderTraversal {
	
	BinaryTreeNode root;
	
	List<List<Integer>> reverseLevelOrderTraversalByList(BinaryTreeNode root){
		
		if(root==null) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> nodeList = new ArrayList<>();
		LinkedList<BinaryTreeNode> nodeQueue = new LinkedList<>();
		LinkedList<Integer> nodeStack = new LinkedList<>();
		nodeQueue.add(root);
		nodeQueue.add(null);
		nodeStack.addFirst(null);
		while(!nodeQueue.isEmpty()) {
			
			BinaryTreeNode node = nodeQueue.removeFirst();
			
			if(node==null) {
				nodeQueue.add(null);
				
				node = nodeQueue.removeFirst();
				if(node==null) {
					break;
				}
				nodeStack.addFirst(null);
			} 
			  
				if(node.right!=null) {
					nodeQueue.add(node.right);
				}
				if(node.left!=null) {
					nodeQueue.add(node.left);
				
				
			}
			
			nodeStack.addFirst(node.data);
			
		}
		
		while(!nodeStack.isEmpty()) {
			if(nodeStack.peek()!=null) {
				nodeList.add(nodeStack.removeFirst());
			}else {
				result.add(nodeList);
				nodeList = new ArrayList<>();
				nodeStack.removeFirst();
			}
		}
		

		return result;
		
	}
	
	void reverseLevelOrderTraversal(BinaryTreeNode root){
		
		if(root == null) {
			return ;
		}
		
		LinkedList<BinaryTreeNode> nodeQueue = new LinkedList<>();
		Deque<Integer> stack = new ArrayDeque<>();
		nodeQueue.add(root);
		while(!nodeQueue.isEmpty()) {
			BinaryTreeNode node = nodeQueue.removeFirst();
			
			if(node.right!=null) {
				nodeQueue.add(node.right);
			}
			if(node.left!=null) {
				nodeQueue.add(node.left);
			}
			
			stack.addFirst(node.data);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.removeFirst() + " ");
		}
		
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
		
		ReverseLevelOrderTraversal reverseLevelOrderTraversal = new ReverseLevelOrderTraversal();
		reverseLevelOrderTraversal.root = new BinaryTreeNode(1);
		reverseLevelOrderTraversal.root.left = new BinaryTreeNode(2);
		reverseLevelOrderTraversal.root.right = new BinaryTreeNode(3);
		reverseLevelOrderTraversal.root.left.left = new BinaryTreeNode(4);
		reverseLevelOrderTraversal.root.left.right = new BinaryTreeNode(5);
		reverseLevelOrderTraversal.root.right.left = new BinaryTreeNode(6);
		reverseLevelOrderTraversal.root.right.right = new BinaryTreeNode(7);
		reverseLevelOrderTraversal.root.left.left.left = new BinaryTreeNode(8);
		reverseLevelOrderTraversal.root.left.left.right = new BinaryTreeNode(9);
		reverseLevelOrderTraversal.root.left.right.left = new BinaryTreeNode(10);
		reverseLevelOrderTraversal.root.left.right.right = new BinaryTreeNode(11);
		reverseLevelOrderTraversal.root.right.left.left = new BinaryTreeNode(12);
		reverseLevelOrderTraversal.root.right.left.right = new BinaryTreeNode(13);
		reverseLevelOrderTraversal.root.right.right.right = new BinaryTreeNode(14);
		reverseLevelOrderTraversal.root.right.right.right.left = new BinaryTreeNode(15);
		reverseLevelOrderTraversal.root.right.right.right.right = new BinaryTreeNode(16);
		reverseLevelOrderTraversal.root.left.left.right.left = new BinaryTreeNode(17);
		reverseLevelOrderTraversal.root.left.left.right.right = new BinaryTreeNode(18);
		
		//reverseLevelOrderTraversal.reverseLevelOrderTraversal(reverseLevelOrderTraversal.root);
		List<List<Integer>> reverseNodeList = 
				reverseLevelOrderTraversal.reverseLevelOrderTraversalByList(reverseLevelOrderTraversal.root);
		System.out.println(reverseNodeList);
	}

}
