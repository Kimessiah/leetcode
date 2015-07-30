public List<List<String>> solveNQueens(int n) {

	List<List<String>> res = new ArrayList<List<String>>();

	if (n <= 0) return res;

	helper(res, new int[n], 0, n);

	return res;
}

void helper(List<List<String>> res, int[] columnForRow, int row, int n) {

	if (row == n) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (columnForRow[i] == j) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			list.add(sb.toString());
		}
		res.add(list);
		return;
	}

	for (int col = 0; col < n; col++) {
		columnForRow[row] = col;
		if (checkValid(columnForRow, row, col)) {
			helper(res, columnForRow, row+1, n);
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