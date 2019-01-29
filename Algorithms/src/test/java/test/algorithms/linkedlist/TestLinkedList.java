package test.algorithms.linkedlist;

import org.junit.Before;
import org.junit.Test;

import algorithms.datastructures.linkedlist.Node;
import algorithms.datastructures.linkedlist.SinglyLinkedListImpl;

public class TestLinkedList {
	
	private SinglyLinkedListImpl linkedListMain;
	
	@Before
	public void setup(){
		linkedListMain = new SinglyLinkedListImpl();
	}
	
	@Test
	public void testInsertion() {
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl();
		linkedList.insertAtHead(new Node(10));
		linkedList.insertAtHead(new Node(20));
		linkedList.insertAtTail(new Node(30));
		linkedList.insertAtTail(new Node(40));
		linkedList.insertAtTail(new Node(3));
		linkedList.insertAtTail(new Node(80));
		linkedList.insertAtTail(new Node(16));
		linkedList.insertAtIndex(new Node(50), 2);
		linkedList.insertAfter(new Node(50), new Node(100));
		linkedList.insertBefore(new Node(50), new Node(70));
		
		System.out.println(linkedList);	
		
	}
	
	@Test
	public void testGetLength() {
		
		int[] nodes= {10, 30, 50, 70, 90};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		System.out.println("List: " + linkedList);
		System.out.println("Length of the List: " + linkedList.lengthOfList());	
		
	}
	
	@Test
	public void testAdvanceStepsByK() {
		
		int[] nodes = {10,20,30,40,3,80};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		
		System.out.println("Original List: " + linkedList);
		
		Node advancedList = linkedList.advanceListbyK(linkedList.head, 3);
		SinglyLinkedListImpl advancedLinkedList = new SinglyLinkedListImpl();
		advancedLinkedList.insertAtHead(advancedList);
		System.out.println("List advanced by 3 steps: " + advancedLinkedList);

	}
	
	@Test
	public void testFindOperations() {
		int[] nodes = {20, 50, 100 ,120, 150, 180, 200, 220};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		Node findNode2 = linkedList.findNode(new Node(100));
		
		Boolean isNodePresent = linkedList.isNodePresent(new Node(120));
		System.out.println("Is node 120 present: " + isNodePresent);
		
		System.out.println("Find node: " + findNode2);
		
		Node midNode = linkedList.findMidNode(linkedList.head);
		System.out.println("Middle Element: " + midNode);
		
		Node maximumNode = linkedList.findMaximum();
		Node minimumNode = linkedList.findMinimum();
		
		System.out.println("Maximum Element: " + maximumNode);
		System.out.println("Minimum Element: " + minimumNode);
		
		Node findAtIndex =  linkedList.findNodeAtIndex(2);
		System.out.println("Node at Index 2: " + findAtIndex);
		
		Node findKthfromLast = linkedList.findKthToLastElementHard(0);
		System.out.println("Element 1 from last: " + findKthfromLast);
		
		Node findKthfromLastEasy = linkedList.findKthToLastElementEasy(linkedList.head, 2);
		System.out.println("Element 2 from last: " + findKthfromLastEasy);
			
	}
	
	@Test
	public void testDeleteOperations() {
		int[] nodes = {20, 50, 100 ,120, 150, 180, 200, 220};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		System.out.println("Original Linked List: " + linkedList);
		linkedList.deleteAtHead();
		linkedList.deleteAtTail();
		linkedList.deleteAtIndex(2);
		System.out.println("Linked List after Deletion: " + linkedList);	
	}
	
	@Test
	public void testDeleteDuplicates() {
		int[] nodes = {20, 50, 50 ,120, 120, 180, 200, 200};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		System.out.println("Duplicate List: " + linkedList);
		Node uniqueNode = linkedList.deleteDuplicatesSortedArray(linkedList.head);
		
		SinglyLinkedListImpl uniqueList = new SinglyLinkedListImpl();
		uniqueList.insertAtHead(uniqueNode);
		System.out.println("Distinct List: " + uniqueList);
		
	}
	
	@Test
	public void testDeleteDuplicatesUnsortedArray() {
		int[] nodes = {1,3,3,3,5,6,4,2,3,2,1,3,4,2,1,35,2,4,3,2,1,2};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		System.out.println("Duplicate List: " + linkedList);
		Node uniqueNode = linkedList.deleteDuplicatesUnsortedArray(linkedList.head);
		
		SinglyLinkedListImpl uniqueList = new SinglyLinkedListImpl();
		uniqueList.insertAtHead(uniqueNode);
		System.out.println("Distinct List: " + uniqueList);
		
	}
	
	@Test
	public void testDeleteKthNode() {
		int[] nodes = {20, 50, 100 ,120, 150, 180, 200, 220};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		System.out.println("Original List: " + linkedList);
		Node deletedNode = linkedList.deleteKthNodeSingleTraversal(linkedList.head, 7);
		SinglyLinkedListImpl linkedListDeleted = new SinglyLinkedListImpl();
		linkedListDeleted.insertAtHead(deletedNode);
		System.out.println("List with K node deleted: " + linkedListDeleted);	
		
	}
	
	@Test
	public void testRotateList() {
		
		int[] nodes = {20, 50, 100 ,120, 150, 180, 200, 220};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		System.out.println("Original List: " + linkedList);
		
		Node rotatedListRight = linkedList.rotateLinkedListRight(linkedList.head, 3);
		SinglyLinkedListImpl linkedListRotatedRight = new SinglyLinkedListImpl();
		linkedListRotatedRight.insertAtHead(rotatedListRight);
		System.out.println("Right Rotate by 3 positions: " + linkedListRotatedRight);
		
		Node rotatedListLeft = linkedListRotatedRight.rotateLinkedListLeft(linkedListRotatedRight.head, 2);
		SinglyLinkedListImpl linkedListRotatedLeft = new SinglyLinkedListImpl();
		linkedListRotatedLeft.insertAtHead(rotatedListLeft);
		System.out.println("Left Rotate by 2 positions: " + linkedListRotatedLeft);
		
		Node rotateAroundNode = linkedListRotatedLeft.rotateByNode(linkedListRotatedLeft.head, new Node(120));
		SinglyLinkedListImpl linkedListRotatedAroundNode = new SinglyLinkedListImpl();
		linkedListRotatedAroundNode.insertAtHead(rotateAroundNode);
		System.out.println("Rotated Around Node 120: " + linkedListRotatedAroundNode);
		
	}
	
	@Test
	public void testPalindrome() {
		int[] nodes = {20, 50, 100 ,120, 150, 180, 200, 220};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		boolean isPalindrome = linkedList.isPalindrome(linkedList.head);
		System.out.println("Is first List a palindrome?: " + isPalindrome);
		
		int[] nodes2 = {20, 50, 100 ,120, 120, 100, 50, 20};
		SinglyLinkedListImpl linkedList2 = new SinglyLinkedListImpl().addAll(nodes2);
		boolean isPalindrome2 = linkedList.isPalindrome(linkedList2.head);
		System.out.println("Is second List a palindrome?: " + isPalindrome2);
		
	}
	
	@Test
	public void testmergeTwoLinkedLists() {
		int[] nodes = {20, 50, 150, 180, 200};
		int[] nodes2 = {10, 20 ,40, 50, 90, 240};
		
		SinglyLinkedListImpl linkedList1 = new SinglyLinkedListImpl().addAll(nodes);
		SinglyLinkedListImpl linkedList2 = new SinglyLinkedListImpl().addAll(nodes2);
		
		System.out.println("LinkedList1: "+ linkedList1);
		System.out.println("LinkedList2: "+ linkedList2);
		
		SinglyLinkedListImpl mergedLinkedList = new SinglyLinkedListImpl();
		
		Node mergedLinkedListNode = linkedListMain.mergeTwoLinkedLists(linkedList1.head, linkedList2.head);
		mergedLinkedList.insertAtHead(mergedLinkedListNode);
		System.out.println("Merged LinkedList: " + mergedLinkedList);
		
	}
	
	@Test
	public void testReverseSublist() {
		int[] nodes = {20, 50, 150, 180, 200};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		
		System.out.println("Original List: " + linkedList);
		
		Node reversedList = linkedList.reverseSublist(linkedList.head, 0, 2);
		SinglyLinkedListImpl reversedLinkedList = new SinglyLinkedListImpl();
		reversedLinkedList.insertAtHead(reversedList);
		System.out.println("Reversed sublist from 0th to 2nd Position: " + reversedLinkedList);
		
	}
	
	@Test
	public void testReverseNode() {
		
		int[] nodes = {20, 50, 150, 180, 200};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		
		System.out.println("Original List: " + linkedList);
		
		Node reverseNode = linkedListMain.reverseNode(linkedList.head);
		SinglyLinkedListImpl reversedLinkedList = new SinglyLinkedListImpl();
		reversedLinkedList.insertAtHead(reverseNode);
		
		System.out.println("Reversed Node: " + reversedLinkedList);
		
	}
	
	@Test
	public void testEvenOddMerge() {
		
		int[] nodes = {20, 50, 150, 180, 200};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		
		System.out.println("Original List: " + linkedList);
		
		Node evenOddMergeNode = linkedListMain.evenOddMerge(linkedList.head);
		SinglyLinkedListImpl evenOddMergedLinkedList = new SinglyLinkedListImpl();
		evenOddMergedLinkedList.insertAtHead(evenOddMergeNode);
		System.out.println("Even-Odd Merged List: " + evenOddMergedLinkedList);
		
	}
	
	@Test
	public void testPivot() {
		
		int[] nodes = {3, 2, 2, 11, 7, 5, 11};
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		
		System.out.println("Original List: " + linkedList);
		Node pivot = linkedListMain.listPivot(linkedList.head, 5);
		SinglyLinkedListImpl pivotLinkedList = new SinglyLinkedListImpl();
		pivotLinkedList.insertAtHead(pivot);
		System.out.println("Pivot List: " + pivotLinkedList);
		
	}
	
	@Test
	public void testSwapNodesPairwise() {
		int[] nodes = {10, 20, 30, 40, 50};
        SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl().addAll(nodes);
		
		System.out.println("Original List: " + linkedList);
		
		Node swappedPairNode = linkedListMain.swapNodesPairwise(linkedList.head);
		
		SinglyLinkedListImpl swappedPairLinkedList = new SinglyLinkedListImpl();
		swappedPairLinkedList.insertAtHead(swappedPairNode);
		System.out.println("Swapped Pair List: " + swappedPairLinkedList);
	}
	
	@Test
	public void testAddTwoNumbers() {
	
		int[] nodes1 = {7, 8, 7};
        SinglyLinkedListImpl linkedList1 = new SinglyLinkedListImpl().addAll(nodes1);
        
		int[] nodes2 = {2, 4, 9};
        SinglyLinkedListImpl linkedList2 = new SinglyLinkedListImpl().addAll(nodes2);
        
        Node addNode = linkedListMain.addTwoNumbers(linkedList1.head, linkedList2.head);
		SinglyLinkedListImpl addLinkedList = new SinglyLinkedListImpl();
		addLinkedList.insertAtHead(addNode);
		System.out.println("Addition of Two Nodes: " + addLinkedList);
		
	}
	

}
