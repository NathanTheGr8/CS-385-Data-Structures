package mp08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
	public static void main(String[] args) {
		List<List<Integer>> collections = new ArrayList<List<Integer>>();
		collections.add(0, new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13)));

		collections.add(1, new ArrayList<Integer>(Arrays.asList(15, 24, 50, 12, 3, 9)));

		collections.add(2, new ArrayList<Integer>(Arrays.asList(78, 65, 24, 13, 9, 3, 12)));

		collections.add(3, new ArrayList<Integer>(Arrays.asList(15, 78, 14, 3, 2, 9, 44, 12)));

		List<Integer> result = CommonElements.findCommonElements(collections);
		
		CommonElements.printList(result);
		
		List<List<Integer>> collections2 = new ArrayList<List<Integer>>();
		collections2.add(0, new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13, 14, 16)));

		collections2.add(1, new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 11, 15, 7, 13, 14, 16)));

		collections2.add(2, new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13, 15, 16)));

		collections2.add(3, new ArrayList<Integer>(Arrays.asList(1, 3, 9, 20, 12, 14, 7, 13, 13, 16)));

		List<Integer> result2 = CommonElements.findCommonElements(collections2);
		
		CommonElements.printList(result2);
	}
}
