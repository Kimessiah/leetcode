// Time O(n*n)
public void rotate(int[][] matrix) {

	if (matrix == null || matrix.length == 0) return;

	int n = matrix.length;

	for (int i = 0; i < n/2; i++) {
		for (int j = 0; j < n; j++) {
			int temp = matrix[i][j];
			matrix[i][j] = matrix[n-i-1][j];
			matrix[n-i-1][j] = temp;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j <=i; j++) {
			int temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}
}