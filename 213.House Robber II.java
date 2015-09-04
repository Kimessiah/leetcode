public int rob(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	if (nums.length == 1) return nums[0];

	int[] map1 = new int[nums.length];
	map1[1] = nums[0];
	for (int i = 2; i < nums.length; i++) {
		map1[i] = Math.max(map1[i-1], map1[i-2] + nums[i-1]);
	}

	int[] map2 = new int[nums.length];
	map2[1] = nums[1];
	for (int i = 2; i < nums.length; i++) {
		map2[i] = Math.max(map2[i-1], map2[i-2] + nums[i]);
	}

	return Math.max(map1[nums.length-1], map2[nums.length-1]);
}