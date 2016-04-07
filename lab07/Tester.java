package lab07;

public class Tester {

	public static void main(String[] args) {
		BSTree<Integer> btree = new BSTree<Integer>();
		btree.insert(5);
		btree.insert(3);
		btree.insert(6);
		btree.insert(1);
		btree.insert(4);
		
		btree.preorderTraversal();
		System.out.println();
		btree.postorderTraversal();
		System.out.println();
		btree.inorderTraversal();
		

	}

}
