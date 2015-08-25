public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	
	List<String> res = new ArrayList<>();
	int prev = lower - 1;

	for (int i = 0; i <= nums.length; i++) {
		int curr = (i == nums.length) ? upper + 1 : nums[i];
		if (curr - prev >= 2) {
			res.add(getRange(prev+1, curr-1));
		}
		prev = curr;
	}
	return res;
}

String getRange(int from, int to) {

	return (from == to) ? String.valueOf(from) : from + "->" + to;
}