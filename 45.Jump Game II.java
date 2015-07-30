public int jump(int[] nums) {

	if (nums == null || nums.length == 0)
		return 0;

	int step = 0;
	int lastcover = 0; // Max coverage for certain steps
	int maxcover = 0;

	for (int i = 0; i <= maxcover && i< nums.length; i++) {
		if (i > lastcover) {
			step++;
			lastcover = maxcover;
		}

		maxcover = Math.max(maxcover, nums[i] + i);
	}

	if (maxcover < nums.length - 1) return 0;

	return step;
}