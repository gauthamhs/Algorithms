package algorithms.datastructures.binarysearchtree;

public class TreeNode {
	
	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(Integer data) {
		super();
		this.data = data;
	}
	

	public Integer getData() {
		return data;
	}
	
	public void setData(Integer data) {
		this.data = data;
	}


	public TreeNode getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public TreeNode getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public TreeNode find(int data){
		if(data==this.data){
			return this;
		}
		if(data<this.data && leftChild!=null){
			return leftChild.find(data);
		}
		if(rightChild!=null){
			return rightChild.find(data);
		}
		
		return null;
		
	}
	
	public void insert(int data){
		if(data<this.data){
			if(this.leftChild == null){
				this.leftChild = new TreeNode(data);
			} else{
				leftChild.insert(data);
			}
		}else{
			if(this.rightChild==null){
				this.rightChild = new TreeNode(data);
			}else{
				rightChild.insert(data);
			}
			
		}
		
	}	
	
	@Override
	public String toString(){
		return data.toString();
	}
	
	

}
