package mp07;

import java.util.LinkedList;
import java.util.Queue;

public class TwoDTree {
	/*************
	 * attributes
	 ************/

	TwoDTreeNode root;

	/***************
	 * constructor
	 **************/
	TwoDTree() {
		root = null;
	}

	/**********
	 * methods
	 *********/
	/**
	 * To Do: adds a new node with the given x and y coordinates to the TwoDTree
	 * 
	 * @param x
	 * @param y
	 */

	public void add(int x, int y) {
 		if (isEmpty()) {
			root = new TwoDTreeNode(x, y, null, null);
		} else {
			TwoDTreeNode parent = null;
			TwoDTreeNode current = root;
			int level = 0;
			while (current != null) {
				if (current.xCoordinate == x && current.yCoordinate == y){
					throw new IllegalArgumentException("can not add duplicate node to tree : ("+x+","+y+")");
				}
				if (level % 2 == 0) {// even level
					if (x < current.xCoordinate) {
						// left child
						parent = current;
						current = current.left;
					} else {
						// right child
						parent = current;
						current = current.right;
					}
				} else {// odd level
					if (y < current.yCoordinate) {
						// left child
						parent = current;
						current = current.left;
					} else {
						// right child
						parent = current;
						current = current.right;
					}
				}
				level++;
			}

			current = new TwoDTreeNode(x, y, null, null);
			if ((level-1) % 2 == 0) {// even level
				if (x < parent.xCoordinate) {
					// left child
					parent.left = current;
				} else {
					// right child
					parent.right = current;
				}
			} else {// odd level
				if (y < parent.yCoordinate) {
					// left child
					parent.left = current;
				} else {
					// right child
					parent.right = current;
				}
			}
		}
// 		levelOrderPrint();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @returns true if a node with the given x and y coordinates exist in the
	 *          tree.
	 */
	public boolean contains(int x, int y) {
		if (isEmpty()) {
			return false;
		} else {
			TwoDTreeNode parent = null;
			TwoDTreeNode current = root;
			int level = 0;
			while (current != null) {
				if (current.xCoordinate == x && current.yCoordinate == y){
					return true;
				}
				if (level % 2 == 0) {// even level
					if (x < current.xCoordinate) {
						// left child
						parent = current;
						current = current.left;
					} else if (x > current.xCoordinate) {
						// right child
						parent = current;
						current = current.right;
					} else {
						return true;
					}
				} else {// odd level
					if (y < current.yCoordinate) {
						// left child
						parent = current;
						current = current.left;
					} else if (y > current.yCoordinate) {
						// right child
						parent = current;
						current = current.right;
					} else {
						return true;
					}
				}
				level++;
			}
		}
		return false;
	}

	/**
	 * A method which prints a level order traversal of the tree
	 */
	public void levelOrderPrint() {
		Queue<TwoDTreeNode> queue = new LinkedList<TwoDTreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TwoDTreeNode node = queue.poll();
			System.out.print("(" + node.xCoordinate + "," + node.yCoordinate + ")");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		System.out.println();
	}

	/**
	 * 
	 * @author esahe2 A nested class encapsulating a node in the TwoDTree
	 */
	private static class TwoDTreeNode {
		/*************
		 * attributes
		 ************/
		int xCoordinate;
		int yCoordinate;
		TwoDTreeNode right;
		TwoDTreeNode left;

		/***************
		 * constructors
		 **************/
		TwoDTreeNode(int x, int y) {
			xCoordinate = x;
			yCoordinate = y;
		}

		TwoDTreeNode(int x, int y, TwoDTreeNode leftChild, TwoDTreeNode rightChild) {
			xCoordinate = x;
			yCoordinate = y;
			left = leftChild;
			right = rightChild;
		}
	}

	private boolean isEmpty() {
		if (root == null) {
			return true;
		} else
			return false;
	}

}