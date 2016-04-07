package lab07;

public class BSTree<T extends Comparable<? super T>> {
	Node<T> root;
	int size;
	
	public BSTree(){
		clear();
	}
	
	public void inorderTraversal(){
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<T> node){
		if(node != null){
			inorderTraversal(node.leftChild);
			System.out.println(node.data);
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
