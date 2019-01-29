package algorithms.datastructures.linkedlist;

public interface SinglyLinkedList {
/*	For a Linked List, Search operations take O(n) time since we have to search for an element sequentially.
	Whereas, add and delete operations take O(1) time since we can reuse existing node to to the same.*/
	
	/*General Operations*/
	public int lengthOfList();
	public int getNodeLength(Node list);
	public Node advanceListbyK(Node list, int k);

	
	/*Find Operations*/
	public Node findNode(Node node);
	public boolean isNodePresent(Node node);
	public Node findMidNode(Node node);
	public Node findNodeAtIndex(int index);
	public Node findMaximum();
	public Node findMinimum();
	public Node findKthToLastElementHard(int k);
	public Node findKthToLastElementEasy(Node node, int k);
	
	
	/*Insert Operations*/
/*	The insert and delete operations in a Linkedlist takes O(1) time, but the search operation
	takes O(n) time since the elements have to be searched sequentially.*/
	
	public void insertAtHead(Node newNode);
	public void insertAtTail(Node newNode);
	public void insertAtIndex(Node newNode, int index);
	public void insertBefore(Node node, Node newNode);
	public void insertAfter(Node node, Node newNode);
	public SinglyLinkedListImpl addAll(int[] nodes);
	
	/*Delete Operations*/
	
	public void deleteAtHead();
	public void deleteAtTail();
	public void deleteAtIndex(int index);
	public void deleteKthNodeTwoTraversal(int k);
	public Node deleteKthNodeSingleTraversal(Node node, int k);
	public Node deleteDuplicatesSortedArray(Node node);
	public Node deleteDuplicatesUnsortedArray(Node node);
	
	/*Rotate Operations*/
	
	public Node rotateLinkedListRight(Node node, int rotateBy);
	public Node rotateLinkedListLeft(Node node, int rotateBy);
	public Node rotateByNode(Node list, Node nodeToBeRotatedBy);
	
	/*Additional Operations*/
	
	public boolean isPalindrome(Node linkedList);
	public Node mergeTwoLinkedLists(Node linkedList1, Node linkedList2);
	public Node reverseSublist(Node list, int startIndex, int endIndex);
	public SinglyLinkedListImpl reverseLinkedList(SinglyLinkedListImpl linkedList);
	public Node reverseNode(Node list);
	public Node hasCycle(Node head);
	public Node hasOverlappingListCycleFree(Node list1, Node list2);
	public Node evenOddMerge(Node list);
	public Node listPivot(Node list, int pivot);
	public Node swapNodesPairwise(Node node);
	public Node addTwoNumbers(Node list1, Node list2);
	
}


