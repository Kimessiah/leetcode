// Time O(logn)
public double myPow(double x, int n) {

	if (n == 0) return 1;
	if (n == 1) return x;
	if (x == 1) return 1;

	if (n < 0) {
		if (n == Integer.MIN_VALUE) {
			return 1 / (x * myPow(x, Integer.MAX_VALUE));
		} else {
			return 1 / myPow(x, -n);
		}
	} else {
		if (n % 2 == 0) {
			double d = myPow(x, n/2);
			return d * d;
		} else {
			return x * myPow(x, n -1);
		}
	}
}