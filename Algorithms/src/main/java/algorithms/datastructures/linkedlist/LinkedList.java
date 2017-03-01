package algorithms.datastructures.linkedlist;

public class LinkedList {

private Node head;

public Node getHead() {
return head;
}

public void setHead(Node head) {
this.head = head;
}

//No. of Nodes - Length of linked List.

public int length(){
int length = 0;
Node currentNode = this.head;
while(currentNode!=null){
currentNode = currentNode.getNextNode();
length++;
}
return length;
}

// Insert Operations.

public void insertAtHead(Object data){

Node newNode = new Node(data);
Node currentNode = this.head;

if(currentNode == null){
this.head = newNode;
}else{
newNode.setNextNode(currentNode);
this.head = newNode;
}

}

public void insertAtTail(Object data){

Node newNode = new Node(data);
Node currentNode = this.head;

if(currentNode == null){
this.head = newNode;
} else{
while(currentNode!=null){
if(currentNode.getNextNode() == null){
currentNode.setNextNode(newNode);
break; // If we don't break the loop, 
       //the program will go into an infinite loop since the next node will always be null.
}
currentNode = currentNode.getNextNode();
}
}
}

public void insertAtIndex(Object data, int index){

int length = length();
Node newNode = new Node(data);
Node currentNode = this.head;

if(index>=length){
index = -1; // Just for the switch statement.
}

if(currentNode==null){
this.head = newNode;
}else{
switch(index){
case 0: insertAtHead(data);
break;
case -1: insertAtTail(data);
break;
default: while(index>1 && currentNode.getNextNode()!=null){
currentNode = currentNode.getNextNode();
index--;
}
newNode.setNextNode(currentNode.getNextNode());
currentNode.setNextNode(newNode);
break;
}
}

}

// Delete Operations.

public void deleteAtHead(){
Node currentNode = this.head;
if(currentNode!=null){
this.head = currentNode.getNextNode();
}

}

public void deleteAtTail(){
Node currentNode = this.head;
while(currentNode!=null){
if(currentNode.getNextNode().getNextNode()==null){
currentNode.setNextNode(null);
break;
}
currentNode = currentNode.getNextNode();
}
}

public void deleteAtIndex(int index){
int length = length();
Node currentNode = this.head;
if(index>=length){
index = -1;
}
switch(index){
case 0: deleteAtHead();
break;
case -1: break;
default: while(index>1 && currentNode.getNextNode()!=null){
currentNode = currentNode.getNextNode();
index--;
}
currentNode.setNextNode(currentNode.getNextNode().getNextNode());

break;

}
}

// Search operations

public Node find(int index){
	Node currentNode = this.head;
	
	while(currentNode!=null && index>0){
		currentNode = currentNode.getNextNode();
		index--;
	}
	
	return currentNode;
	
	
	
}
public Node findMinimum(){
	
	Node currentNode = this.head;
	
	int minimum = (int) currentNode.getData();
	Node minimumElementNode = currentNode;
	while(currentNode!=null){
		if(currentNode.getNextNode()!=null){
		int getNextNodeData = (int)currentNode.getNextNode().getData();
		if(getNextNodeData<minimum){
			minimum = getNextNodeData;
			minimumElementNode = currentNode.getNextNode();
		}
		}
		currentNode = currentNode.getNextNode();
	}
	return minimumElementNode;
	
}

public Node findMaximum(){
	Node currentNode = this.head;
	
	int maximumElement = (int)currentNode.getData();
	Node maximumElementNode = currentNode;
	while(currentNode!=null){
		if(currentNode.getNextNode()!=null){
			int getNextNodeData = (int)currentNode.getNextNode().getData();
			if(getNextNodeData>maximumElement){
				maximumElement = getNextNodeData;
				maximumElementNode = currentNode.getNextNode();
			}
		}
		currentNode = currentNode.getNextNode();
	}
	
	return maximumElementNode;
}

public Node findkthToLastElement(int k){
	
	if(k>=length()){
		return null;
	}else{
	Node kthNode = find(length()-1-k);
	return kthNode;
	}
}
//Additional Functions.

//Reverse a linkedList.

public LinkedList reverseLinkedList(LinkedList linkedList){
	Node currentNode = linkedList.getHead();
	Node previousNode=null;   
	Node nextNode = null;
	  while(currentNode!=null)  
	  {  
	   nextNode=currentNode.getNextNode();  
	   currentNode.setNextNode(previousNode);   
	   previousNode=currentNode;  
	   currentNode = nextNode;
	  }
	  linkedList.setHead(previousNode); 
	  return linkedList;

	}

//Check whether the given linkedList is a palindrome.

public boolean isPalindrome(LinkedList linkedList){
	
	int size = length();
	if(size%2==0){
		return false;
	}
	
	LinkedList reversedLinkedList = reverseLinkedList(linkedList);
	if(linkedList.equals(reversedLinkedList)){
		return true;
	}
		
	return false;
}

//Check if the linkedList has a loop or not.
public boolean hasLoop(LinkedList linkedList){
	
	Node currentNode = linkedList.getHead();
	if(currentNode==null){
		return false;
	}
	Node tortoise = currentNode;
	Node hare = currentNode;
	
	while(true){
			tortoise = currentNode.getNextNode();
			if(currentNode.getNextNode()!=null){
				hare = currentNode.getNextNode().getNextNode();
			}else{
				return false;
			}
			if(tortoise==null||hare==null){
				return false;
			}
			if(tortoise==hare){
				return true;
			}
	}
}

//Check if the linked List is circular or not
public boolean isCircular(LinkedList linkedList){
	Node currentNode;
	Node headNode;
	currentNode = headNode = linkedList.getHead();
	if(currentNode==null){
		return true; //empty linkedlist is circular;
	}
	while(currentNode!=null &&currentNode!=headNode){
		if(currentNode.getNextNode()==headNode){
			return true;
		}
		currentNode = currentNode.getNextNode();
	}
	return false;
}
	

@Override
public String toString() {
StringBuilder sb = new StringBuilder("{");
Node currentNode = this.head;
while(currentNode!=null){
sb.append(currentNode);
if(currentNode.getNextNode()!=null){
sb.append(", ");
}
currentNode = currentNode.getNextNode();
}
sb.append("}");
return sb.toString();
}

}
