package finalmp;

public class BSTree<T extends Comparable<T>> {

	Node<T> root;

	public BSTree() {
		clear();
	}

	/******* YOUR CODE HERE ****************/

	/*************************************/

	public void inorderTraversal() {
		inorderTraversal(root);
		System.out.println();
	}

	private void inorderTraversal(Node<T> node) {
		if (node != null) {
			inorderTraversal(node.leftChild);
			System.out.print(node.item + " ");
			inorderTraversal(node.rightChild);
		}
	}

	public boolean add(T item) {
		if (root == null) {
			root = new Node<T>(item);
		} else {
			Node<T> current = root;
			Node<T> parent = null;
			while (current != null) {
				if (item.compareTo(current.item) > 0) {
					parent = current;
					current = current.rightChild;
				} else if (item.compareTo(current.item) < 0) {
					parent = current;
					current = current.leftChild;
				} else {
					return false;
				}
			}
			if (item.compareTo(parent.item) > 0) {
				parent.rightChild = new Node<T>(item);
			} else if (item.compareTo(parent.item) < 0) {
				parent.leftChild = new Node<T>(item);
			}
		}
		return true;
	}

	public void clear() {
		root = null;
	}

	class Node<E> {
		Node<E> leftChild;
		Node<E> rightChild;
		E item;

		public Node(E item) {
			this.item = item;
		}
	}

	public static void main(String args[]) {
		BSTree<Integer> btree1 = new BSTree<Integer>();
		BSTree<Integer> btree2 = new BSTree<Integer>();

		btree1.add(3);
		btree1.add(1);
		btree1.add(4);
		btree1.add(2);
		btree1.add(5);
		btree1.add(-1);

		btree2.add(0);
		btree2.add(-2);
		btree2.add(-7);
		btree2.add(-3);
		btree2.add(-1);
		btree2.add(3);
		btree2.add(5);

		System.out.print("btree1 Before Merge: ");
		btree1.inorderTraversal(); // -1 1 2 3 4 5

		btree1.mergeTree(btree2);

		System.out.print("btee1 After Merge : ");
		btree1.inorderTraversal(); // -7 -3 -2 -1 0 1 2 3 4 5

		System.out.print("btree2 After Merge: ");
		btree2.inorderTraversal(); // -7 -3 -2 -1 0 3 5

	}

	private void mergeTree(BSTree<T> btree2) {
		mergeTree(btree2.root);
		
	}
	
	private void mergeTree(Node<T> curr){
		if (curr == null){
			return;
		}
		add(curr.item);
		mergeTree(curr.leftChild);
		mergeTree(curr.rightChild);	
	}

}