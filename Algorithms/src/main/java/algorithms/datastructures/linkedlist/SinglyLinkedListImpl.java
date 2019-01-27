package algorithms.datastructures.linkedlist;

/*Implementation of all functionalities of a linkedList
*/

public class SinglyLinkedListImpl implements SinglyLinkedList {

	public Node head;

	@Override
	public int lengthOfList() {
		int count = 0;
		Node currentNode = head;
		
			while (currentNode!= null) {
				count++;
				currentNode = currentNode.nextNode;
				
			}
		
		return count;

	}
	
	@Override
	public int getNodeLength(Node list) {
		int length = 0;
		while(list!=null) {
			list = list.nextNode;
			++length;
		}
		return length;
	}
	
	@Override 
	public Node advanceListbyK(Node list, int k) {
		while(k>0) {
			list = list.nextNode;
			k--;
		}
		return list;
		
	}
	
	@Override
	public SinglyLinkedListImpl addAll( int[] nodes) {
		
		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl();
		for(int i:nodes) {
			linkedList.insertAtTail(new Node(i));
		}
		
		return linkedList;
		
	}

	@Override
	public void insertAtHead(Node newNode) {
		
		Node currentNode = this.head;
		if (head == null) {
			this.head = newNode;
		} else {
			newNode.nextNode = currentNode;
			this.head = newNode;
		}

	}

	@Override
	public void insertAtTail(Node newNode) {
		Node currentNode = this.head;
		if (currentNode == null) {
			this.head = newNode;
		} else {
			while (currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
			}
			currentNode.nextNode = newNode;
		}

	}

	@Override
	public void insertAtIndex(Node newNode, int index) {
		int length = lengthOfList();
		Node currentNode = this.head;

		if (index > length) {
			index = -1;
		} else if (index <= 0) {
			index = 0;
		}

		if (currentNode == null) {
			this.head = newNode;
		} else {

			switch (index) {
			case 0:
				insertAtHead(newNode);
				break;

			case -1:
				insertAtTail(newNode);
				break;

			default:
				while (index > 1 && currentNode.nextNode != null) {
					currentNode = currentNode.nextNode;
					index--;
				}
				newNode.nextNode = currentNode.nextNode;
				currentNode.nextNode = newNode;
				break;

			}

		}

	}

	@Override
	public void insertBefore(Node node, Node newNode) {
		Node previousNode = this.head;
		Node currentNode = null;
		if (previousNode != null) {
			if (node.data == previousNode.data) {
				newNode.nextNode = previousNode;
				this.head = newNode;
				return;
			}
			currentNode = previousNode.nextNode;
		}

		while (currentNode != null) {
			if (currentNode.data == node.data) {
				newNode.nextNode = currentNode;
				previousNode.nextNode = newNode;
			}
			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}

	}

	@Override
	public void insertAfter(Node node, Node newNode) {
		Node currentNode = this.head;
		while (currentNode != null) {
			if (currentNode.data == node.data) {
				newNode.nextNode = currentNode.nextNode;
				currentNode.nextNode = newNode;
				break;
			}
			currentNode = currentNode.nextNode;
		}

	}

	@Override
	public void deleteAtHead() {
		if (this.head != null) {
			this.head = this.head.nextNode;
		}

	}

	@Override
	public void deleteAtTail() {
		Node currentNode = this.head;
		Node previousNode = null;
		while (currentNode != null && currentNode.nextNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		previousNode.nextNode = null;

	}

	@Override
	public void deleteAtIndex(int index) {
		int length = lengthOfList();
		Node currentNode = this.head;
		if (index >= length) {
			index = -1;
		}
		switch (index) {
		case 0: deleteAtHead();
			    break;
		case -1: break;
		default: while (index > 1 && currentNode.nextNode != null) {
				 currentNode = currentNode.nextNode;
				 index--;
			}
			currentNode.nextNode = currentNode.nextNode.nextNode;

			break;

		}
	}
	
	@Override
	public void deleteKthNodeTwoTraversal(int k) {
		int length = lengthOfList();
		deleteAtIndex(length-k-1);
	}
	
	@Override
	public Node deleteKthNodeSingleTraversal(Node node, int k) {
		Node dummyHead = new Node(0, node);
		Node KthNode = dummyHead;
		Node lastNode = dummyHead.nextNode;
		while(k>=0 && lastNode!=null) {
			lastNode = lastNode.nextNode;
			k--;
		}
		
		while(lastNode!=null) {
			KthNode = KthNode.nextNode;
			lastNode = lastNode.nextNode;
		}
		KthNode.nextNode = KthNode.nextNode.nextNode;
		return dummyHead.nextNode;
		
	}
	
	@Override
	public Node deleteDuplicates(Node node) {
		Node dummyHead = new Node(0, node);
		Node currentNode = dummyHead;
		while(currentNode!=null ) {
			Node distinctNode = currentNode.nextNode;
			while(distinctNode!=null && currentNode.data==distinctNode.data) {
				distinctNode =distinctNode.nextNode;
			}
			currentNode.nextNode = distinctNode;
			currentNode = distinctNode;
		}
		return dummyHead.nextNode;
	}
	
	@Override
	public Node rotateLinkedListRight(Node node, int rotateBy) {
		
		if(node == null) {
			return node;
		}
		
		int n = 1;
		Node currentNode = node;
		
		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
			n++;
		}
		
		rotateBy = rotateBy%n;
		
		if(rotateBy==0) {
			return node;
		}
		
		int newHeadSteps = n-rotateBy;
		currentNode.nextNode = node; // Make the linked List cyclical.
		Node newTail = currentNode;
		
		while(newHeadSteps > 0) {
			newTail = newTail.nextNode;
			newHeadSteps--;
		}
		
		Node newHead = newTail.nextNode;
		newTail.nextNode = null;
		return newHead;

	}

	@Override
	public Node rotateLinkedListLeft(Node node, int rotateBy) {

		if(node == null) {
			return node;
		}
		
		int n = 1;
		Node currentNode = node;
		
		while(currentNode.nextNode!=null) {
			currentNode = currentNode.nextNode;
			n++;
		}
		
		rotateBy = rotateBy%n;
		
		if(rotateBy==0) {
			return node;
		}
		
		int newHeadSteps = rotateBy;
		currentNode.nextNode = node; // Make the linked List cyclical.
		Node newTail = currentNode;
		
		while(newHeadSteps > 0) {
			newTail = newTail.nextNode;
			newHeadSteps--;
		}
		
		Node newHead = newTail.nextNode;
		newTail.nextNode = null;
		return newHead;
		
	}

	@Override
	public Node rotateByNode(Node list, Node nodeTobeRotatedUpon) {
		if(list==null) {
			return null;
		}
			
		Node currentNode = list;
		while(currentNode!=null) {
			if(currentNode.data == nodeTobeRotatedUpon.data) {
				break;
			}
			currentNode = currentNode.nextNode;
		}
		
		if(currentNode==null || currentNode.nextNode==null) {
			return list;
		}
		
		Node newHead = currentNode.nextNode;
		currentNode.nextNode = null;
		Node tailNode = newHead;
		
		while(tailNode.nextNode!=null) {
			tailNode = tailNode.nextNode;
		}
		
		tailNode.nextNode = list;
		return newHead;

	}

	@Override
	public Node findNode(Node node) {
		Node currentNode = this.head;
		while(currentNode!=null) {
			if(currentNode.data==node.data) {
				return currentNode;
		}
			currentNode = currentNode.nextNode;
		}
		return null;
	}

	@Override
	public boolean isNodePresent(Node node) {
		Node currentNode = this.head;
		while(currentNode!=null) {
			if(currentNode.data==node.data) {
				return true;
		}
			currentNode = currentNode.nextNode;
		}
		return false;
	}

	@Override
	public Node findNodeAtIndex(int index) {
		Node currentNode = this.head;
		
		if(currentNode!=null && index==0) {
			return currentNode;
		}
		
		while(currentNode!=null && index>0) {
			currentNode = currentNode.nextNode;
			index--;
		}
		return currentNode;
	}
	
	@Override
	public Node findMidNode(Node node) {
		if(node==null) {
			return null;
		}
		Node slow = node;
		Node fast = node;
		
		while(fast!=null && fast.nextNode!=null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		
		return slow;
	}

	@Override
	public Node findMaximum() {
		Node currentNode = this.head;
		
		if(currentNode == null) {
			return null;
		}
		
		Node maximumNode = currentNode;
		while(currentNode != null) {
			
			if((int)currentNode.data > (int)maximumNode.data) {
				maximumNode = currentNode;
			} 
			
			currentNode = currentNode.nextNode;
		}
		return maximumNode;
	}

	@Override
	public Node findMinimum() {
		Node currentNode = this.head;
		if(currentNode == null) {
			return null;
		}
		Node minimumNode = currentNode;
		while(currentNode != null) {
			if((int)currentNode.data<(int)minimumNode.data) {
				minimumNode = currentNode;
			}
			currentNode = currentNode.nextNode;
		}
		return minimumNode;
	}

	@Override
	public Node findKthToLastElement(int k) {
		Node findKthToLast = this.head;
		int length = lengthOfList();
		if(findKthToLast==null || k>=length || k<0) {
			return null;
		} else {
			findKthToLast = findNodeAtIndex(length-1-k);
		}
		return findKthToLast;
	}

	
	@Override
	public boolean isPalindrome(Node node) {
		Node originalNode = node;
		Node midNode = findMidNode(node);
		Node reverseSecondListfromMiddle = reverseNode(midNode);
		
		while(originalNode!=null && reverseSecondListfromMiddle!=null) {
			if(!originalNode.data.equals(reverseSecondListfromMiddle.data)) {
				return false;
			}
			originalNode = originalNode.nextNode;
			reverseSecondListfromMiddle = reverseSecondListfromMiddle.nextNode;	
		}
		
		return true;
	}
	
	@Override
	public Node mergeTwoLinkedLists(Node list1,
			Node list2) {
		Node dummyHead = new Node(0);
		Node currentNode = dummyHead;
		while(list1!=null && list2!=null) {
			if((int)list1.data<(int)list2.data) {
				currentNode.nextNode = list1;
				list1 = list1.nextNode;
			} else {
				currentNode.nextNode = list2;
				list2 = list2.nextNode;
			}
			currentNode = currentNode.nextNode;
		}
		
		currentNode.nextNode = (list1!=null) ? list1: list2;
		return dummyHead.nextNode;
	}
	
	@Override
	public SinglyLinkedListImpl reverseLinkedList(SinglyLinkedListImpl linkedList) {
		if(linkedList==null) {
			return null;
		}
		Node currentNode = linkedList.head;
		Node previousNode = null;
		Node nextNode = null;
		
		while(currentNode!=null) {
			nextNode = currentNode.nextNode;
			currentNode.nextNode = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		linkedList.head = previousNode;
		return linkedList;
	}
	
	@Override
	public Node reverseSublist(Node list1, int startIndex, int endIndex) {
		Node dummyHead = new Node(0, list1);
		Node currentNode = dummyHead;
		int k = 0;
		while(k++<startIndex) {
		currentNode = currentNode.nextNode;
		}
		
		Node sublistNode = currentNode.nextNode;
		while(startIndex++<endIndex && sublistNode.nextNode!=null) {
			Node temp = sublistNode.nextNode;
			sublistNode.nextNode = temp.nextNode;
			temp.nextNode = currentNode.nextNode;
			currentNode.nextNode = temp;
		}
		
		return dummyHead.nextNode;
	}
	
	@Override
	public Node reverseNode(Node list) {
		Node dummyHead = new Node(0, list);
		Node currentNode = list;
		Node previousNode = null;
		Node nextNode = null;
		
		while(currentNode!=null) {
			nextNode = currentNode.nextNode;
			currentNode.nextNode = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		dummyHead.nextNode = previousNode;
		return dummyHead.nextNode;
	}
	
	@Override
	public Node hasCycle(Node head) {
		Node tortoise = head;
		Node hare = head;
		
		while(hare!=null && hare.nextNode!=null) {
			tortoise = tortoise.nextNode;
			hare = hare.nextNode.nextNode;
			
			if(tortoise==hare) {
				tortoise = head;
				while(tortoise!=hare) {
					hare=hare.nextNode;
					tortoise=tortoise.nextNode;
				}
				return tortoise;
			}
		}
		
		return null;
	}
	
	@Override
	public Node hasOverlappingListCycleFree(Node list1, Node list2) {
		int list1Length = getNodeLength(list1);
		int list2Length = getNodeLength(list2);
		
		if(list1Length>list2Length) {
			list1 = advanceListbyK(list1, list1Length-list2Length);
		} else {
			list2 = advanceListbyK(list2, list2Length-list1Length);
		}
		
		while(list1!=null && list2!=null) {
			if(list1!=list2) {
				list1 = list1.nextNode;
				list2 = list2.nextNode;
			}
		}
		return list1;
	}
	
	@Override
	public Node evenOddMerge(Node list) {
		Node evenDummyHead = new Node(0);
		Node oddDummyHead = new Node(0);
		Node evenIterator = evenDummyHead;
		Node oddIterator = oddDummyHead;
		int turn = 0; 
		
		while(list!=null) {
			if(turn==0) {
				evenIterator.nextNode = list;
				evenIterator = list;
			} else {
				oddIterator.nextNode = list;
				oddIterator = list;
			}
			turn = turn^1;
			list = list.nextNode;
		}
		oddIterator.nextNode = null;
		evenIterator.nextNode = oddDummyHead.nextNode;
		return evenDummyHead.nextNode;
	}
	
	@Override
	public Node ListPivot(Node list, int pivot) {
		Node lesserDummyHead = new Node(0);
		Node equalDummyHead = new Node(0);
		Node greaterDummyHead = new Node(0);
		
		Node lesserIterator = lesserDummyHead;
		Node equalIterator = equalDummyHead;
		Node greaterIterator = greaterDummyHead;
		
		while(list!=null) {
			
			if((int)list.data < pivot) {
				lesserIterator.nextNode = list;
				lesserIterator = list;
			} else if ((int)list.data == pivot) {
				equalIterator.nextNode = list;
				equalIterator = list;
			} else {
				greaterIterator.nextNode = list;
				greaterIterator = list;
			}
			
			list = list.nextNode;
		}
		
		greaterIterator.nextNode = null;
		equalIterator.nextNode = greaterDummyHead.nextNode;
		lesserIterator.nextNode = equalDummyHead.nextNode;
		
		return lesserDummyHead.nextNode;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder("{");
		Node currentNode = this.head;
		while (currentNode != null) {
			sb.append(currentNode);
			if (currentNode.nextNode != null) {
				sb.append(" --> ");
			}
			currentNode = currentNode.nextNode;
		}
		sb.append("}");
		return sb.toString();
	}

}
