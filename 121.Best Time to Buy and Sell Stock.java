// Time O(n)   Space O(n)
public int maxProfit(int[] prices) {

	if (prices == null || prices.length < 2) return 0;

	int[] res = new int[prices.length-1];

	for (int i = 0; i < prices.length-1; i++) {
		res[i] = Math.max(0, (i > 0 ? res[i-1] : 0) + prices[i+1] - prices[i]);
	}

	int max = 0;
	for (int i = 0; i < res.length; i++) {
		max = Math.max(res[i], max);
	}
	return max;
}

// Time O(n)   Space O(1)
public in maxProfit(int[] prices) {

	if (prices == null || prices.length == 0) return 0;

	int local = 0;
	int global = 0;

	for (int i = 0; i < prices.length-1; i++) {
		local = Math.max(local + prices[i+1] - prices[i], 0);
		global = Math.max(local, global);
	}
	return global;
}