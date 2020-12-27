package algorithms.datastructures.binarysearchtree.extras;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import algorithms.datastructures.dynamicProgramming.TraverseNDArray;

public class SerializeDeserializeDFS {
	
	BinaryTreeNode root;
	
	
	public static String serializeBinaryTreeDFS(BinaryTreeNode root) {
		StringBuilder sb = new StringBuilder();
		
		serializeBinaryTreeHelperDFS(root, sb);
		return sb.toString();
	}
	
	public static void serializeBinaryTreeHelperDFS(BinaryTreeNode root, StringBuilder sb) {
		if (root==null) {
			sb.append("null,");
			return;
		}
		
		sb.append(root).append(",");
		serializeBinaryTreeHelperDFS(root.left, sb);
		serializeBinaryTreeHelperDFS(root.right, sb);
		
	}
	
	public static BinaryTreeNode deserializeBinaryTreeDFS(String s) {
		
		if(s == null  || s.isEmpty())
			return null;
		
		String[] nodes = s.split(",");
		List<String> nodeList = new LinkedList<>(Arrays.asList(nodes));
		return deserializeBinaryTreeNodeDFSHelper(nodeList);
	}
	
	public static BinaryTreeNode deserializeBinaryTreeNodeDFSHelper(List<String> nodeList) {
		
		if(nodeList.get(0).equals("null")) {
			nodeList.remove(0);
			return null;
		}
		
		BinaryTreeNode treeNode = new BinaryTreeNode(Integer.valueOf(nodeList.get(0)));
		nodeList.remove(0);
		treeNode.left = deserializeBinaryTreeNodeDFSHelper(nodeList);
		treeNode.right = deserializeBinaryTreeNodeDFSHelper(nodeList);
		
		return treeNode;
	}
	

	
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(5);
		
		String serializedBinaryTree = SerializeDeserializeDFS.serializeBinaryTreeDFS(root);
		System.out.println(serializedBinaryTree);
				
		BinaryTreeNode deserializedTree = deserializeBinaryTreeDFS(serializedBinaryTree);
		System.out.println(deserializedTree.traversePreOrder(deserializedTree));
		
	}

}
