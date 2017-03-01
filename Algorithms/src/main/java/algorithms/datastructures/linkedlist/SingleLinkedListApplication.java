package algorithms.datastructures.linkedlist;

public class SingleLinkedListApplication {

public static void main(String[] args) {
LinkedList linkedList = new LinkedList();
linkedList.insertAtHead(10);
linkedList.insertAtHead(20);
linkedList.insertAtTail(47);
linkedList.insertAtHead(8);
linkedList.insertAtHead(50);
linkedList.insertAtHead(22);
linkedList.insertAtHead(5);
linkedList.deleteAtHead();
linkedList.deleteAtTail();
linkedList.insertAtIndex(63, 1);
//linkedList.deleteAtIndex(0);

System.out.println(linkedList);
System.out.println(linkedList.length());
System.out.println(linkedList.findMinimum());
System.out.println(linkedList.findMaximum());
System.out.println(linkedList.find(5));
System.out.println(linkedList.findkthToLastElement(2));


LinkedList reversedLinkedList = linkedList.reverseLinkedList(linkedList);
System.out.println(reversedLinkedList);

LinkedList linkedList2 = new LinkedList();
linkedList2.insertAtHead(1);
linkedList2.insertAtHead(3);
linkedList2.insertAtHead(5);
linkedList2.insertAtHead(3);
linkedList2.insertAtHead(1);
System.out.println(linkedList2);
System.out.println(linkedList2.isPalindrome(linkedList2));





}
}
