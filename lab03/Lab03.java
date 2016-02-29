package lab03;

public class Lab03 {
	public static void main(String[] args) {
		System.out.println(printStringForward("Fuck"));
		System.out.println(printStringBackward("Fuck"));

		System.out.println(sumDigits(55));

		System.out.println(countPairs("axaxa"));

		int[] a = { 1, 2, 7, -1, 6 };
		System.out.println(targetToSum(a, 3, 0));
	}

	public static String printStringForward(String s) {
		if (s.length() == 1)
			return s;
		else {
			return s.charAt(0) + printStringForward(s.substring(1));
		}

	}

	public static String printStringBackward(String s) {
		if (s.length() == 1)
			return s;
		else {
			// return s.charAt(s.length() - 1) +
			// printStringForward(s.substring(0, s.length() - 1));
			return printStringForward(s.substring(1)) + s.charAt(0);
		}

	}

	public static int sumDigits(int i) {
		if (i / 10 == 0) {
			return i;
		} else {
			return i % 10 + sumDigits(i / 10);
		}
	}

	public static int countPairs(String s) {
		if (s.length() <= 2) {
			return 0;
		} else {
			if (s.charAt(0) == s.charAt(2)) {
				return 1 + countPairs(s.substring(1));
			} else {
				return countPairs(s.substring(1));
			}
		}
	}

	public static boolean targetToSum(int[] a, int target, int index) {
		if (index == a.length) {
			return target == 0;
		} else {
			return targetToSum(a, target - a[index], index + 1) || targetToSum(a, target, index + 1);
		}
	}

}
