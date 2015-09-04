// Quick Select: Time O(n)
public int findKthLargest(int[] nums, int k) {

	if (k < 1 || nums == null || nums.length == 0) return 0;

	return kthSmall(nums, 0, nums.length - 1, num.length - k + 1);        
}

int kthSmall(int[] nums, int lo, int hi, int k) {

    if (lo == hi) return nums[lo];

	int pivot = nums[hi];
	int last = lo;
	for (int i = lo; i < hi; i++) {
		if (nums[i] < pivot) {
			swap(nums, last, i);
			last++;
		}
	}
	swap(nums, last, hi);

	if (k == last + 1) {
		return pivot;
	} else if (k < last + 1) {
		return kthSmall(nums, lo, last - 1, k);
	} else {
		return kthSmall(nums, last + 1, hi, k);
	}
}

void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}