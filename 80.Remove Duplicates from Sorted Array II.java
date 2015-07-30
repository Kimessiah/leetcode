// Time O(n)
public int removeDuplicates(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	int count = 0;
	int index = 0;

	for (int i = 0; i < nums.length; i++) {

		if (i >0 && nums[i] == nums[i-1]) {
			count++;
			if (count > 2) continue;
		} else {
			count = 1;
		}
		nums[index++] = nums[i];
	}
	return index;
}