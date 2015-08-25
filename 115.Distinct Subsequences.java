// Time O(m * n)   Space O(m * n)
public int numDistinct(String s, String t) {

	if (s == null || t == null) return 0;

	if (s.length() == 0) return 0;
	if (t.length() == 0) return 1;

	int[][] res = new int[t.length()][s.length()];

	res[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;

	for (int i = 1; i < s.length(); i++) {
		res[0][i] = (t.charAt(0) == s.charAt(i) ? 1 : 0) 
			+ res[0][i-1];
	}

	for (int i = 1; i < t.length(); i++) {
		for (int j = 1; j < s.length(); j++) {
			res[i][j] = (t.charAt(i) == s.charAt(j) ? 
				res[i-1][j-1] : 0) + res[i][j-1];
		}
	}

	return res[s.length()-1][t.length()-1];
}