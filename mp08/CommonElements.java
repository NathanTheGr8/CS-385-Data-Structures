package mp08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElements {

	public static <T> List<T> findCommonElements(List<List<T>> collections) {
		Set<T> common = new HashSet<T>(collections.get(0));
		for(List<T> curr : collections){
			common.retainAll(curr);
		}

		List<T> result = new ArrayList<T>();
		result.addAll(common);
		return result;

	}

	public static void printList(List<Integer> result) {
		System.out.print("(");
		for (Integer item : result) {
			System.out.print(item + ", ");
		}
		System.out.println(")");
	}
}
