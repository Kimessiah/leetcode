// Time O(logm + logn)
public boolean searchMatrix(int[][] matrix, int target) {

	if (matrix == null || matrix.length == 0) return false;

	if (matrix[0] == null || matrix[0].length == 0) return false;

	int row = matrix.length;
	int col = matrix[0].length;

	int start = 0; int end = row - 1;
	while (start + 1 < end) {
		int mid = start + (end - start)/2;

		if (matrix[mid][0] == target) {
			return true;
		} else if (matrix[mid][0] < target) {
			start = mid;
		} else {
			end = mid;
		}
	}

	if (matrix[end][0] <= target) {
		row = end;
	} else if (matrix[start][0] <= target) {
		row = start;
	} else  {
		return false;
	}

	start = 0;
	end = col - 1;

	while (start+1 < end) {
		int mid = start + (end-start)/2;

		if (matrix[row][mid] == target) {
			return true;
		} else if (matrix[row][mid] < target) {
			start = mid;
		} else {
			end = mid;
		}
	}

	if (matrix[row][start] == target) {
		return true;
	} else if (matrix[row][end] == target) {
		return true;
	} else {
		return false;
	}
}