// Time O()  Space O()
public List<String> generateParenthesis(int n) {
	List<String> res = new ArrayList<String>();

	helper(res, "", n, n);
	return res;
}

void helper(List<Sting> res, String s, int l, int r) {
	if (r < l) {
		return;
	}

	if (l == 0 && r == 0) {
		res.add(s);
		return;
	}

	if (l > 0) {
		helper(res, s + "(", l - 1, r);
	}

	if (r > l) {
		helper(res, s + ")", n, l , r - 1);
	}
}