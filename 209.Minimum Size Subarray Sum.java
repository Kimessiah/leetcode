// Two Pointer: Time O(n)
public int minSubArrayLen(int s, int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int left = 0;
	int right = 0;
	int sum = 0;
	int res = nums.length+1;

	while (right < nums.length) {
		sum += nums[right];
		while (sum >= s) {
			res = Math.min(res, right - left + 1);
			sum -= nums[left++];
		}
		right++;
	}
	return res == nums.length + 1 ? 0 : res;        
}

// Binary Search: Time O(nlogn)
public int minSubArrayLen(int s, int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int res = nums.length + 1;
	int[] sum = new int[nums.length+1];

	for (int i = 0; i < nums.length; i++) {
		sum[i+1] = sum[i] + nums[i];
		if (sum[i+1] >= s) {
			int j = binarySearch(sum, 0, i, sum[i+1]-s);
			if (j > -1) {
				res = Math.min(res, i-j+1);
			}
		}
	}        
	return res == nums.length+1 ? 0 : res;
}

int binarySearch(int[] sum, int left, int right, int target) {

	while (left+1 < right) {
		int mid = (left + right) / 2;
		if (sum[mid] > target) {
			right = mid;
		} else if (sum[mid] < target) {
			left = mid;
		} else {
			left = mid;
		}
	}

	if (sum[right] <= target) return right;
	if (sum[left] <= target) return left;

	return -1;
}