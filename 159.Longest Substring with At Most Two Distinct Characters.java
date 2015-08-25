public int lengthOfLongestSubstringTwoDistinct(String s) {

	int start = 0;
	int numDistinct = 0;
	int max = 0;
	int[] count = new int[256];

	for (int end = 0; end < s.length(); end++) {
		if (count[s.charAt(end)] == 0) {
			numDistinct++;
		}
		count[s.charAt(end)]++;

		while (numDistinct > 2) {
			count[s.charAt(start)]--;
			if (count[s.charAt(start)] == 0) {
				numDistinct--;
			}
			start++;
		}
		max = Math.max(end-start+1, max);
	}	
	return max;
}