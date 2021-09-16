package algorithms.datastructures.design;


/* package whatever; // don't place package name! */

import java.util.HashMap;

class LinkedListNode {
	int value;
	int key;
	LinkedListNode prev;
	LinkedListNode next;
}

public class LRUCacheDLL {

	HashMap<Integer, LinkedListNode> hashmap;
	LinkedListNode head, tail;
	int LRU_SIZE = 10; // Here i am setting 4 to test the LRU cache
						// implementation, it can make be dynamic
	public LRUCacheDLL() {
		hashmap = new HashMap<Integer, LinkedListNode>();
	}

	public int getEntry(int key) {
		if (hashmap.containsKey(key)) // Key Already Exist, just update the existing one
		{
			LinkedListNode node = hashmap.get(key);
			removeNode(node);
			addAtTop(node);
			return node.value;
		}
		return -1;
	}

	public void putEntry(int key, int value) {
		if (hashmap.containsKey(key)) // Key Already Exist, just update the value and move it to top
		{
			LinkedListNode node = hashmap.get(key);
			node.value = value;
			removeNode(node);
			addAtTop(node);
		} else {
			LinkedListNode newnode = new LinkedListNode();
			newnode.prev = null;
			newnode.next = null;
			newnode.value = value;
			newnode.key = key;
			if (hashmap.size() > LRU_SIZE) // We have reached maximum size so need to make room for new element.
			{
				hashmap.remove(tail.key);
				removeNode(tail);				
			}

			addAtTop(newnode);
			hashmap.put(key, newnode);
		}
	}
	public void addAtTop(LinkedListNode node) {
		node.next = head;
		node.prev = null;
		if (head != null)
			head.prev = node;
		head = node;
		if (tail == null)
			tail = head;
	}

	public void removeNode(LinkedListNode node) {

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}
	
	public Integer getHead() {
		return head.value;
	}
	
	public Integer getTail() {
		return tail.value;
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		LRUCacheDLL lrucache = new LRUCacheDLL();
		lrucache.putEntry(1, 1);
		lrucache.putEntry(1, 16);
		lrucache.putEntry(10, 15);
		lrucache.putEntry(15, 10);
		lrucache.putEntry(10, 16);
		lrucache.putEntry(12, 15);
		lrucache.putEntry(18, 10);
		lrucache.putEntry(13, 16);
		

		System.out.println(lrucache.getEntry(1));
		System.out.println(lrucache.getEntry(10));
		System.out.println(lrucache.getEntry(15));
		System.out.println(lrucache.getHead());
		System.out.println(lrucache.getTail());

	}
}