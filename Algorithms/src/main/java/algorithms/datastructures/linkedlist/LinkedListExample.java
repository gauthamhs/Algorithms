package algorithms.datastructures.linkedlist;

public class LinkedListExample { 
  
     static Node head; 
  
     static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
    /* Function to reverse the linked list */
    Node reverse(Node node) { 
        Node prev = null; 
        Node current = node; 
        Node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    } 
  
    // prints content of linked list 
    void printList(Node node) { 
        while (node != null) { 
            if((node.next==null)) {
            	System.out.print(node.data); 
            }else {
            	System.out.print(node.data + "-->");
            }
            node = node.next; 
            
        } 
    } 
  
    public static void main(String[] args) { 
    	
        LinkedListExample list = new LinkedListExample();
        LinkedListExample.head = new Node(85); 
        LinkedListExample.head.next = new Node(15); 
        LinkedListExample.head.next.next = new Node(4); 
        LinkedListExample.head.next.next.next = new Node(20); 
          
        System.out.println("Given Linked list"); 
        list.printList(head); 
        head = list.reverse(head); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        list.printList(head); 
    } 
} 