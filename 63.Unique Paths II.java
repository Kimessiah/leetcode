// Time O(m*n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {

	if (obstacleGrid == null || obstacleGrid.length == 0) return 0;

	int m = obstacleGrid.length;
	int n = obstacleGrid[0].length;

	int[][] ways = new int[m][n];

	if (obstacleGrid[0][0] != 1) ways[0][0] = 1;

	for (int i = 1; i < m; i++) {
		if (obstacleGrid[i][0] != 1) {
			ways[i][0] = ways[i-1][0];
		}
	}

	for (int j = 1; j < n; j++) {
		if (obstacleGrid[0][j] != 1) {
			ways[0][j] = ways[0][j-1];
		}
	}

	for (int i = 1; i < m; i++) {
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[i][j] != 1) {
				ways[i][j] = ways[i-1][j] + ways[i][j-1];
			}
		}
	}

	return ways[m-1][n-1];
}