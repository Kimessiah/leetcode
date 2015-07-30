// NP Problem
public List<List<Integer>> combine(int n, int k) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	if (k <=0 || n < k) return res;

	helper(res, new ArrayList<Integer>(), n, k, 1);

	return res;
}

void helper(List<List<Integer>> result, List<Integer> curr, int n, int k, int start) {

	if (curr.size() == k) {
		result.add(new ArrayList<Integer>(curr));
		return;
	}

	for (int i = start; i <=n; i++) {
		curr.add(i);
		helper(result, curr, n, k, i+1);
		curr.remove(curr.size()-1);
	}
}