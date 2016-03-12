package lab05;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	int size;

	public DoublyLinkedList() {
		clear();
	}

	public DoublyLinkedList(Node<T> head, Node<T> tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public void add(T item) {
		addLast(item);
	}

	public void addFirst(T item) {
		if (head == null) {
			head = new Node<T>(item, null, null);
			tail = head;
		} else {
			head.setPrev(new Node<T>(item, null, head));// This is the problem
			head = head.getPrev();

		}
		size++;
	}

	public void addLast(T item) {
		if (tail == null) {
			tail = new Node<T>(item, null, null);
			head = tail;
		} else {
			tail.setNext(new Node<T>(item, tail, null));
			tail = tail.getNext();

		}
		size++;
	}

	public void add(T item, int loc) {
		if (loc < 0 || loc > size) {
			throw new IndexOutOfBoundsException("Invaid Loc: " + loc);
		} else if (loc == 0) {
			addFirst(item);
		} else if (loc == size) {
			addLast(item);
		} else {
			Node<T> temp = getNode(loc);
			Node<T> newNode = new Node<T>(item, temp.getPrev(), temp);
			temp.getPrev().setNext(newNode);
			temp.setPrev(newNode);
		}

	}

	public void removeFirst() {
		if (head == null) {
			throw new NoSuchElementException("No Head, Link may be empty");
		} else if (size == 1) {
			clear();
		} else {
			head = head.getNext();
			head.getPrev().setNext(null);
			head.setPrev(null);
			size -= 1;
		}
	}

	public void removeLast() {
		if (tail == null) {
			throw new NoSuchElementException("No Tail, Link may be empty");
		} else if (size == 1) {
			clear();
		} else {
			tail = tail.getPrev();
			tail.getNext().setPrev(null);
			tail.setNext(null);
			size -= 1;
		}
	}

	public void remove(int loc) {
		if (loc < 0 || loc >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		} else if (loc == 0) {
			removeFirst();
		} else if (loc == size - 1) {
			removeLast();
		} else {
			Node<T> temp = getNode(loc);
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			temp.setNext(null);
			temp.setPrev(null);
			size--;
		}
	}

	private Node<T> getNode(int loc) {
		Node<T> temp = head;
		for (int i = 0; i < loc; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	public T get(int loc){
		if (loc < 0 || loc >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return getNode(loc).getData();
	}
	
	public void set(T item, int loc){
		if (loc < 0 || loc >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		getNode(loc).setData(item);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Node<T> temp = head;
		while (temp != null) {
			sb.append(temp.getData());
			if (temp.getNext() != null) {
				sb.append(",");
			}
			temp = temp.getNext();
		}
		return sb.toString();
	}

	public int size() {
		return size;
	}

}
