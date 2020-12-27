package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BreadthFirstSearch {
	BinaryTreeNode root;
	
	List<List<BinaryTreeNode>> breadthFirstSearchJava8(BinaryTreeNode node){
		List<List<BinaryTreeNode>> result = new ArrayList<>();
		if(node == null) {
			return result;
		}
		
		List<BinaryTreeNode> currentNode = Arrays.asList(node);
		while(!currentNode.isEmpty()) {
			result.add(currentNode.stream().collect(Collectors.toList()));
			
			currentNode = currentNode.stream()
					      .map(curr -> Arrays.asList(curr.left, curr.right))
					      .flatMap(List::stream)
					      .filter(child -> child != null)
					      .collect(Collectors.toList());
		}
		return result;
	}
	
	void levelOrderTraversalLineByLine(BinaryTreeNode root) {
		if (root==null) {
			return;
		}
		
		Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root)	;
		nodeQueue.add(null);

		while(!nodeQueue.isEmpty()) {
			BinaryTreeNode node = nodeQueue.poll();
			if(node!=null) {
				if(node.left!=null) {
					nodeQueue.add(node.left);
				}
				if(node.right!=null) {
					nodeQueue.add(node.right);
				}
				
				System.out.print(node.data + " ");
			} else { 
				if(!nodeQueue.isEmpty()) {
					System.out.println();
					nodeQueue.add(null);
				}
			}
		}
	}
	
	List<List<Integer>> levelOrderTraversalListByLevel(BinaryTreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		if (root==null) {
			return result;
		}
		
		Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root)	;
		nodeQueue.add(null);
		List<Integer> nodeList = new ArrayList<>();

		while(!nodeQueue.isEmpty()) {
			BinaryTreeNode node = nodeQueue.poll();
			
			if(node!=null) {
				if(node.left!=null) {
					nodeQueue.add(node.left);
				}
				if(node.right!=null) {
					nodeQueue.add(node.right);
				}
				
				nodeList.add(node.data);
			} else { 
				
				if(!nodeQueue.isEmpty() || !nodeList.isEmpty()) {
					result.add(nodeList);
					nodeQueue.add(null);
					nodeList = new ArrayList<>();
				}
			}
		}
		return result;
	}
	
	void breadthFirstSearch(BinaryTreeNode root) {
		Deque<BinaryTreeNode> nodeQueue = new ArrayDeque<>();
		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty()) {
			BinaryTreeNode printNode = nodeQueue.removeFirst();
			System.out.print(printNode.data + " ");
			if(printNode.left!=null) {
				nodeQueue.add(printNode.left);
			}
			if(printNode.right!=null) {
				nodeQueue.add(printNode.right);
			}
		}
	}
	
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()){
            
            result.add(new ArrayList<Integer>());
            
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                root = queue.remove();
                result.get(level).add(root.data);
                
                if(root.left!=null){
                    queue.add(root.left);
                }
                if(root.right!=null){
                    queue.add(root.right);
                }
            }
            
            ++level;
            
        }
        
        
        return result;
    }
	
	public static void main(String[] args) {
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		breadthFirstSearch.root = new BinaryTreeNode(314);
		breadthFirstSearch.root.left = new BinaryTreeNode(6);
		breadthFirstSearch.root.right = new BinaryTreeNode(6);
		breadthFirstSearch.root.left.left = new BinaryTreeNode(271);
		breadthFirstSearch.root.left.right = new BinaryTreeNode(561);
		breadthFirstSearch.root.right.left = new BinaryTreeNode(12);
		breadthFirstSearch.root.right.right = new BinaryTreeNode(0);
		
		breadthFirstSearch.breadthFirstSearch(breadthFirstSearch.root);
		System.out.println();
		List<List<BinaryTreeNode>> nodes = breadthFirstSearch.breadthFirstSearchJava8(breadthFirstSearch.root);
		System.out.println(nodes);
		System.out.println();
		breadthFirstSearch.levelOrderTraversalLineByLine(breadthFirstSearch.root);
		List<List<Integer>> listByLevel = breadthFirstSearch.levelOrderTraversalListByLevel(breadthFirstSearch.root);
		System.out.println();
		System.out.println("List by Level: " + listByLevel);
		
		List<List<Integer>> levelOrder = breadthFirstSearch.levelOrder(breadthFirstSearch.root);
		System.out.println("Level Order: " + levelOrder);
		
		// Left Side view
		
		List<Integer> leftSideView = new ArrayList<>();
		for(List<Integer> sideList : listByLevel) {
			leftSideView.add(sideList.get(0));
		}
		
		System.out.println("Left side: " + leftSideView);
		
		List<Integer> rightSideView = new ArrayList<>();
		for(List<Integer> sideList : listByLevel) {
			rightSideView.add(sideList.get(sideList.size()-1));
		}
		
		System.out.println("Right side: " + rightSideView);
	}

}
