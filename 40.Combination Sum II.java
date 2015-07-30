public List<List<Integer>> combinationSum2(int[] candidates, int target) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> curr = new ArrayList<Integer>();
	Arrays.sort(candidates);

	helper(res, curr, candidates, 0, target, 0);
	return res;
}

void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int sum, int target, int i) {

	if (i == candidates.length || sum > target) return;
	if (sum == target) {
		res.add(curr);
		return;
	}

	for (int j = i; j < candidates.length; j++) {
		List<Integer> temp = new ArrayList<Integer>(curr);
		temp.add(candidates[j]);
		helper(res, temp, candidates, sum + candidates[j], target, j+1);
		while (j+1 < candidates.length && candidates[j]==candidates[j+1]) j++;  // Remove Duplicate Combination
	}
}