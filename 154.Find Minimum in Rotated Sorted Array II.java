public int findMin(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int start = 0;
	int end = nums.length - 1;

	while (start + 1 < end && nums[start] >= nums[end]) {

		int mid = start + (end - start) / 2;
		if (nums[mid] > nums[end]) {
			start = mid;
		} else if (nums[mid] < nums[end]) {
			end = mid;
		} else {
			start++;
		}
	}
	return Math.min(nums[start], nums[end]);
}