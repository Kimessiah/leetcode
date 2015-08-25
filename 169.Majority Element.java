// Time O(nlogn)
public int majorityElement(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	Arrays.sort(nums);
	return nums[nums.length / 2];
}

// Moore’s Voting Algorithm: Time O(n)
public int majorityElement(int[] nums) {

	int result = 0;
	int count = 0;

	for (int i = 0; i < nums.length; i++) {
		if (count == 0) {
			result = nums[i];
		} 
		if (result == nums[i]) {
			count++;
		} else {
			count--;
		}
	}
	return result;
}