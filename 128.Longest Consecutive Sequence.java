// Time O(n)
public int longestConsecutive(int[] nums) {

	if (nums == null || nums.length == 0) return 0;

	Set<Integer> set = new HashSet<Integer>();

	for (int n : nums) {
		set.add(n);
	} 

	int max = 1;

	while (!set.isEmpty()) {

		Iterator iter = set.iterator();
		int item = (Integer) iter.next();
		set.remove(item);

		int len = 1;
		int i = item - 1;

		while (set.contains(i)) {
			set.remove(i--);
			len++;
		}

		i = item + 1;
		while (set.contains(i)) {
			set.remove(i++);
			len++;
		}
		max = Math.max(max, len);
	}
	return max;
}