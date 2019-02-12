package algorithms.datastructures.binarysearchtree.extras;

public class IdenticalTrees {
	
	BinaryTreeNode root;
	
	boolean isSubTree(BinaryTreeNode mainTree, BinaryTreeNode subTree) {
		
		if(subTree==null) {
			return true;
		}
		
		if(mainTree==null) {
			return false;
		}
		
		if(areTreesIdentical(mainTree,subTree)) {
			return true;
		}
		
		return (isSubTree(mainTree.left, subTree.left) || isSubTree(mainTree.right, subTree.right));
		
	}
	boolean areTreesIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
		
		if(root1==null && root2==null) {
			return true;
		}
		
		if(root1!=null && root2!=null) {
			if((root1.data == root2.data) 
			&&(areTreesIdentical(root1.left, root2.left)) 
			&&(areTreesIdentical(root1.right, root2.right))) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		IdenticalTrees identicalTrees1 = new IdenticalTrees() ;
		identicalTrees1.root = new BinaryTreeNode(1);
		identicalTrees1.root.left = new BinaryTreeNode(2);
		identicalTrees1.root.right = new BinaryTreeNode(3);
		identicalTrees1.root.left.left = new BinaryTreeNode(4);
		identicalTrees1.root.right.left = new BinaryTreeNode(5);
		identicalTrees1.root.right.right = new BinaryTreeNode(6);
		
		IdenticalTrees identicalTrees2 = new IdenticalTrees() ;
		identicalTrees2.root = new BinaryTreeNode(1);
		identicalTrees2.root.left = new BinaryTreeNode(2);
		identicalTrees2.root.right = new BinaryTreeNode(3);
		identicalTrees2.root.left.left = new BinaryTreeNode(4);
		identicalTrees2.root.right.left = new BinaryTreeNode(5);
		identicalTrees2.root.right.right = new BinaryTreeNode(6);
		
		IdenticalTrees identicalTrees3 = new IdenticalTrees() ;
		identicalTrees3.root = new BinaryTreeNode(1);
		identicalTrees3.root.left = new BinaryTreeNode(2);
		identicalTrees3.root.right = new BinaryTreeNode(3);
		identicalTrees3.root.left.left = new BinaryTreeNode(4);
		identicalTrees3.root.left.right = new BinaryTreeNode(5);
		identicalTrees3.root.right.right = new BinaryTreeNode(6);
		
		boolean isIdentical = identicalTrees1.areTreesIdentical(identicalTrees1.root, identicalTrees2.root);
		boolean isIdentical2 = identicalTrees1.areTreesIdentical(identicalTrees1.root, identicalTrees3.root);
		System.out.println(isIdentical);
		System.out.println(isIdentical2);
	
		
	}

}
