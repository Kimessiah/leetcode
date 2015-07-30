// Time O(n^2)  Space O(n)
public String getPermutation(int n, int k) {

	if (n <= 0) return null;

	List<Integer> nums = new ArrayList<Integer>();
	int factorial = 1;

	k--;   // Match with List index 0...n-1

	for (int i = 2; i < n; i++) {
		factorial *= i;
	}

	for (int i = 1; i <= n; i++) {
		nums.add(i);
	}

	StringBuilder sb = new StringBuilder();
	int round = n-1;

	while (round >= 0) {

		int index = k / factorial;
		k %= factorial;

		sb.append(nums.get(index));
		nums.remove(index);

		if (round > 0) factorial /= round;

		round--;
	}
	return sb.toString();
}