package mp04;

import java.util.ArrayList;

public class DifferencePairs {

	public Pair[] findPairs(int arr[], int diff) {
		// Pair[] result = new Pair[arr.length]; //there could be length*length
		// pairs
		ArrayList<Pair> result = new ArrayList<Pair>();
			
		int low = 0;
		int high = low + 1;
		while (low < high && high < arr.length) {
			if (Math.abs(arr[low] - arr[high]) < diff) {
				high++;
			} else if (Math.abs(arr[low] - arr[high]) > diff) {
				low++;
			} else {
				Pair correctDiff = new Pair(arr[low], arr[high]);
				result.add(correctDiff);
				int currHigh = arr[high];
				int currLow = arr[low];
				high++;
				low++;
				while (high < arr.length && arr[high] == currHigh) {
					high++;
				}
				while (arr[low] == currLow) {
					low++;
				}
			}
			
			if(low == high){
				high++;
			}
		}
		return toArray(result);
	}

	public static void quickSort(int[] test1) {
		quickSort(test1, 0, test1.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length <= 1) {
			return;
		} else if (low >= high) {
			return;
		} else {
			int mid = (low + high) / 2;
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

	public static void printArray(int[] test1) {
		for (int i = 0; i < test1.length; i++) {
			System.out.print(test1[i] + " ");
		}
		System.out.println();
	}

	public static void printPairs(Pair[] arr) {
		if (arr == null) {
			System.out.println("No Pairs Found");
		} else {
			for (int i = 0; i < arr.length; i++) {
				System.out.print("(" + arr[i].getFirst() + "," + arr[i].getLast() + ")" + " ");
			}
			System.out.println();
		}
	}

	public static void shuffle(int[] test1) {
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

	public static void fillArray(int[] test1) {
		// for (int i = 0; i < test1.length; i++) {
		// test1[i] = i;
		// }
		for (int i = 0; i < test1.length; i++) {
			test1[i] = (int) (Math.random() * 50);
		}
	}

	// Tried to write this using generics. Was confussed how to make a generic
	// std array
	private Pair[] toArray(ArrayList<Pair> list) {
		Pair[] result = new Pair[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;

	}

}
