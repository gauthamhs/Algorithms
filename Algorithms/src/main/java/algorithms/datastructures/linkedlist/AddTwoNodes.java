package algorithms.datastructures.linkedlist;

public class AddTwoNodes {
	
	Node head = null;
    int carry = 0;
    
    public int length(Node l){
        int length = 0;
        while(l!=null){
            ++length;
            l = l.nextNode;
        }
        return length;
    }
    
    public Node insertBefore(Node tail, int data){
    	Node node = new Node(data);
        if(tail!=null){
            node.nextNode = tail;
        }
        return node;
    }
    
    public Node padList(Node l, int paddingLength){
    	Node node = l;
        for(int i=0;i<paddingLength;i++){
            node = insertBefore(node, 0);
        }
        return node;
    }
    
    public void addLists(Node l1, Node l2, Node head, int carry){
        
        if(l1==null && l2==null){
            return ;
        }
        
        addLists(l1.nextNode, l2.nextNode, head, carry);
        
        int sum = (int)l1.data + (int)l2.data + carry;
        
        Node result = insertBefore(head, sum%10);
        head = result;
        carry = sum/10;
        
    }
    
    public Node addTwoNumbers(Node l1, Node l2) {
        int n1 = length(l1);
        int n2 = length(l2);
        
        if(n1<n2){
             l1 = padList(l1, n2-n1);
        }else{
             l2 = padList(l2,n1-n2);
        }
        
        addLists(l1, l2, head, carry);
        
        if(carry==0){
            return head;
        }else{
        	Node result = insertBefore(head, carry);
            return result;
        }
        
    }

}
