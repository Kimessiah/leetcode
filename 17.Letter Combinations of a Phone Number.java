// O(4^n)
static Map<Character, String> map = new HashMap<Character, String>() {{
	put('2', "abc"); put('3', "def"); put('4', "ghi");
	put('5', "jkl"); put('6', "mno"); put('7', "pqrs");
	put('8', "tuv"); put('9', "wxyz");
}};

public List<String> letterCombinations(String digits) {

	List<String> res = new ArrayList<String>();
	if (digits == null || digits.length() == 0) return res;
	helper(res, "", digits, 0);
	return res;
}

public void helper(List<String> res, String curr, String digits, int start) {

	if (start == digits.length()) {
		res.add(curr);
		return;
	}
	String s = map.get(digits.charAt(start));

	for (int i=0; i<s.length(); i++) {
		helper(res, curr + s.charAt(i), digits, start + 1);
	}
}