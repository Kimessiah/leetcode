public int lengthOfLastWord(String s) {

	if (s == null || s.length() == 0) return 0;

	String trimed = s.trim();
	if (trimed.length() == 0) return 0;

	int res = 0;
	int i = trimed.length() - 1;
	while (i >= 0) {
		if (trimed.charAt(i) != ' ') {
			res++;
			i--;
		} else {
			break;
		}
	}
	return res;
}