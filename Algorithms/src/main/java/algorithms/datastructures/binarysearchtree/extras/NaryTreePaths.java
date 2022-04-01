package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class Node{
	List<Node> children;
	int label;
	
	Node(){
		
	}
	
	Node(int label){
		this.label = label;
	}
	
	Node(List<Node> children, int label){
		this.children = children;
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "" + this.label;
	}
	
}

public class NaryTreePaths {
	
	public static List<List<Node>> NaryTreeAllPaths(Node startNode, Node targetNode) {
		List<List<Node>> result = new ArrayList<>();
		NaryTreePathHelper(startNode, targetNode, result, new ArrayList<>());
		return result;
	}
	
	public static void NaryTreePathHelper(Node startNode, Node targetNode, List<List<Node>> result, List<Node> tempList) {
		
		tempList.add(startNode);
		
		if(startNode.equals(targetNode)) {
			result.add(new ArrayList<>(tempList));
		}else {
			for(Node child : startNode.children) {
				NaryTreePathHelper(child, targetNode, result, tempList);
			}
		}
		

		tempList.remove(tempList.size()-1);
		
		
		
	}
	
	public static void main(String[] args) {
		
		//    2
	    //   / \
		//  4   5
		// /   
		// 5
		
		Node node5 = new Node(5);
		Node node4 = new Node(Collections.singletonList(node5), 4);
		Node node2 = new Node(Arrays.asList(node4, node5), 2);
		
		List<List<Node>> allPaths = NaryTreePaths.NaryTreeAllPaths(node2, node5);
		System.out.println(allPaths);
		
		
	}
	

}
