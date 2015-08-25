public int singleNumber(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int[] digits = new int[32];

	for (int i = 0; i < 32; i++) {
		for (int j = 0; j < nums.length; j++) {
			digits[i] += (nums[j] >> i) & 1;
		}
	}

	int res = 0;
	for (int i = 0; i < 32; i++) {
		res += (digits[i] % 3) << i;
	}
	return res;
}