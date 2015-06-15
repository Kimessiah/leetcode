public boolean isPalindrome(int x) {
	if (x < 0) return false;

	int l = 0;
	int r = 0;
	int div = 1;

	while (x/div >= 10) {
		div *= 10;
	}

	while (x != 0) {

		r = x % 10;
		l = x / div;
		if (l != r) return false;
		x = (x % div) / 10;
		div /= 100;
	}
	return true;
}