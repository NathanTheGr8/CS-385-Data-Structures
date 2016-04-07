package lab06;

public class Stack<T extends Comparable<T>> {

	int size;
	Node<T> top;

	public Stack() {
		clear();
	}

	public void clear() {
		top = null;
		size = 0;
	}

	public void push(T item) {
		if(isEmpty()){
			top = new Node<T>();
			top.item = item;
			top.maxVal = item;
		}
		else {
			Node<T> newNode = new Node<T>();
			newNode.item = item;
			if (top.item.compareTo(item) < 0) {
				newNode.maxVal = item;
			} else {
				newNode.maxVal = top.maxVal;
			}
			newNode.next = top;
			top = newNode;
		}

		size++;
	}

	public T pop() throws StackUnderFlowException {
		if (isEmpty()) {
			throw new StackUnderFlowException("Stack is empty");
		}
		Node<T> result = top;
		top = top.next;
		size--;
		result.next = null;
		return result.item;
	}

	public T peek() {
		if (isEmpty()) {
			throw new StackUnderFlowException("Stack is empty");
		}
		return top.item;
	}

	public T getMaxVal() {
		return top.maxVal;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else
			return false;
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> temp = top;
		while (temp != null) {
			sb.append(temp.item);
			if (temp.next != null)
				sb.append(", ");
			temp = temp.next;
		}
		return sb.toString();
	}

	private class Node<E> {
		E item;
		Node next;
		E maxVal;
	}
}
