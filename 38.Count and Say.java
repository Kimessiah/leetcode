public String countAndSay(int n) {
	if (n < 1) return "";

	String s = "1";
	for (int i = 1; i<n; i++) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < s.length(); j++) {
			int count = 1;
			while (j+1 < s.length() && s.charAt(j) == s.charAt(j+1)) {
				count++;
				j++;
			}
			sb.append(count);
			sb.append(s.charAt(j));
		}
		s = sb.toString(); 
	}
	return s;
}