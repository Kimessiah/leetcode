public int minCut(String s) {

    if (s == null || s.length() == 0) return 0;

	boolean[][] isPalindrome = new boolean[s.length()][s.length()];

	for (int i = s.length()-1; i >= 0; i--) {
		for (int j = i; j < s.length(); j++) {
			if (s.charAt(i) == s.charAt(j) && (j-i < 2 || isPalindrome[i+1][j-1])) {
				isPalindrome[i][j] = true;
			}
		}
	}

	int[] cut = new int[s.length()+1];
    cut[0] = -1;	// This is important
    
	for (int i = 0; i < s.length(); i++) {

		cut[i+1] = i;

		for (int j = 0; j <= i; j++) {
			if (isPalindrome[j][i]) {
				cut[i+1] = Math.min(cut[i+1], cut[j]+1);
			}			
		}
	}
	return cut[s.length()];
}