// Bucket Sort: O(n)
public int maximumGap(int[] nums) {

	if (nums == null || nums.length < 2) return 0;

	int n = nums.length;

	int min = nums[0];
	int max = nums[0];
	for (int i = 0; i < n; i++) {
		min = Math.min(min, nums[i]);
		max = Math.max(max, nums[i]);
	}

	Bucket[] buckets = new Bucket[n+1];
	for (int i = 0; i <= n; i++) {
		buckets[i] = new Bucket();
	}

	double interval = (double) n / (max - min);

	for (int i = 0; i < n; i++) {
		int index = (int) ((nums[i] - min) * interval);
		if (buckets[index].min == -1) {
			buckets[index].min = nums[i];
			buckets[index].max = nums[i];
		} else {
			buckets[index].min = Math.min(buckets[index].min, nums[i]);
			buckets[index].max = Math.max(buckets[index].max, nums[i]);
		}
	}

	int maxGap = 0;
	int prev = buckets[0].max;
	for (int i = 1; i <= n; i++) {
		if (buckets[i].min == -1) {
			continue;
		}
		maxGap = Math.max(maxGap, buckets[i].min - prev);
		prev = buckets[i].max;
	}
	return maxGap;
}

class Bucket {

	int min;
	int max;
	public Bucket() {
		min = -1;
		max = -1;
	}
}