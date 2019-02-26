package algorithms.datastructures.binarysearchtree.extras;

public class ValidateBinarySearchTree {
	
	 public boolean isValidBST(BinaryTreeNode root) {
	        
	        return isValidBSTHelper(root, null, null);
	}
	    
	    boolean isValidBSTHelper(BinaryTreeNode root, BinaryTreeNode min, BinaryTreeNode max){
	         if(root==null){
	            return true;
	        }
	        
	        if (max != null && root.data >= max.data) return false;
	        if (min != null && root.data <= min.data) return false;
	        return isValidBSTHelper(root.left, min, root) 
	            && isValidBSTHelper(root.right, root ,max);
	    }
	    
	
	public static void main(String[] args) {
		
	}

}
