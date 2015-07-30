// O(n^2 + nlogn)
public List<List<Integer>> threeSum(int[] nums) {

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	if (nums.length == 0) return res;

	Arrays.sort(nums);

	for (int i=0; i<nums.length-2; i++) {
		if (i>0 && nums[i] == nums[i-1]) continue;   // Eliminate duplicates
		int left = i + 1;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[i] + nums[left] + nums[right] == 0) {
				List<Integer> curr = new ArrayList<Integer>();
				curr.add(nums[i]); 
				curr.add(nums[left]); 
				curr.add(nums[right]);
				res.add(curr);
				left++;
				right--;
				while(left <right && nums[left-1] ==nums[left]) left++;     // Eliminate duplicates
                while(left <right && nums[right+1] ==nums[right]) right--;	// Eliminate duplicates
			} else if (nums[i] + nums[left] + nums[right] < 0) {
				left++;
			} else {
				right--;
			}
		}
	}
	return res;
}