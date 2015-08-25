public boolean isPalindrom(String s) {

	if (s == null || s.length() == 0) return true;

	s = s.trim();
	if (s.length() == 0) return true;

	int start = 0;
	int end = s.length() - 1;

	while (start <= end) {
		char c1 = s.charAt(start);
		char c2 = s.charAt(end);

		if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
			if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
			start++;
			end--;
		} else if (Character.isLetterOrDigit(c1)) {
			end--;
		} else if (Character.isLetterOrDigit(c2)) {
			start++;
		} else {
			start++;
			end--;
		}
	}	
	return true;
}