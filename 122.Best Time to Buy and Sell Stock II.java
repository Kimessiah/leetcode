// Time O(n)   Space O(1)
public int maxProfit(int[] prices) {

	if (prices == null || prices.length < 2) return 0;

	int max = 0;

	for (int i = 0; i < prices.length-1; i++) {
		max += Math.max(0, prices[i+1] - prices[i]);
	}
	return max;
}