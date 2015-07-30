public int[][] generateMatrix(int n) {

	if (n <= 0) return null;

	int[][] matrix = new int[n][n];
	int levelNum = n / 2;
	int num = 1;

	for (int level = 0; level < levelNum; level++) {

		for (int i = level; i < n-level-1; i++) {
			matrix[level][i] = num++;
		}

		for (int i = level; i < n-level-1; i++) {
			matrix[i][n-level-1] = num++;
		}

		for (int i = n-level-1; i > level; i--) {
			matrix[n-level-1][i] = num++;
		}

		for (int i = n-level-1; i > level; i--) {
			matrix[i][level] = num++;
		}
	}

	if (n % 2 == 1) {
		matrix[n/2][n/2] = num;
	}

	return matrix;
}