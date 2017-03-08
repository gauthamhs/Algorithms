package algorithms.datastructures.binarysearchtree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeImpl implements BinarySearchTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	@Override
	public void sortedListfromBinarySearchTree(TreeNode root, List<TreeNode> treeList){

		 if(root==null){
			 return ;
		 }
		 sortedListfromBinarySearchTree(root.getLeftChild(), treeList);
		 treeList.add(root);
		 sortedListfromBinarySearchTree(root.getRightChild(), treeList);
		
	 }
	
	@Override
	public boolean breadthFirstSearch(TreeNode root, int element){
		
		if(root==null){
			return false;
		}
		
		Queue<TreeNode> currentLevel = new LinkedList<>();
		currentLevel.add(root);
		while(!currentLevel.isEmpty()){
			TreeNode currentNode = currentLevel.poll();
			if(currentNode.getData()==element){
				return true;
			}
			if(currentNode.getLeftChild()!=null){
				currentLevel.add(currentNode.getLeftChild());
			}
			if(currentNode.getRightChild()!=null){
				currentLevel.add(currentNode.getRightChild());
			}
		}
		
		return false;
		
	}

	@Override
	public boolean depthFirstSearch(TreeNode root, int element){
		
		if(root==null){
			return false;
		}
		Stack<TreeNode> currentLevel = new Stack<>();

		currentLevel.add(root);
		while(!currentLevel.isEmpty()){
			TreeNode currentNode = currentLevel.pop();
			if(currentNode.getData()==element){
				return true;
			}
			if(currentNode.getRightChild()!=null){
				currentLevel.add(currentNode.getRightChild());
			}
			if(currentNode.getLeftChild()!=null){
				currentLevel.add(currentNode.getLeftChild());
			}
		}
		
		return false;
		
	}
	
	@Override
	public TreeNode KthSmallestElement(TreeNode root, int k){
		 

		 List<TreeNode> treeList = new LinkedList<>();
		 
		 if(root==null ||k==0){
			 return null;
		 }
		 
		 sortedListfromBinarySearchTree(root, treeList);
		 
		 if(k>treeList.size()){
			 return null;
		 }
		 
		 return treeList.get(k-1);
	 
	 }

	@Override
	public TreeNode KthLargestElement(TreeNode root, int k){
		 
		 if(root==null ||k==0){
			 return null;
		 }
		 
		 List<TreeNode> treeList = new LinkedList<>();
		 
		 sortedListfromBinarySearchTree(root, treeList);
		 
		 if(k>treeList.size()){
			 return null;
		 }
		 
		 return treeList.get(treeList.size()-k);
		 
	 }
	
	@Override
	public TreeNode getSmallest(){
		TreeNode currentNode = this.root;
		while(currentNode!=null &&currentNode.getLeftChild()!=null){
			currentNode = currentNode.getLeftChild();
		}
		return currentNode;
	}

	@Override
	public TreeNode getLargest(){
		TreeNode currentNode = this.root;
		while(currentNode!=null &&currentNode.getRightChild()!=null){
			currentNode = currentNode.getRightChild();
		}
		return currentNode;
	}

	@Override
	public TreeNode findData(int data) {
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

	@Override
	public TreeNode findDataRecursive(int data) {
		TreeNode currentNode = this.root;
		if (currentNode != null) {
			currentNode.find(data);
		}
		return currentNode;
	}
	
	@Override
	public void insertNode(int data) {
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

	@Override
	public void insertNodeRecursive(int data) {
		TreeNode newNode = new TreeNode(data);
		TreeNode currentNode = this.root;
		if (currentNode == null) {
			this.root = newNode;
		} else {
			currentNode.insert(data);
		}
	}

	@Override
	public void deleteNode(BinarySearchTreeImpl binarySearchTree, int data) {
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

	@Override
	public void printInOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		printInOrder(treeNode.getLeftChild());
		System.out.print(treeNode.getData() + " ");
		printInOrder(treeNode.getRightChild());
	}

	@Override
	public void printPreOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		System.out.print(treeNode.getData() + " ");
		printInOrder(treeNode.getLeftChild());
		printInOrder(treeNode.getRightChild());
	}

	@Override
	public void printPostOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		printInOrder(treeNode.getLeftChild());
		printInOrder(treeNode.getRightChild());
		System.out.print(treeNode.getData() + " ");
	}

	@Override
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

	@Override
	public void printSpiralBinaryTree(TreeNode root){
		
		if(root==null){
			return;
		}
		
		Queue<TreeNode> currentLevel = new LinkedList<>();
		Queue<TreeNode> nextLevel = new LinkedList<>();
		currentLevel.add(root);
		int spiralSwitch = 0;

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
			
			if(spiralSwitch!=0 && spiralSwitch%2==0){
				Stack<TreeNode> stack = new Stack<>();
				while(!currentLevel.isEmpty()){
					stack.push(currentLevel.remove());
				}
				while(!stack.isEmpty()){
					currentLevel.add(stack.pop());
				}
				for (TreeNode treeNode : currentLevel) {
					System.out.print(treeNode + " ");
				}


			}else{
				for (TreeNode treeNode : currentLevel) {
					System.out.print(treeNode + " ");
				}
			}
			
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<>();
			spiralSwitch++;
			
		}	
	}

	@Override
	public void printCompleteSpiralBinaryTreeUsingStacks(TreeNode root){
		if(root==null){
			return;
		}
		
		Stack<TreeNode> stackRightToLeft = new Stack<>();
		Stack<TreeNode> stackLeftToRight = new Stack<>();
		TreeNode currentNode = null;
		
		stackRightToLeft.add(root);
		
		while(!stackLeftToRight.isEmpty()||!stackRightToLeft.isEmpty()){
			while(!stackRightToLeft.isEmpty()){
				currentNode = stackRightToLeft.pop(); 
				System.out.print(currentNode + " " );
				if(currentNode.getRightChild()!=null){
					stackLeftToRight.push(currentNode.getRightChild());
				}
				if(currentNode.getLeftChild()!=null){
					stackLeftToRight.push(currentNode.getLeftChild());
				}
			}
			
			System.out.println();
			
			while(!stackLeftToRight.isEmpty()){
				currentNode = stackLeftToRight.pop();
				System.out.print(currentNode + " ");
				if(currentNode.getLeftChild()!=null){
					stackRightToLeft.push(currentNode.getLeftChild());
				}
				if(currentNode.getRightChild()!=null){
					stackRightToLeft.push(currentNode.getRightChild());
				}
			}
			System.out.println();
		}
	}

	@Override
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

	@Override
	public int treeHeightRecursion(TreeNode root){
		if(root==null){
			return 0;
		}
			
		return(1+Math.max(treeHeightRecursion(
				root.getLeftChild()),treeHeightRecursion(root.getRightChild())));
	}

@Override
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

@Override
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

@Override
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
	
}














