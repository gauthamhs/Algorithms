package algorithms.datastructures.binarysearchtree.extras;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	
	BinaryTreeNode root;
	
    public static List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        List<List<Integer>> sumList = new ArrayList<>();
        List<Integer> partialList = new ArrayList<>();
        pathSumHelper(root,sum,sumList,partialList);
            return sumList;    
    }
    
    public static void pathSumHelper(BinaryTreeNode root, int sum, List<List<Integer>> sumList, List<Integer> partialList){
        
        if(root==null){
            return;
        }
        
        partialList.add(root.data);
        
        if(sum==root.data && root.left==null && root.right==null){
            sumList.add(new ArrayList<>(partialList));
        }
        
        pathSumHelper(root.left, sum-root.data, sumList, partialList);
        pathSumHelper(root.right, sum-root.data, sumList, partialList);
        
        partialList.remove(partialList.size()-1);
    }
	
	public static void main(String[] args) {
		
		/*               1
		/*            /     \
		 *          2          3
		 *        /  \        /  \
		 *       4    5      6    7 
		 *     /  \  / \    / \   \
		 *    8   9 10 11  12 13  14
		 *       / \              / \
		 *      17  18           15  16
		 *        
		 */
		
		PathSum pathSum = new PathSum();
		pathSum.root = new BinaryTreeNode(1);
		pathSum.root.left = new BinaryTreeNode(2);
		pathSum.root.right = new BinaryTreeNode(3);
		pathSum.root.left.left = new BinaryTreeNode(4);
		pathSum.root.left.right = new BinaryTreeNode(5);
		pathSum.root.right.left = new BinaryTreeNode(6);
		pathSum.root.right.right = new BinaryTreeNode(7);
		pathSum.root.left.left.left = new BinaryTreeNode(8);
		pathSum.root.left.left.right = new BinaryTreeNode(9);
		pathSum.root.left.right.left = new BinaryTreeNode(10);
		pathSum.root.left.right.right = new BinaryTreeNode(11);
		pathSum.root.right.left.left = new BinaryTreeNode(12);
		pathSum.root.right.left.right = new BinaryTreeNode(13);
		pathSum.root.right.right.right = new BinaryTreeNode(14);
		pathSum.root.right.right.right.left = new BinaryTreeNode(15);
		pathSum.root.right.right.right.right = new BinaryTreeNode(16);
		pathSum.root.left.left.right.left = new BinaryTreeNode(17);
		pathSum.root.left.left.right.right = new BinaryTreeNode(18);
		
		List<List<Integer>> result = pathSum(pathSum.root,22);
		System.out.println(result);
		
	}

}
