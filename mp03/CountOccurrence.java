package mp03;

/**
 * A class to count the number of occurrences of an element in a 2-D array
 * 
 * @author nathan davis
 *
 */
public class CountOccurrence {
	static int[][] rotated;
	static boolean isRotated = false;

	/**
	 * This method counts the number of occurrences of query in the array. You
	 * have to implement this method. You may use any helper method you want.
	 * 
	 * @param query
	 * @return
	 */
	public static int count(int[][] array, int query) {
		int count = 0;
		if (!isRotated) {
			rotated = rotateArray(array);
			System.out.println("rotated done");
			isRotated = true;
		}
		for (int[] row : rotated) {
			count = count + countRow(row, query);
		}
		return count;
	}

	private static int countRow(int[] array, int query) {
		int count = 0;
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			int diff = array[mid] - query;
			if (diff == 0) {
				count = countOcc(array, query, mid);
				return count;

			} else if (diff < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return 0;
	}

	private static int[][] rotateArray(int[][] original) {
		int[][] rotated = new int[original[0].length][original.length];
		int r = 0;
		for (int[] row : original) {
			int c = 0;
			for (int col : row) {
				rotated[c][r] = col;
				c++;
			}
			r++;
		}

		return rotated;
	}

	private static void printArray(int[][] array) {
		for (int[] row : array) {
			for (int curr : row) {
				System.out.print(curr + " ");
			}
			System.out.println();
		}
	}

	private static int countOcc(int[] array, int query, int index) {
		int count = 0;
		int r = index;
		int l = index - 1;

		// count left
		while (l >= 0 && array[l] == query) {
			count++;
			l--;
		}

		// count right
		while (r < array.length && array[r] == query) {
			count++;
			r++;
		}

		return count;
	}

}