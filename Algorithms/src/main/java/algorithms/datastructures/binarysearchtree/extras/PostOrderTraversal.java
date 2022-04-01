package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PostOrderTraversal {
	

	/*	PreOrder Traversal prints the tree in the following order: 
	
	1) Print root
	2) Print left Child
	3) Print right Child
	
	        314
	      /     \
	    6        6
	  /  \     /   \
	271 561   12   0 
	
	Prints 271 561 6 12 0 6 314 
	*/
	
	BinaryTreeNode root;
	
	void postOrderTraversalIterativeUsing2Stacks(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		
		Deque<BinaryTreeNode> nodeStack = new ArrayDeque<>();
		Deque<BinaryTreeNode> postOrderTraversalStack = new ArrayDeque<>();
		nodeStack.addFirst(root);
		while(!nodeStack.isEmpty()) {
			BinaryTreeNode node = nodeStack.removeFirst();
			postOrderTraversalStack.addFirst(node);
			if(node.left!=null) {
				nodeStack.addFirst(node.left);
			} 
			
			if(node.right!=null) {
				nodeStack.addFirst(node.right);
			}
			
		}
		
		while(!postOrderTraversalStack.isEmpty()) {
			System.out.print(postOrderTraversalStack.removeFirst().data + " ");
		}
		
	}

	
	void postOrderTraversalRecursive(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		postOrderTraversalRecursive(root.left);
		postOrderTraversalRecursive(root.right);
		System.out.print(root.data + " ");
		
	}
	
    public List<Integer> postorderTraversal(BinaryTreeNode root) {
        
        if(root==null){
            return Collections.emptyList();
        }
        
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        Collections.reverse(result);
        return result;
}
 
    public void postOrderHelper(BinaryTreeNode root, List<Integer> result){
        
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        while(root!=null || !stack.isEmpty()){
            
            while(root!=null){
                result.add(root.data);
                stack.addFirst(root);
                root = root.right;
            }
            
            root = stack.removeFirst();
            root = root.left;
            
            
        }
        
    }
	
	public static void main(String[] args) {
		
		PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
		postOrderTraversal.root = new BinaryTreeNode(314);
		postOrderTraversal.root.left = new BinaryTreeNode(6);
		postOrderTraversal.root.right = new BinaryTreeNode(6);
		postOrderTraversal.root.left.left = new BinaryTreeNode(271);
		postOrderTraversal.root.left.right = new BinaryTreeNode(561);
		postOrderTraversal.root.right.left = new BinaryTreeNode(12);
		postOrderTraversal.root.right.right = new BinaryTreeNode(0);
		
		
		postOrderTraversal.postOrderTraversalRecursive(postOrderTraversal.root);
		System.out.println();
		postOrderTraversal.postOrderTraversalIterativeUsing2Stacks(postOrderTraversal.root);
		System.out.println();
		
		
	}

}
