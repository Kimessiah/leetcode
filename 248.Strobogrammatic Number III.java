Map<Character, Character> map = new HashMap<Character, Character>(){{
	put('0', '0');
	put('1', '1');
	put('8', '8');
	put('6', '9');
	put('9', '6');
}};

static int count = 0;

public int strobogrammaticInRange(String low, String high) {

	int res = 0;
	for (int i = low.length(); i <= high.length(); i++) {
		count = 0;
		helper(new char[i], low, high, 0, i-1);
		res += count;
	}
    return res;
}

void helper(char[] charArr, String low, String high, int lo, int hi) {

	if (lo > hi) {
		String s = new String(charArr);
		if ((charArr[0] != '0' || charArr.length == 1) && compare(low, s) && compare(s, high)) {
			count++;
		}
		return;
	}

	for (char c : map.keySet()) {
		charArr[lo] = c;
		charArr[hi] = map.get(c);

		if ((lo == hi && c == map.get(c)) || lo < hi) {
			helper(charArr, low, high, lo+1, hi-1);
		}
	}
}

boolean compare(String s1, String s2) {

	if (s1.length() != s2.length()) return s1.length() < s2.length();

	int i = 0;
	while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) i++;

	return i == s1.length() || s1.charAt(i) < s2.charAt(i);
}