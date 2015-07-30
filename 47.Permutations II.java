public List<List<Integer>> permuteUnique(int[] nums) {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if (nums == null || nums.length == 0) return result;

	boolean[] isVisited = new boolean[nums.length];
	helper(result, new ArrayList(), nums, isVisited);
	return result;
}


void helper(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] isVisited) {

	if (curr.size() == nums.length) {
		result.add(new ArrayList(curr));
		return;
	}

	for (int i=0; i< nums.length; i++) {
		if (isVisited[i] || (i > 0 && nums[i] == nums[i - 1] && isVisited[i - 1] == false)) {
			continue;
		}
		isVisited[i] = true;
		curr.add(nums[i]);
		helper(result, curr, nums, isVisited);
		isVisited[i] = false;
		curr.remove(curr.size()-1);
	}
}