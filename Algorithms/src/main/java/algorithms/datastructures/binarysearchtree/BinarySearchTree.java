package algorithms.datastructures.binarysearchtree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListFilter;

public class BinarySearchTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	// Find Data

	public TreeNode findDataIterative(int data) {
		TreeNode currentNode = this.root;
		while (currentNode != null) {
			int currentNodeData = currentNode.getData();
			if (data == currentNodeData) {
				return currentNode;
			}
			if (data < currentNodeData) {
				currentNode = currentNode.getLeftChild();
			}
			if (data > currentNodeData) {
				currentNode = currentNode.getRightChild();
			}
		}
		return currentNode;

	}

	public TreeNode findDataRecursive(int data) {
		TreeNode currentNode = this.root;
		if (currentNode != null) {
			currentNode.find(data);
		}
		return currentNode;
	}

	// Insert a Node to the Binary Search Tree

	public void insertNodeIterative(int data) {
		TreeNode newNode = new TreeNode(data);
		TreeNode currentNode = this.root;
		if (currentNode == null) {
			this.root = newNode;
		}

		while (currentNode != null) {
			int currentNodeData = currentNode.getData();

			if (data < currentNodeData) {
				if (currentNode.getLeftChild() == null) {
					currentNode.setLeftChild(newNode);
					break;
				}
				currentNode = currentNode.getLeftChild();
			}
			if (data >= currentNodeData) {
				if (currentNode.getRightChild() == null) {
					currentNode.setRightChild(newNode);
					break;
				}
				currentNode = currentNode.getRightChild();
			}
		}
	}

	public void insertNodeRecursive(int data) {
		TreeNode newNode = new TreeNode(data);
		TreeNode currentNode = this.root;
		if (currentNode == null) {
			this.root = newNode;
		} else {
			currentNode.insert(data);
		}
	}

	/*
	 * Deleting a node. There are 3 cases to be considered while deleting a
	 * node. 1) Deleting a leaf Node 2) Deleting a ParentNode having one
	 * children. 3) Deleting a ParentNode having two children.
	 */

	public void deleteNode(BinarySearchTree binarySearchTree, int data) {
		TreeNode currentNode = binarySearchTree.getRoot();
		TreeNode parentNode = currentNode;
		Boolean isLeftChild = false;

		while (currentNode != null && currentNode.getData() != data) {

			parentNode = currentNode;
			int currentNodeData = currentNode.getData();
			if (data < currentNodeData) {
				currentNode = currentNode.getLeftChild();
				isLeftChild = true;
			}
			if (data > currentNodeData) {
				currentNode = currentNode.getRightChild();
				isLeftChild = false;
			}

		}

		if (currentNode == null) {
			return;
		}

		/* Case1: If the node to be deleted is a leaf node. */

		if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
			if (currentNode == this.root) {
				this.root = null;
			} else {
				if (isLeftChild) {
					parentNode.setLeftChild(null);
				} else {
					parentNode.setRightChild(null);
				}
			}
		}

		/*
		 * Case2: If the node to be deleted has one child: Either a left child
		 * or a right child
		 */

		if (currentNode.getLeftChild() != null && currentNode.getRightChild() == null) {
			if (currentNode == this.root) {
				this.root = currentNode.getLeftChild();
			} else {
				if (isLeftChild) {
					parentNode.setLeftChild(currentNode.getLeftChild());
				} else {
					parentNode.setRightChild(currentNode.getLeftChild());
				}
			}

		} else if (currentNode.getRightChild() != null && currentNode.getLeftChild() == null) {
			if (currentNode == this.root) {
				this.root = currentNode.getRightChild();
			} else {
				if (isLeftChild) {
					parentNode.setLeftChild(currentNode.getRightChild());
				} else {
					parentNode.setRightChild(currentNode.getRightChild());
				}
			}
		}

		/* Case3: If Node to be deleted has two children */

		if (currentNode.getLeftChild() != null && currentNode.getRightChild() != null) {

			TreeNode successor = currentNode.getRightChild();
			TreeNode previousNode = successor;
			if (currentNode == this.root) {
				if (successor.getLeftChild() == null) {
					currentNode.setData(successor.getData());
					if (successor.getRightChild() != null) {
						currentNode.setRightChild(successor.getRightChild());
					}
				} else {
					while (successor.getLeftChild() != null) {
						previousNode = successor;
						successor = successor.getLeftChild();
						if (successor.getLeftChild() == null && successor.getRightChild() == null) {
							currentNode.setData(successor.getData());
							previousNode.setLeftChild(null);
							break;
						}
					}

				}
			} else {
				if (isLeftChild) {
					if (successor.getLeftChild() == null) {
						parentNode.getLeftChild().setData(successor.getData());
						if (successor.getRightChild() != null) {
							currentNode.setRightChild(successor.getRightChild());
						}
					} else {
						while (successor.getLeftChild() != null) {
							previousNode = successor;
							successor = successor.getLeftChild();
							if (successor.getLeftChild() == null && successor.getRightChild() == null) {
								currentNode.setData(successor.getData());
								previousNode.setLeftChild(null);
								break;
							}
						}

					}
				} else {
					if (successor.getLeftChild() == null) {
						parentNode.getRightChild().setData(successor.getData());
						if (successor.getRightChild() != null) {
							currentNode.setRightChild(successor.getRightChild());
						}

					} else {
						while (successor.getLeftChild() != null) {
							previousNode = successor;
							successor = successor.getLeftChild();
							if (successor.getLeftChild() == null && successor.getRightChild() == null) {
								currentNode.setData(successor.getData());
								previousNode.setLeftChild(null);
								break;
							}

						}
					}

				}

			}
		}

	}
	
	//Print Operations

	// Tree Order Recursive Traversals.
	public void printInOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		printInOrder(treeNode.getLeftChild());
		System.out.print(treeNode.getData() + " ");
		printInOrder(treeNode.getRightChild());
	}

	public void printPreOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		System.out.print(treeNode.getData() + " ");
		printInOrder(treeNode.getLeftChild());
		printInOrder(treeNode.getRightChild());
	}

	public void printPostOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		printInOrder(treeNode.getLeftChild());
		printInOrder(treeNode.getRightChild());
		System.out.print(treeNode.getData() + " ");
	}
	
	//Print Complete Binary Search Tree

	public void printCompleteTree(TreeNode root) {
		Queue<TreeNode> currentLevel = new LinkedList<>();
		Queue<TreeNode> nextLevel = new LinkedList<>();

		currentLevel.add(root);

		while (!currentLevel.isEmpty()) {
			Iterator<TreeNode> iterator = currentLevel.iterator();
			while (iterator.hasNext()) {
				TreeNode currentNode = iterator.next();
				if (currentNode.getLeftChild() != null) {
					nextLevel.add(currentNode.getLeftChild());
				}
				if (currentNode.getRightChild() != null) {
					nextLevel.add(currentNode.getRightChild());
				}
			}

			for (TreeNode treeNode : currentLevel) {
				System.out.print(treeNode.getData() + " ");
			}
			System.out.println();

			currentLevel = nextLevel;
			nextLevel = new LinkedList<>();
		}
	}
	
	// Print Level of the Binary Tree.
	public void printLevel(TreeNode root, int height){
		
		Queue<TreeNode> currentLevel = new LinkedList<>();
		Queue<TreeNode> nextLevel = new LinkedList<>();
		
		currentLevel.add(root);
		
		while(!currentLevel.isEmpty() && height>0){
			Iterator<TreeNode> iterator = currentLevel.iterator();
			while(iterator.hasNext()){
				TreeNode currentNode = iterator.next();
				if(currentNode.getLeftChild()!=null){
					nextLevel.add(currentNode.getLeftChild());
				}
				if(currentNode.getRightChild()!=null){
					nextLevel.add(currentNode.getRightChild());
				}
			}
			
			currentLevel = nextLevel;
			nextLevel = new LinkedList<>();
			height--;
		}
		
		for (TreeNode treeNode : currentLevel) {
			System.out.print(treeNode.getData() + " ");
		}
		
	}

/*Operations on a Binary Search Tree*/
	
	/*Height of the tree using recursion.*/
	public int treeHeightRecursion(TreeNode root){
		if(root==null){
			return 0;
		}
			
		return(1+Math.max(treeHeightRecursion(root.getLeftChild()),treeHeightRecursion(root.getRightChild())));
	}
	
	/*Height of the tree using Iteration.*/
	
public int treeHeight(TreeNode root){
		
		Queue<TreeNode> currentLevel = new LinkedList<>();
		Queue<TreeNode> nextLevel = new LinkedList<>();
		int height = 0;
		
		currentLevel.add(root);
		
		while(!currentLevel.isEmpty()){
			Iterator<TreeNode> iterator = currentLevel.iterator();
			while(iterator.hasNext()){
				TreeNode currentNode = iterator.next();
				if(currentNode.getLeftChild()!=null){
					nextLevel.add(currentNode.getLeftChild());
				}
				if(currentNode.getRightChild()!=null){
					nextLevel.add(currentNode.getRightChild());
				}
			}
			
			currentLevel = nextLevel;
			nextLevel = new LinkedList<>();
			height++;
		}
		
		return height;
		
	}

/*Smallest Node in the Binary Search Tree*/

public TreeNode getSmallest(){
	TreeNode currentNode = this.root;
	while(currentNode!=null &&currentNode.getLeftChild()!=null){
		currentNode = currentNode.getLeftChild();
	}
	return currentNode;
}

/*Largest Node in the Binary Search Tree*/

public TreeNode getLargest(){
	TreeNode currentNode = this.root;
	while(currentNode!=null &&currentNode.getRightChild()!=null){
		currentNode = currentNode.getRightChild();
	}
	return currentNode;
}

/*Least Common Ancestor using recursion*/
/*Nodes n1 and n2 must be present in the Tree, otherwise we can throw an Exception*/
public TreeNode leastCommonAncestorRecursion(TreeNode root, int n1, int n2){
	
	if(root == null){
		return null;
	}
	
	if(root.getData()<n1 && root.getData()<n2){
		return leastCommonAncestorRecursion(root.getRightChild(), n1, n2);
	}
	if(root.getData()>n1 && root.getData()>n2){
		return leastCommonAncestorRecursion(root.getLeftChild(), n1, n2);
	}
	return root;
	
}

/*Least Common Ancestor using iteration*/
public TreeNode leastCommonAncestor(TreeNode root, int n1, int n2){
	TreeNode currentNode = root;
	
	while(currentNode!=null){
		if(currentNode.getData()>n1 && currentNode.getData()>n2){
			currentNode = currentNode.getLeftChild();
		}
		else if(currentNode.getData()<n1 && currentNode.getData()<n2){
			currentNode = currentNode.getRightChild();
		}else{
			break;
		}
	}
	
	return currentNode;
}

/*Find Kth Smallest element in a Binary Search Tree*/
	
}














