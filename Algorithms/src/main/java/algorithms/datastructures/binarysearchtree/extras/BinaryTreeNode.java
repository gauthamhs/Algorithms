package algorithms.datastructures.binarysearchtree.extras;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode() {
		
	}

	public BinaryTreeNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
	
	public void traverseNodes(StringBuilder sb, String padding, String pointer, BinaryTreeNode node, 
			  boolean hasRightSibling) {
			    if (node != null) {
			        sb.append("\n");
			        sb.append(padding);
			        sb.append(pointer);
			        sb.append(node.data);
			 
			        StringBuilder paddingBuilder = new StringBuilder(padding);
			        if (hasRightSibling) {
			            paddingBuilder.append("│  ");
			        } else {
			            paddingBuilder.append("   ");
			        }
			 
			        String paddingForBoth = paddingBuilder.toString();
			        String pointerRight = "└──";
			        String pointerLeft = (node.right != null) ? "├──" : "└──";
			 
			        traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right!= null);
			        traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
			    }
			}
	
	public String traversePreOrder(BinaryTreeNode root) {
		 
	    if (root == null) {
	        return "";
	    }
	 
	    StringBuilder sb = new StringBuilder();
	    sb.append(root.data);
	 
	    String pointerRight = "└──";
	    String pointerLeft = (root.right != null) ? "├──" : "└──";
	 
	    traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
	    traverseNodes(sb, "", pointerRight, root.right, false);
	 
	    return sb.toString();
	}
	
	@Override
	public String toString() {
		return "" + data;
	}

}