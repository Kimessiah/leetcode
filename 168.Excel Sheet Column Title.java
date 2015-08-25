public String convertToTitile(int n) {

	if (n <= 0) return null;

	StringBuilder res = new StringBuilder();

	while (n != 0) {
		n--;
    	char c = (char) ('A' + (n % 26));
    	res.append(c);
		n /= 26;
	}
	return res.reverse().toString();
}