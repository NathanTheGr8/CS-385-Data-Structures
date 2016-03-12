package mp04;

/**
 * Pair class Stores a pair of integers
 * 
 * @author UIS computer science department
 *
 */
public class Pair {

	private int first;
	private int last;

	public Pair(int first, int last) {
		this.first = first;
		this.last = last;

	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public String toString() {
		return "(" + this.first + " , " + this.last + ")";
	}

}