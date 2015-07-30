// Time O(n)
public int climbStairs(int n) {

	if (n <= 0) return 0;

	int w1 = 1;
	int w2 = 2;

	if (n == 1) return 1;
	if (n == 2) return 2;

	for (int i = 3; i <=n; i++) {
		int w3 = w1 + w2;
		w1 = w2;
		w2 = w3;
	}
	return w2;
}