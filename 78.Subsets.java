// Time O(2^n)   Space O(2^n)
// Iterative
public List<List<Integer>> subsets(int[] nums) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	res.add(new ArrayList<Integer>());

	if (nums == null || nums.length == 0) return res;

	Arrays.sort(nums);

	for (int i = 0; i< nums.length; i++) {

		int length = res.size();
		for (int j = 0; j < length; j++) {

			List<Integer> list = new ArrayList<Integer>(res.get(j));
			list.add(nums[i]);
			res.add(list);
		}
	}
	return res;
}

// Recursive
public List<List<Integer>> subsets(int[] nums) {

}