public int titleToNumber(String s) {

	if (s == null && s.length() == 0) return 0;

	int res = 0;
	int t = 0;

	for (int i = s.length()-1; i >= 0; i--) {
		char c = s.charAt(i);

		res += Math.pow(26, t) * (c - 'A' + 1);
		t++;
	}
	return res;
}