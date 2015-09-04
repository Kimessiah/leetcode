public List<List<Integer>> combinationSum3(int k, int n) {

	List<List<Integer>> res = new ArrayList<>();

	if (k <= 0 || n <= 0) return res;

	helper(res, new ArrayList<Integer>(), k, n, 0, 1);

	return res;        
}

void helper(List<List<Integer>> res, List<Integer> curr, int k, int n, int sum, int i) {

	if (sum > n || curr.size() > k) return;

	if (curr.size() == k && sum == n) {
		res.add(new ArrayList<Integer>(curr));
		return;
	}

	for (int j = i; j <= 9; j++) {
		curr.add(j);
		helper(res, curr, k, n, sum + j, j + 1);
		curr.remove(curr.size()-1);
	}
}