package mp04;

public class Test {

	public static void main(String[] args) {
		int[] test1 = new int[10];
		DifferencePairs.fillArray(test1);
		DifferencePairs.shuffle(test1);
		DifferencePairs.printArray(test1);
		System.out.println("");
		DifferencePairs.quickSort(test1);
		DifferencePairs.printArray(test1);

		DifferencePairs tester = new DifferencePairs();
		Pair[] result1 = tester.findPairs(test1, 3);
		DifferencePairs.printPairs(result1);
	}

}
