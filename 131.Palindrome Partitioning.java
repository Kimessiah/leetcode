public List<List<String>> partition(String s) {

	List<List<String>> res = new ArrayList<List<String>>();

	if (s == null || s.length() == 0) return res;

	helper(res, new ArrayList<String>(), s, 0);
	return res;
}

void helper(List<List<String>> res, List<String> curr, String s, int start) {

	if (start == s.length()) {
		res.add(new ArrayList<String>(curr));
		return;
	}

	for (int i = 1; i <= s.length()-start; i++) {
		String substring = s.substring(start, start+i);
		if (isPanlindrome(substring)) {
			curr.add(substring);
			helper(res, curr, s, start+i);
			curr.remove(curr.size()-1);
		}
	}
} 

boolean isPanlindrome(String s) {
	int i = 0; 
	int j = s.length()-1;

	while (i <= j) {
		if (s.charAt(i) != s.charAt(j)) {
			return false;
		}
		i++;
		j--;
	}
	return true;
}