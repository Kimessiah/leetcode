public List<List<Integer>> combinationSum(int[] candidates, int target) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> curr = new ArrayList<Integer>();
	Arrays.sort(candidates);

	helper(res, curr, candidates, 0, target, 0);
	return res;
}

void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int sum, int target, int i) {

	if (sum > target) return;
	if (sum == target) {
		res.add(curr);
		return;
	}

	for (int j = i; j < candidates.length; j++) {
		List<Integer> temp = new ArrayList<Integer>(curr);
		temp.add(candidates[j]);
		helper(res, temp, candidates, sum + candidates[j], target, j);
	}
}