public int trailingZeroes(int n) {

	if (n <= 0) return 0;

	int res = 0;

	for (long i = 5; n / i >= 1; i *= 5) {
		res += n / i;
	}
	return res;
}