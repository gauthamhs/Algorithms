package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SpiralBinaryTree {
	
	BinaryTreeNode root;
	
List<List<Integer>> getSpiralBinaryTreeOneDeque(BinaryTreeNode root){
		
		if(root==null) {
			return Collections.emptyList();
		}
		List<List<Integer>> spiralBinaryTreeList = new ArrayList<>();
		Deque<BinaryTreeNode> orderStack = new ArrayDeque<>();
		Boolean isLeftToRight = true;
		BinaryTreeNode node;
		orderStack.add(root);
		while(!orderStack.isEmpty()) {
			LinkedList<Integer> list = new LinkedList<>();
			int size = orderStack.size();
			
			for(int i=0;i<size;i++) {
				
				node = orderStack.removeFirst();
				if(isLeftToRight) {
					list.addLast(node.data);
				} else { 
					list.addFirst(node.data);
				}
				
				if(node.left!=null) {
					orderStack.add(node.left);
				}
				
				if(node.right!=null) {
					orderStack.add(node.right);
				}
				
			}
			
			isLeftToRight = (isLeftToRight) ? false: true;
			spiralBinaryTreeList.add(list);
			
		}
		
		return spiralBinaryTreeList;
	}

public static List<List<Integer>> getSpiralBinaryTree(BinaryTreeNode root) {
	
	List<List<Integer>> result = new ArrayList<>();
	Deque<BinaryTreeNode> deque = new ArrayDeque<>();
	int level = 0;
	
	deque.add(root);
	boolean isLeft = true;

	
	while(!deque.isEmpty()) {
		
		result.add(new ArrayList<>());
		int queueSize = deque.size();
		
		for(int i=0;i<queueSize;i++) {
			root = deque.removeFirst();
			if(isLeft) {
				result.get(level).add(root.data);
			}else {
				result.get(level).add(0, root.data);

			}
			
			if(root.left!=null) {
				deque.add(root.left);
			}
			
			if(root.right!=null) {
				deque.add(root.right);
			}
		
			
		}
		
		isLeft = (isLeft) ? false : true;
		++level;
		
	}
	
	
	return result;

}
	
	List<List<Integer>> getSpiralBinaryTreeTwoStack(BinaryTreeNode root){
		
		if(root==null) {
			return Collections.emptyList();
		}
		List<List<Integer>> spiralBinaryTreeList = new ArrayList<>();
		Deque<BinaryTreeNode> orderStack = new ArrayDeque<>();
		Deque<BinaryTreeNode> reverseStack = new ArrayDeque<>();
		BinaryTreeNode node;
		orderStack.addFirst(root);
		while(!orderStack.isEmpty() || !reverseStack.isEmpty()) {
			List<Integer> orderNodeList = new ArrayList<>();
			
			while(!orderStack.isEmpty()) {
				node = orderStack.removeFirst();
				orderNodeList.add(node.data);
				
				if(node.left!=null) {
					reverseStack.addFirst(node.left);
				}
				if(node.right!=null) {
					reverseStack.addFirst(node.right);
				}
			}
			
			spiralBinaryTreeList.add(orderNodeList);
			orderNodeList = new ArrayList<>();
			
			if(reverseStack.isEmpty()) {
				break;
			}
			
		while(!reverseStack.isEmpty()) {
			node = reverseStack.removeFirst();
			orderNodeList.add(node.data);
			
			if(node.right!=null) {
				orderStack.addFirst(node.right);
			}
			if(node.left!=null) {
				orderStack.addFirst(node.left);
			}
		}
		

		spiralBinaryTreeList.add(orderNodeList);
		}
		
		return spiralBinaryTreeList;
	}
	
	void printSpiralBinaryTree(BinaryTreeNode root) {
		Deque<BinaryTreeNode> orderStack = new ArrayDeque<>();
		Deque<BinaryTreeNode> reverseStack = new ArrayDeque<>();
		BinaryTreeNode node;
		orderStack.addFirst(root);
		
		while(!orderStack.isEmpty() || !reverseStack.isEmpty()) {
			while(!orderStack.isEmpty()) {
				node = orderStack.removeFirst();
				System.out.print(node + " ");
				
				if(node.left!=null) {
					reverseStack.addFirst(node.left);
				}
				if(node.right!=null) {
					reverseStack.addFirst(node.right);
				}
			}
			
		while(!reverseStack.isEmpty()) {
			node = reverseStack.removeFirst();
			System.out.print(node + " ");
			
			if(node.right!=null) {
				orderStack.addFirst(node.right);
			}
			if(node.left!=null) {
				orderStack.addFirst(node.left);
			}
		}
		}
	}
	
	public static void main(String[] args) {
		SpiralBinaryTree spiralTree = new SpiralBinaryTree();
		spiralTree.root = new BinaryTreeNode(25);
		spiralTree.root.left = new BinaryTreeNode(10);
		spiralTree.root.right = new BinaryTreeNode(70);
		spiralTree.root.left.left = new BinaryTreeNode(5);
		spiralTree.root.left.right = new BinaryTreeNode(20);
		spiralTree.root.right.left = new BinaryTreeNode(60);
		spiralTree.root.right.right = new BinaryTreeNode(90);
		
		//spiralTree.printSpiralBinaryTree(spiralTree.root);
		
		List<List<Integer>> spiralTreeList = spiralTree.getSpiralBinaryTreeTwoStack(spiralTree.root);
		List<List<Integer>> spiralTreeList2 = spiralTree.getSpiralBinaryTreeOneDeque(spiralTree.root);
		List<List<Integer>> spiralTreeList3 = getSpiralBinaryTree(spiralTree.root);
		System.out.println(spiralTreeList);
		System.out.println(spiralTreeList2);
		System.out.println(spiralTreeList3);
		
	}

}
