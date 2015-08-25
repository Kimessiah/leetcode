// 2D DP
// local[i][j] = max(global[i-1][j-1] + max(diff,0), local[i-1][j]+diff)
// global[i][j] = max(local[i][j], global[i-1][j])
public int maxProfit(int k, int[] prices) {

	if (prices == null || prices.length == 0 || k <= 0) return 0;

	// To Leetcode OJ
	if (k >= prices.length / 2) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

	int[][] local = new int[prices.length][k+1];
	int[][] global = new int[prices.length][k+1];

	for (int i = 1; i < prices.length; i++) {
		int diff = prices[i] - prices[i-1];
		for (int j = 1; j <= k; j++) {
			local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), 
				local[i-1][j] + diff);
			global[i][j] = Math.max(global[i-1][j], local[i][j]);
		}
	}
	return global[prices.length-1][k];
}


// 1D DP
public int maxProfit(int k, int[] prices) {

	if (prices == null || prices.length == 0 || k <= 0) return 0;

	int[] global = new int[k+1];
	int[] local = new int[k+1];

	for (int i = 0; i < prices.length-1; i++) {
		int diff = prices[i+1] - prices[i]; 
        for(int j = k; j >= 1; j--) {  
            local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j] + diff);  
            global[j] = Math.max(local[j], global[j]);  
        }  
	}  
	return global[k];   
	

}