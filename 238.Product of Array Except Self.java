// Time O(n)   Space O(n)
public int[] productExceptSelf(int[] nums) {

	if (nums == null || nums.length == 0) return new int[0];
	
	int[] left = new int[nums.length];
	int[] right = new int[nums.length];

	left[0] = 1;
	right[nums.length-1] = 1;

	for (int i = 1; i < nums.length; i++) {
		left[i] = left[i-1] * nums[i-1];
	} 

	for (int i = nums.length-2; i >= 0; i--) {
		right[i] = right[i+1] * nums[i+1];
	}

	int[] res = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
		res[i] = left[i] * right[i];
	}

	return res;
}

// Time O(n)   Space O(1)
public int[] productExceptSelf(int[] nums) {

	if (nums == null || nums.length == 0) return new int[0];

	int[] res = new int[nums.length];
	res[nums.length-1] = 1;

	for (int i = nums.length-2; i >= 0; i--) {
		res[i] = res[i+1] * nums[i+1];
	}

	int left = 1;
	for (int i = 0; i < nums.length; i++) {
		res[i] *= left;
		left *= nums[i];
	}

	return res;
}
