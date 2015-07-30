public int totalNQueens(int n) {

	if (n <= 0) return 0;

	WrapperInt res = new WrapperInt();

	helper(new int[n], 0, n, res);

	return res.sum;
}

void helper(int[] columnForRow, int row, int n, WrapperInt res) {

	if (row == n) {
		res.sum++;
		return;
	}

	for (int col = 0; col < n; col++) {
		columnForRow[row] = col;
		if (checkValid(columnForRow, row, col)) {
			helper(columnForRow, row+1, n, res);
		}
	}
}

boolean checkValid(int[] columnForRow, int row, int col) {
	for (int i = 0; i < row; i++) {
		if (columnForRow[i] == columnForRow[row] 
			|| Math.abs(columnForRow[i] - columnForRow[row]) == row - i) {
			return false;
		}
	}
	return true;
}

class WrapperInt {

	int sum = 0;
}