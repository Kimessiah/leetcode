// Time O(m*n)
public int minPathSum(int[][] grid) {

	if (grid == null || grid.length == 0) return 0;

	int m = grid.length;
	int n = grid[0].length;

	int[][] minPathSum = new int[m][n];

	minPathSum[0][0] = grid[0][0];

	for (int i = 1; i < m; i++) {
		minPathSum[i][0] = grid[i][0] + minPathSum[i-1][0];
	}

	for (int j = 1; j < n; j++) {
		minPathSum[0][j] = grid[0][j] + minPathSum[0][j-1];
	}

	for (int i = 1; i < m; i++) {
		for (int j = 1; j < n; j++) {
			minPathSum[i][j] = Math.min(minPathSum[i-1][j], minPathSum[i][j-1]) + grid[i][j];
		}
	}
	return minPathSum[m-1][n-1];
}