package algorithms.datastructures.linkedlist;

public class Node {
	
	public Object data;
	public Node nextNode;
	
	public Node() {
	}
	
	public Node(Object data) {
		this.data = data;
		this.nextNode = null;
	}
	
	public Node(Object data, Node nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}
	
	
	@Override
	public String toString(){
		return this.data.toString();
	}
}
