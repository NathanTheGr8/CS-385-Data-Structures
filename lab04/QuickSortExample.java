package lab04;

public class QuickSortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = new int[100000];
		fillArray(test1);
		shuffle(test1);
		printArray(test1);
		System.out.println("");
		quickSort(test1);
		printArray(test1);

	}

	public static void quickSort(int[] test1) {
		quickSort(test1, 0, test1.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (arr.length <= 1) {
			return;
		} else if (low >= high) {
			return;
		} else {
			int mid = (arr[low] + arr[high]) / 2;
			int pivot = median(arr[low], arr[mid], arr[high]);
			int tempL = low;
			int tempH = high;
			while (tempL <= tempH) {
				while (arr[tempL] < pivot) {
					tempL++;
				}
				while (arr[tempH] > pivot) {
					tempH--;
				}
				if (tempL <= tempH) {
					swap(arr, tempL, tempH);
					tempL++;
					tempH--;
				}
			}
			if (low < tempH) {
				quickSort(arr, low, tempH);
			}
			if (high > tempL) {
				quickSort(arr, tempL, high);
			}
		}
	}

	private static int median(int a, int b, int c) {
		int median = a;
		if (a > b && a > c) {
			median = Math.max(b, c);
		} else if (b > a && b > c) {
			median = Math.max(a, c);
		} else if (c > a && c > b) {
			median = Math.max(a, b);
		}
		return median;
	}

	private static void printArray(int[] test1) {
		for (int i = 0; i < test1.length; i++) {
			System.out.print(test1[i] + " ");
		}
	}

	private static void shuffle(int[] test1) {
		for (int j = test1.length - 1; j >= 0; j--) {
			int randomLoc = (int) (Math.random() * j);
			swap(test1, j, randomLoc);
		}

	}

	private static void swap(int[] test1, int j, int randomLoc) {
		int temp = test1[j];
		test1[j] = test1[randomLoc];
		test1[randomLoc] = temp;
	}

	private static void fillArray(int[] test1) {
		for (int i = 0; i < test1.length; i++) {
			test1[i] = i;
		}
	}

}
