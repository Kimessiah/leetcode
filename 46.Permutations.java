// Time O(n*n!)
public List<List<Integer>> permute(int[] nums) {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	if (nums == null || nums.length == 0) return result;

	helper(result, new ArrayList<Integer>(), nums);

	return result;
}

void helper(List<List<Integer>> result, List<Integer> curr, int[] nums) {

	if (curr.size() == nums.length) {
		result.add(new ArrayList(curr));
		return;
	}

	for (int i = 0; i< nums.length; i++) {
		if (curr.contains(nums[i])) {
			continue;
		}
		curr.add(nums[i]);
		helper(result, curr, nums);
		curr.remove(curr.size()-1);
	}
}

// Iterative
public List<List<Integer>> permute(int[] nums) {

}