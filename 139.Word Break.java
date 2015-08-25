// Time O(n^2)   Space O(n)
public boolean wordBreak(String s, Set<String> wordDict) {

	if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;

	boolean[] res = new boolean[s.length()+1];
	res[0] = true;

	for (int i = 0; i < s.length(); i++) {

		StringBuilder substr = new StringBuilder(s.substring(0, i+1));
		for (int j = 0; j <= i; j++) {
			if (res[j] && wordDict.contains(substr.toString())) {
				res[i+1] = true;
				break;
			}
			substr.deleteCharAt(0);
		}
	}
	return res[s.length()];
}