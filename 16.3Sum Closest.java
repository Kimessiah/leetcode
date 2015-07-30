// O(n^2 + nlogn)
public int threeSumClosest(int[] nums, int target) {

	if (nums.length == 0) return 0;

	int closest = 0;
	int delta = Integer.MAX_VALUE;
	Arrays.sort(nums);
	for (int i=0; i<nums.length-2; i++) {
		int left = i + 1;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[i] + nums[left] + nums[right];
			if (sum == target) {
				return target;
			} else if (sum < target) {
				if (Math.abs(target-sum) < delta)	{
					closest = sum;
					delta = Math.abs(target-sum);
				}
				left++;
			} else {
				if (Math.abs(target-sum) < delta)	{
					closest = sum;
					delta = Math.abs(target-sum);
				}
				right--;
			}
		}
	}
	return closest;
}