package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversal {
	
	BinaryTreeNode root;
	
	List<List<Integer>> verticalOrderTraversal(BinaryTreeNode root){
		List<List<Integer>> verticalNodeList = new ArrayList<>();
		
		if(root==null) {
			return verticalNodeList;
		}
		
		Deque<BinaryTreeNode> nodeQueue = new ArrayDeque<>();
		Deque<Integer> distanceFromRootQueue = new ArrayDeque<>();
		nodeQueue.add(root);
		distanceFromRootQueue.add(0);
		
		int minDistanceFromRoot = 0;
		int maxDistanceFromRoot = 0;
		
		Map<Integer, List<Integer>> nodeMap = new HashMap<>();
		
		while(!nodeQueue.isEmpty()) {
			BinaryTreeNode node = nodeQueue.removeFirst();
			Integer distanceFromRoot = distanceFromRootQueue.removeFirst();
			
			minDistanceFromRoot = Math.min(minDistanceFromRoot, distanceFromRoot);
			maxDistanceFromRoot = Math.max(maxDistanceFromRoot, distanceFromRoot);
			
			if(nodeMap.containsKey(distanceFromRoot)) {
				nodeMap.get(distanceFromRoot).add(node.data);
			} else {
				List<Integer> nodeArray = new ArrayList<>();
				nodeArray.add(node.data);
				nodeMap.put(distanceFromRoot, nodeArray);
			}
			
			if(node.left!=null) {
				nodeQueue.add(node.left);
				distanceFromRootQueue.add(distanceFromRoot - 1);
			}
			
			if(node.right!=null) {
				nodeQueue.add(node.right);
				distanceFromRootQueue.add(distanceFromRoot + 1);
			}
			
		}
		
		for(int i = minDistanceFromRoot; i<=maxDistanceFromRoot;i++) {
			if(nodeMap.containsKey(i)) {
				verticalNodeList.add(nodeMap.get(i));
			}
		}
		
		return verticalNodeList;
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
		
		VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
		verticalOrderTraversal.root = new BinaryTreeNode(1);
		verticalOrderTraversal.root.left = new BinaryTreeNode(2);
		verticalOrderTraversal.root.right = new BinaryTreeNode(3);
		verticalOrderTraversal.root.left.left = new BinaryTreeNode(4);
		verticalOrderTraversal.root.left.right = new BinaryTreeNode(5);
		verticalOrderTraversal.root.right.left = new BinaryTreeNode(6);
		verticalOrderTraversal.root.right.right = new BinaryTreeNode(7);
		verticalOrderTraversal.root.left.left.left = new BinaryTreeNode(8);
		verticalOrderTraversal.root.left.left.right = new BinaryTreeNode(9);
		verticalOrderTraversal.root.left.right.left = new BinaryTreeNode(10);
		verticalOrderTraversal.root.left.right.right = new BinaryTreeNode(11);
		verticalOrderTraversal.root.right.left.left = new BinaryTreeNode(12);
		verticalOrderTraversal.root.right.left.right = new BinaryTreeNode(13);
		verticalOrderTraversal.root.right.right.right = new BinaryTreeNode(14);
		verticalOrderTraversal.root.right.right.right.left = new BinaryTreeNode(15);
		verticalOrderTraversal.root.right.right.right.right = new BinaryTreeNode(16);
		verticalOrderTraversal.root.left.left.right.left = new BinaryTreeNode(17);
		verticalOrderTraversal.root.left.left.right.right = new BinaryTreeNode(18);
		
		List<List<Integer>> verticalNodeList = verticalOrderTraversal.verticalOrderTraversal(verticalOrderTraversal.root);
		System.out.println(verticalNodeList);
		
		//Print the top View of the Tree;
		
		List<Integer> topNodes = new ArrayList<>();
		
		for (List<Integer> list : verticalNodeList) {
			topNodes.add(list.get(0));
		}
		
		System.out.println("Top View: " + topNodes);
		
		
		//Print the bottom View of the tree.
		
		List<Integer> bottomNodes = new ArrayList<>();
		
		for (List<Integer> list : verticalNodeList) {
			bottomNodes.add(list.get(list.size()-1));
		}
		
		System.out.println("Bottom View: " + bottomNodes);
		
	}

}
