package lab07;

public class BSTree<T extends Comparable<? super T>> {
	Node<T> root;
	int size;
	
	public BSTree(){
		clear();
	}
	
	public int getHeight(){
		return getHeight(root,0);
	}
	
    public int getHeight(Node<T> node, int h){
    	if(node != null){
    		int left = getHeight(node.leftChild,h+1);
    		int right = getHeight(node.rightChild,h+1);
    		
    		if(left > right){
    			return left;
    		}
    		else {
    			return right;
    		}
    	}
    	return h;
	}
	
	public void inorderTraversal(){
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<T> node){
		if(node != null){
			inorderTraversal(node.leftChild);
			for(int count = 0; count < node.count; count++){
				System.out.println(node.data);
			}
			inorderTraversal(node.rightChild);
		}
	}
	
	
	public void preorderTraversal(){
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node<T> node){
		if(node != null){
			System.out.println(node.data);
			preorderTraversal(node.leftChild);
			preorderTraversal(node.rightChild);
		}
	}
	
	public void postorderTraversal(){
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node<T> node){
		if(node != null){
			postorderTraversal(node.leftChild);
			postorderTraversal(node.rightChild);
			System.out.println(node.data);
		}
	}
	
	public boolean insert(T data){
		if (isEmpty()){
			root = new Node<T>(data);
			size++;
			return true;
		}
		else {
			Node<T> parent = null;
			Node<T> curr = root;
			while (curr != null){
				if(data.compareTo(curr.data) < 0){
					parent = curr;
					curr = curr.leftChild;
				}
				else if((data.compareTo(curr.data) > 0)) {
					parent = curr;
					curr = curr.rightChild;
				}
				else {
					parent = curr;
					break;
				}
			}
			Node newNode = new Node<T>(data);
			if(data.compareTo(parent.data)<0){
				parent.leftChild = newNode;
			}
			else if(data.compareTo(parent.data)>0){
				parent.rightChild = newNode;
			}
			else {
				parent.count += 1;
			}
			return true;
		}
	}
	
	public boolean remove(T rem){
		Node<T> parent = null;
		Node<T> curr = root;
		while (curr != null){
			if(rem.compareTo(curr.data) < 0){
				parent = curr;
				curr = curr.leftChild;
			}
			else if((rem.compareTo(curr.data) > 0)) {
				parent = curr;
				curr = curr.rightChild;
			}
			else {
				break;
			}
		}
		
		if(curr == null){
			return false;
		}
		else if(curr.count > 1){
			curr.count--;
		}
		else {
			if(curr.leftChild == null){
				if(parent == null){
					root = curr.rightChild;
				}
				else {
					if(rem.compareTo(parent.data)<0){
						parent.leftChild = curr.rightChild;
					}
					else {
						parent.rightChild = curr.rightChild;
					}
				}
			}
			else {
				Node<T> parentOfLeftMost = curr;
				Node<T> leftMost = curr.rightChild;
				while(leftMost.leftChild != null){
					parentOfLeftMost = leftMost;
					leftMost = leftMost.leftChild;
				}
				
				curr.data = leftMost.data;
				
				if(parentOfLeftMost.leftChild == leftMost){
					parentOfLeftMost.leftChild = leftMost.rightChild;
				}
				else {
					parentOfLeftMost.rightChild = leftMost.rightChild;
				}
			}
			
		}
		size -=1;
		return true;
	}
	
	public boolean hasChild(Node<T> curr){
		return curr.leftChild != null || curr.rightChild != null;
	}
	
	public void clear() {
		root = null;
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return root == null;
	}



	class Node<E>{
		E data;
		Node<E> leftChild;
		Node<E> rightChild;
		int count = 0;
		
		public Node(E data){
			this.data = data;
			count = 1;
		}
	}
}
