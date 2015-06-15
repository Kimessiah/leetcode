// all substrings that start before or at index i (repeated character) 
// would be less than your current maximum

// O(n), 2n steps
public int lengthOfLongestSubstring(String s) {
	if (s == null || s.length() == 0)
		return 0;

	int start = 0;
	int end = 0;
	int maxLen = 1;
	boolean[] exist = new boolean[256];

	while (end < s.length()) {
		while (exist[s.charAt(end)]) {
			exist[s.charAt(start)] = false;
			start++;
		}
		exist[s.charAt(end)] = true;
		maxLen = Math.max(end-start+1, maxLen);
		end++;
	}
	return maxLen;
}

// O(n), n steps
public int lengthOfLongestSubstring(String s) {
   int[] charMap = new int[256];
   Arrays.fill(charMap, -1);
   int i = 0, maxLen = 0;
   for (int j = 0; j < s.length(); j++) {
      if (charMap[s.charAt(j)] >= i) {
         i = charMap[s.charAt(j)] + 1;
      }
      charMap[s.charAt(j)] = j;
      maxLen = Math.max(j - i + 1, maxLen);
}
   return maxLen;
}