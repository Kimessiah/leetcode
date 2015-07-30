public boolean isValidSudoku(char[][] board) {
	if (board == null || board.length != 9 || board[0].length != 9) {
		return false;
	}

	// Check each row
	for (int i = 0; i < 9; i++) {
		boolean[] m = new boolean[9];
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				if (m[board[i][j] - '1']) {
					return false;
				} else {
					m[board[i][j] - '1'] = true;
				}
			}
		}
	}

	// Check each column
	for (int j = 0; j < 9; j++) {
		boolean[] m = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[i][j] != '.') {
				if (m[board[i][j] - '1']) {
					return false;
				} else {
					m[board[i][j] - '1'] = true;
				}
			}
		}
	}

	// Check each 3*3 matrix
	for (int block = 0; block < 9; block++) {
		boolean[] m = new boolean[9];
		for (int i = 0; i< 3; i++) {
			for (int j = 0; j < 3; j++) {
				int row = i + block / 3 * 3;
				int col = j + block % 3 * 3;
				if (board[row][col] != '.') {
					if (m[board[row][col] - '1']) {
						return false;
					} else {
						m[board[row][col] - '1'] = true;
					}
				}
			}
		}
	}
	return true;
}