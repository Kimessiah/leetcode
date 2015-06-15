// O(n^2) time, O(n^2) space
public String longestPalindrome(String s) {
	if (s==null || s.length()==0)
		return null;

	boolean[][] table = new boolean[s.length()][s.length()];
	int maxLen = 1, start = 0;

	for (int i=0; i<s.length(); i++) {
		table[i][i] = true;
	}

	for (int i=0; i<s.length()-1; i++) {
		if (s.charAt(i) == s.charAt(i+1)) {
			table[i][i+1] = true;
			maxLen = 2;
			start = i;
		}
	}

	for (int len=3; len<=s.length(); len++) {
		for (int i=0; i+len<=s.length(); i++) {
			if (table[i+1][i+len-2] && s.charAt(i)==s.charAt(i+len-1)) {
				table[i][i+len-1] = true;
				if (len > maxLen) {
					maxLen = len;
					start = i;
				}
			}
		}
	}
	return s.substring(start, start+maxLen);
}