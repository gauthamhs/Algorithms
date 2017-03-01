package algorithms.datastructures.linkedlist;

public class Node {

private Object data;
private Node nextNode;

public Node(){
}

public Node(Object data){
this.data = data;
}

public Object getData() {
return data;
}

public void setData(Object data) {
this.data = data;
}

public Node getNextNode() {
return nextNode;
}

public void setNextNode(Node nextNode) {
this.nextNode = nextNode;
}

@Override
public String toString() {
return this.data.toString() ;
}
}