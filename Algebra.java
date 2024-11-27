
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) { // x1 = x2 +x1
				result++;
			}
		} else {
			for (int i = 0; i > x2; i--) { // x1 = x1 + (-x2)
				result--;
			}
		}

		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) { // x1 = x1 -x2
				result--;
			}
		} else {
			for (int i = 0; i > x2; i--) { // x1 = x1 -(-x2)
				result++;
			}
		}
		return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				result = plus(result, x1);
			}
		} else {
			for (int i = 0; i > x2; i--) {
				result = minus(result, x2);
				result--;
			}

		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int p = 1;
		for (int i = 0; i < n; i++) {
			p = times(p, x); // pow = pow * times
		}
		return p;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int d = 0;
		if (x1 == 0)
			return 0;
		if (x1 >= x2) {
			while (x1 >= x2) {
				x1 = minus(x1, x2);
				d++;
			}
		} else {
			while (x1 < x2) {
				x1 = plus(x1, x2);
				d--;
			}
		}
		return d;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int result;
		result = minus(x1, times(x2, div(x1, x2)));
		return result;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int sqrt = 0;
		while (times(sqrt, sqrt) <= x) {
			sqrt++;
		}

		return sqrt - 1;
	}

}