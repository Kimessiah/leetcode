// Time O(n)   Space O(1)
public void rotate(int[] nums, int k) {

	if (nums == null || nums.length == 0 || k < 0) return;

	k = k % nums.length;
	reverse(nums, 0, nums.length);
	reverse(nums, 0, k);
	reverse(nums, k, nums.length);
}

void reverse(int[] nums, int start, int end) {
	for (int i = 0; i < (end - start) / 2; i++) {
		int temp = nums[start + i];
		nums[start + i] = nums[end - i - 1]; 
		nums[end - i - 1] = temp;
	}
}