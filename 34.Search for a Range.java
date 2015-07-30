// Time O(logn)  Space O(1)
public int[] searchRange(int[] nums, int target) {

	int[] range = new int[]{-1, -1};
	if (nums.length == 0) return range;

	int start = 0;
	int end = nums.length - 1;
	while (start + 1 < end) {
		int mid = start + (end - start)/2;
		if (nums[mid] == target) {
			end = mid;
		} else if (nums[mid] > target) {
			end = mid;
		} else {
			start = mid;
		}
	}
	if (nums[start] == target) {
		range[0] = start;
	} else if (nums[end] == target) {
		range[0] = end;
	}

	start = 0;
	end = nums.length - 1;
	while (start + 1 < end) {
		int mid = start + (end - start)/2;
		if (nums[mid] == target) {
			start = mid;
		} else if (nums[mid] > target) {
			end = mid;
		} else {
			start = mid;
		}
	}
	if (nums[end] == target) {
		range[1] = end;
	} else if (nums[start] == target) {
		range[1] = start;
	}
	return range;
}