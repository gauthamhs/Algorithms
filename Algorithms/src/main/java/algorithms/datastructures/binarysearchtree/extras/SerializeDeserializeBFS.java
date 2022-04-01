package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBFS {
	
	public static String serializeBinaryTreeBFS(BinaryTreeNode root) {
		
		if(root==null) {
			return "null";
		}
		
		StringBuilder sb = new StringBuilder("");
		List<BinaryTreeNode> treeList = new LinkedList<>();
		treeList.add(root);
		
		while(!treeList.isEmpty()) {
			
			BinaryTreeNode node = treeList.remove(0);
			
			if(node==null) {
				sb.append("null").append(",");
			}else {
				sb.append(node.data).append(",");
				treeList.add(node.left);
				treeList.add(node.right);
			}
		}

		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	

	
	public static BinaryTreeNode deserializeBinaryTreeBFS(String s) {
		
		if(s==null || s.isEmpty()){
			return null;
		}
		String[] nodes = s.split(",");
		List<String> treeList = new LinkedList<>(Arrays.asList(nodes));
		return deserializeBinaryTreeBFSHelper(treeList);
	}
	
	public static BinaryTreeNode deserializeBinaryTreeBFSHelper(List<String> treeList) {
		
		Deque<BinaryTreeNode> queue = new ArrayDeque<>();
		BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(treeList.remove(0)));
		BinaryTreeNode currentNode =  root;
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			root = queue.pop();
			BinaryTreeNode left = (treeList.get(0).equals("null")) ? null : new BinaryTreeNode(Integer.valueOf(treeList.get(0)));
			treeList.remove(0);
			BinaryTreeNode right = (treeList.get(0).equals("null")) ? null : new BinaryTreeNode(Integer.valueOf(treeList.get(0)));
			treeList.remove(0);
			
			root.left = left;
			root.right = right;
			
			if(left!=null) {
				queue.add(left);
			}
			if(right!=null) {
				queue.add(right);
			}
		}
		
		return currentNode;
		
	}
	
	public static String serializeTree(BinaryTreeNode root) {
		StringBuilder sb = new StringBuilder("");
		serializeTreeHelper(root, sb);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	public static void serializeTreeHelper(BinaryTreeNode root, StringBuilder sb) {
		if(root==null) {
			sb.append("null,");
			return;
		}
		
		sb.append(root.data).append(",");
		serializeTreeHelper(root.left, sb);
		serializeTreeHelper(root.right, sb);
	}
	
	public static BinaryTreeNode deserializeTree(String serializedTree) {
		if(serializedTree == null) {
			return null;
		}
		String[] splits = serializedTree.split(",");
		Deque<String> stringList = new ArrayDeque<>();
		stringList.addAll(Arrays.asList(splits));
		return deserializeTreeHelper(stringList);

	}
	
	public static BinaryTreeNode deserializeTreeHelper(Deque<String> stringList) {
		if(stringList.peek()=="null") {
			stringList.remove();
			return null;
		}
		
		BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(stringList.remove()));
		root.left = deserializeTreeHelper(stringList);
		root.right = deserializeTreeHelper(stringList);
		
		return root;
		
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(5);
		
		String serializedBinaryTree = SerializeDeserializeBFS.serializeBinaryTreeBFS(root);
		System.out.println(serializedBinaryTree);
		
		BinaryTreeNode deserializedTree = deserializeBinaryTreeBFS(serializedBinaryTree);
		System.out.println(deserializedTree.traversePreOrder(deserializedTree));
		
		String serializedTree = serializeTree(root);
		System.out.println(serializedTree);
		
		BinaryTreeNode deserializedTree1 = deserializeBinaryTreeBFS(serializedTree);
		System.out.println(deserializedTree.traversePreOrder(deserializedTree1));
	}

}
