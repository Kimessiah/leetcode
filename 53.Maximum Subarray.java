// DP: Time O(n)   Space O(n)
public int maxSubArray(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int[] dp = new int[nums.length];
	dp[0] = nums[0];

	for (int i = 1; i< nums.length; i++) {
		dp[i] = Math.max(dp[i-1]+ nums[i], nums[i]);
	}

	int max = Integer.MIN_VALUE;
	for (int i = 0; i< dp.length; i++) {
		max = Math.max(max, dp[i]);
	}
	return max;
} 


// Divide and Conquer: Time O(nlogn) 
public int maxSubArray(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	return helper(nums, 0, nums.length-1);
}

int helper(int[] nums, int start, int end) {
	if (start <= end) {
		int mid = (start + end) / 2;

		int max = Math.max(helper(nums, start, mid-1), helper(nums, mid+1, end));

		return Math.max(max, maxSumFromMid(nums, start, mid, end));
	}
	return Integer.MIN_VALUE;
}

int maxSumFromMid(int[] nums, int start, int mid, int end) {

	int maxLeft = Integer.MIN_VALUE;
	int sumLeft = 0;
	int maxRight = Integer.MIN_VALUE;
	int sumRight = 0;

	for (int i = mid; i>= start; i--) {
		sumLeft += nums[i];
		maxLeft = Math.max(maxLeft, sumLeft);
	}

	for (int i = mid; i <=end; i++) {
		sumRight += nums[i];
		maxRight = Math.max(maxRight, sumRight);
	}

	return maxLeft + maxRight - nums[mid];
}

