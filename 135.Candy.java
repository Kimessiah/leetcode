public int candy(int[] ratings) {

	if (ratings == null || ratings.length == 0) return 0;

	int[] nums = new int[ratings.length];
	nums[0] = 1;

	for (int i = 1; i < nums.length; i++) {
		if (ratings[i] > ratings[i-1]) {
			nums[i] = nums[i-1] + 1;
		} else {
			nums[i] = 1;
		}
	}

	int res = nums[ratings.length-1];
	for (int i = ratings.length-2; i >= 0; i--) {
		int n = 1;
		if (ratings[i] > ratings[i+1]) {
			n = nums[i+1] + 1;
		}
		res += Math.max(n, nums[i]);
		nums[i] = n;
	}
	return res;
}