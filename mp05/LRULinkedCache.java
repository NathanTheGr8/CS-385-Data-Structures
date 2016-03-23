package mp05;

/**
 * 
 * @author esahe2
 *
 * @param <K>
 *            The type of the key
 * @param <V>
 *            The type of the value
 */

public class LRULinkedCache<K, V> {

	public static void main(String[] args) {
		LRULinkedCache<Integer, Integer> cache = new LRULinkedCache<Integer, Integer>(4);
		cache.LRUPut(1, 5);
		System.out.println(cache.toString());
		cache.LRUPut(2, 2);
		System.out.println(cache.toString());
		cache.LRUPut(3, 7);
		System.out.println(cache.toString());
		cache.LRUPut(4, 9);
		System.out.println(cache.toString());
		cache.LRUPut(1, 9);
		System.out.println(cache.toString());

		System.out.println("Get 3 " + cache.LRUGet(3));
		System.out.println(cache.toString());
		cache.LRUPut(5, 10);
		System.out.println(cache.toString());
		System.out.println("Get 4 " + cache.LRUGet(4));
		System.out.println(cache.toString());
		System.out.println("Get 10 " + cache.LRUGet(10));
		System.out.println(cache.toString());
	}
	/*************
	 * attributes
	 ************/

	/** current number of items in cache */
	private int size;

	/** The capacity of cache. */
	private int capacity;

	/** reference to list header node */
	private CacheNode<K, V> head;

	/** reference to list tail node */
	private CacheNode<K, V> tail;

	/***************
	 * constructors
	 **************/

	/**
	 * return a new, empty cache with a given capacity
	 */
	public LRULinkedCache(int capacity) {
		this.capacity = capacity;
		// empty this LinkedList
		clear();
	}

	/**********
	 * methods
	 *********/

	/**************************************
	 * methods inherited from class Object
	 *************************************/

	/**
	 * return a String representation of the LinkedList
	 *
	 * items are listed in order from beginning to end in comma-delimited
	 * fashion
	 */
	public String toString() {
		String s = "";

		CacheNode<K, V> current = head.next;
		while (current != tail) {
			s += "(" + current.key + "," + current.value + ")";
			if (current.next != tail)
				s += ",";
			current = current.next;
		}

		return s;
	}

	/**********************************************
	 * methods inherited from interface Collection
	 *********************************************/

	/**
	 * empty the LRUCache size will be set to zero
	 */
	public void clear() {
		// reset header node
		head = new CacheNode<K, V>(null, null, null, null);
		// reset tail node
		tail = new CacheNode<K, V>(null, null, head, null);
		head.next = tail;
		tail.prev = head;
		// reset size to 0
		size = 0;

	}

	/**
	 * return the number of items in the cache
	 */
	public int size() {
		return size;
	}

	/**
	 * return true if the cache is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This operation returns the value for a given key in the cache. It returns
	 * null if the data is not currently in the cache. It also moves the data
	 * that is accessed to the end of the list and inserts it before tail
	 */
	public V LRUGet(K key) {
		CacheNode<K, V> found = search(key);
		if (found == null) {
			return null;
		}
		remove(found);
		putAtEnd(found);
		return found.value;
	}

	// doesn't decrement size fyi
	private void remove(CacheNode<K, V> node) {
		CacheNode<K, V> prevNode = node.prev;
		CacheNode<K, V> nextNode = node.next;
		node.prev = null;
		node.next = null;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}

	/**
	 * puts a new node with key and value in the cache and adds it to the end of
	 * the cache If the cache is full, it removes the first node (The least
	 * recently used node)before adding the new node. If a node with the given
	 * key already exists in the cache, it updates the value for the key and
	 * moves the node with the key to the end of the cache
	 * 
	 * @param key
	 * @param value
	 */
	public void LRUPut(K key, V value) {
		// To Do: Your implementation goes here
		CacheNode<K, V> found = search(key);
		if (found != null) {
			found.value = value;
		} else {
			CacheNode<K, V> newNode = new CacheNode<K, V>(key, value, null, null);
			if (size >= capacity) {
				removeFirst();
			}
			putAtEnd(newNode);
			size++;
		}
	}

	//Doesn't decrement size
	private void removeFirst() {
		CacheNode<K, V> oldHead = head.next;
		CacheNode<K, V> newHead = oldHead.next;
		head.next = newHead;
		newHead.prev = head;
		oldHead.next = null;
		oldHead.prev = null;
	}

	//Doesn't increment size
	private void putAtEnd(CacheNode<K, V> newNode) {
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
	}

	//Returns null if not found
	private CacheNode<K, V> search(K key) {
		CacheNode<K, V> curr = head.next;
		while (curr != null && curr.key != null && !curr.key.equals(key)) {
			curr = curr.next;
		}
		//Fucking Bryan your code returns the tail!!!!
		if (curr.equals(tail)){
			return null;
		}
		else
			return curr;
	}
	
	public void toString2(){
		CacheNode<K,V> curr = head.next;
		while(curr != tail){
			System.out.println("("+curr.key+","+ curr.value+")");
			curr = curr.next;
		}
	}

	/**
	 * nested class ListNode
	 *
	 * encapsulates the fundamental building block of a LRU cache node contains
	 * a key and value, as well as references to both the next and previous
	 * nodes in the cache K is the type of the key and V is the type of value
	 */
	private static class CacheNode<K, V> {

		/*************
		 * attributes
		 ************/

		// TODO: define attributes and constructor for CacheNode
		CacheNode<K, V> next;
		CacheNode<K, V> prev;
		K key;
		V value;

		public CacheNode(K key, V value, CacheNode<K, V> prev, CacheNode<K, V> next) {
			this.next = next;
			this.prev = prev;
			this.key = key;
			this.value = value;
		}

		public CacheNode() {

		}

	}

}
