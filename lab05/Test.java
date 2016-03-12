package lab05;

public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(6);
		dll.addFirst(5);
		dll.addFirst(4);
		dll.addFirst(3);
		dll.addFirst(2);
		dll.addFirst(1);
		dll.addLast(7);
		dll.addLast(8);
		dll.add(100,3);
		dll.add(200,0);
		dll.add(300,dll.size());
//		dll.add(400,100);
//		dll.add(400,-1);
		System.out.println(dll);
	}
}
