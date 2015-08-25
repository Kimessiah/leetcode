public int maxProduct(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int min = nums[0];
	int max = nums[0];
	int maxAns = nums[0];

	for (int i = 1; i < nums.length; i++) {
		int mx = max;
		int mn = min;
		max = Math.max(Math.max(mx * nums[i], nums[i]), nums[i] * mn);
		min = Math.min(Math.min(mx * nums[i], nums[i]), nums[i] * mn);
		maxAns = Math.max(max, maxAns);
	}
	return maxAns;
}