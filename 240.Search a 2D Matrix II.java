public boolean searchMatrix(int[][] matrix, int target) {

	if (matrix == null || matrix.length == 0) return false;
	if (matrix[0] == null || matrix[0].length == 0) return false;

	int row = 0;
	int col = matrix[0].length-1;

	while (row < matrix.length && col >= 0) {
		if (matrix[row][col] < target) {
			row++;
		} else if (matrix[row][col] > target) {
			col--;
		} else {
			return true;
		}
	}
    return false;
}

// Divide and Conquer
public boolean searchMatrix(int[][] matrix, int target) {

	if (matrix == null || matrix.length == 0) return false;
	if (matrix[0] == null || matrix[0].length == 0) return false;

	return helper(matrix, target, 0, 0, matrix[0].length-1, matrix.length-1);
}

boolean helper(int[][] matrix, int target, int l, int u, int r, int d) {

	if (l > r || u > d) return false;
	if (matrix[u][l] > target || matrix[d][r] < target) return false;

	int col = l + (r-l)/2;
	int row = u + (d-u)/2;

	if (matrix[row][col] == target) {
		return true;
	} else if (l == r && u == d) {
		return false;
	}

	if (matrix[row][col] > target) {
		return helper(matrix, target, col+1, u, r, row)
				|| helper(matrix, target, l, row+1, col, d)
				|| helper(matrix, target, l, u, col, row);
	} else {
		return helper(matrix, target, col+1, u, r, row)
				|| helper(matrix, target, l, row+1, col, d)
				|| helper(matrix, target, col+1, row+1, r, d);
	}
}